package be.arcaniax.liquidtanks;

import be.arcaniax.liquidtanks.utilities.VersionManager;
import be.arcaniax.liquidtanks.utilities.headURL;
import be.arcaniax.liquidtanks.utilities.types;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Hopper;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class Main extends org.bukkit.plugin.java.JavaPlugin implements org.bukkit.event.Listener
{
  public static Main instance;
  static String itemName;
  public static HashMap<Location, liquidTank> locHashMap = new HashMap<Location, liquidTank>();
  public static liquidTankType emptyType = new liquidTankType(types.empty, 24, null);
  public static liquidTankType experienceType = new liquidTankType(types.experience, 1395, headURL.create(headURL.experienceB64));
  public static liquidTankType lavaType = new liquidTankType(types.lava, 24, headURL.create(headURL.lavaB64));
  public static liquidTankType waterType = new liquidTankType(types.water, 24, headURL.create(headURL.waterB64));
  public static liquidTankType milkType = new liquidTankType(types.milk, 24, headURL.create(headURL.milkB64));
  public static liquidTankType mushroomStewType = new liquidTankType(types.mushroomStew, 16, headURL.create(headURL.mushroomStewB64));
  public static liquidTankType rabbitStewType = new liquidTankType(types.rabbitStew, 16, headURL.create(headURL.rabbitStewB64));
  public static liquidTankType dragonBreathType = new liquidTankType(types.dragonBreath, 24, headURL.create(headURL.dragonBreathB64));
  public static liquidTankType beetrootSoupType = new liquidTankType(types.beetroot, 16, headURL.create(headURL.beetrootB64));
  public static File tanksDatabase;
  
  public Main() {}
  
  public void onEnable() {
    locHashMap = new HashMap<Location, liquidTank>();
    saveDefaultConfig();
    instance = this;
    vm = new VersionManager();
    itemName = getConfig().getString("item-name").replace("&", "§");
    lavaType = new liquidTankType(types.lava, getConfig().getInt("lava-amount"), headURL.create(headURL.lavaB64));
    waterType = new liquidTankType(types.water, getConfig().getInt("water-amount"), headURL.create(headURL.waterB64));
    milkType = new liquidTankType(types.milk, getConfig().getInt("milk-amount"), headURL.create(headURL.milkB64));
    mushroomStewType = new liquidTankType(types.mushroomStew, getConfig().getInt("mushroomStew-amount"), headURL.create(headURL.mushroomStewB64));
    rabbitStewType = new liquidTankType(types.rabbitStew, getConfig().getInt("rabbitStew-amount"), headURL.create(headURL.rabbitStewB64));
    dragonBreathType = new liquidTankType(types.dragonBreath, getConfig().getInt("dragonBreath-amount"), headURL.create(headURL.dragonBreathB64));
    beetrootSoupType = new liquidTankType(types.beetroot, getConfig().getInt("beetroot-amount"), headURL.create(headURL.beetrootB64));
    Bukkit.getServer().getPluginManager().registerEvents(this, this);
    getLogger().info("Made by Arcaniax");
    
    loopEvery5Seconds();
    loopEvery30Seconds();
    loopEvery10Ticks();
    loopEveryMinute();
    addLiquidTankRecipe();
    try {
      if (!getDataFolder().exists()) {
        getDataFolder().mkdirs();
      }
      tanksDatabase = new File(getDataFolder(), "barrels.yml");
      if (!tanksDatabase.exists()) {
        getLogger().info("\"tanks.yml\" was not found!");
        getLogger().info("Creating a new one!");
        tanksDatabase.createNewFile();
        tanks = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(tanksDatabase);
      } else {
        getLogger().info("Tank database found, loading all the tanks!");
        tanks = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(tanksDatabase);
        loadTanksFromDatabase();
      }
    } catch (Exception localException) {
      localException.printStackTrace();
    } }
  
  public static FileConfiguration tanks;
  public static VersionManager vm;
  public void onDisable() { 
	int i = 0;
    getLogger().info("Saving Liquid Tanks!");
    tanks.set("tanks", "");
    try {
      tanks.save(tanksDatabase); } catch (IOException localIOException1) {}
    Iterator<? extends Player> localIterator2;
    for (Iterator<Location> localIterator1 = locHashMap.keySet().iterator(); localIterator1.hasNext(); 
        localIterator2.hasNext())
    {
      Location localLocation = (Location)localIterator1.next();
      i++;
      String str = localLocation.getBlockX() + "_" + localLocation.getBlockY() + "_" + localLocation.getBlockZ() + "_" + localLocation.getWorld().getName();
      tanks.set("tanks." + str + ".tankType", String.valueOf((liquidTank)locHashMap.get(localLocation)).getBytes().toString());
      tanks.set("tanks." + str + ".quantity", Integer.valueOf(((liquidTank)locHashMap.get(localLocation)).getQuantity()));
      localIterator2 = Bukkit.getOnlinePlayers().iterator();
      
      while(localIterator2.hasNext()) {
          Player localPlayer = (Player)localIterator2.next();
          ((liquidTank)locHashMap.get(localLocation)).removeDisplay(localPlayer);  
      }
    }
    try
    {
      tanks.save(tanksDatabase);
    } catch (IOException localIOException2) {}
    getLogger().info("Saved " + i + " Liquid Tanks!");
  }
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void placeOfLiquidTank(BlockPlaceEvent paramBlockPlaceEvent) {
    if (paramBlockPlaceEvent.isCancelled()) return;
    try {
        if ((!paramBlockPlaceEvent.getPlayer().hasPermission("liquidtanks.use")) && (getConfig().getBoolean("enable-permission"))) {
          paramBlockPlaceEvent.setCancelled(true);
          return;
        }
        if ((!paramBlockPlaceEvent.getBlock().getType().equals(Material.HOPPER)) || (!paramBlockPlaceEvent.getItemInHand().getItemMeta().getDisplayName().equals(itemName))) return;
        liquidTank localLiquidTank = vm.createLiquidTank(paramBlockPlaceEvent.getBlock().getLocation());
        locHashMap.put(paramBlockPlaceEvent.getBlock().getLocation(), localLiquidTank);
        localLiquidTank.setType(emptyType);
      }
      catch (Exception localException) {}
  }
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void breakOfLiquidTank(BlockBreakEvent paramBlockBreakEvent)
  {
    if (paramBlockBreakEvent.isCancelled()) return;
    if (!paramBlockBreakEvent.getBlock().getType().equals(Material.HOPPER)) return;
    if (!locHashMap.containsKey(paramBlockBreakEvent.getBlock().getLocation())) return;
    paramBlockBreakEvent.setCancelled(true);
    if ((!paramBlockBreakEvent.getPlayer().hasPermission("liquidtanks.use")) && (getConfig().getBoolean("enable-permission"))) return;
    liquidTank localLiquidTank = (liquidTank)locHashMap.get(paramBlockBreakEvent.getBlock().getLocation());
    if (paramBlockBreakEvent.getPlayer().getGameMode().equals(org.bukkit.GameMode.CREATIVE)) localLiquidTank.removeTank(false); else {
      localLiquidTank.removeTank(true);
    }
  }
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void rightClickOnLiquidTank(PlayerInteractEvent paramPlayerInteractEvent) {
    if (paramPlayerInteractEvent.isCancelled()) return;
    if ((!paramPlayerInteractEvent.getAction().equals(org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK)) || (!paramPlayerInteractEvent.getClickedBlock().getType().equals(Material.HOPPER))) return;
    try {
        if ((!paramPlayerInteractEvent.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR)) && (paramPlayerInteractEvent.getPlayer().getInventory().getItemInMainHand().getType().isBlock()) && (paramPlayerInteractEvent.getPlayer().isSneaking())) return;
        if (!locHashMap.containsKey(paramPlayerInteractEvent.getClickedBlock().getLocation())) return;
        paramPlayerInteractEvent.setCancelled(true);
        if ((!paramPlayerInteractEvent.getPlayer().hasPermission("liquidtanks.use")) && (getConfig().getBoolean("enable-permission"))) return;
        liquidTank localLiquidTank = (liquidTank)locHashMap.get(paramPlayerInteractEvent.getClickedBlock().getLocation());
        vm.getTankInteract().clickOnLiquidTank(paramPlayerInteractEvent.getPlayer(), localLiquidTank);
      } catch (Exception localException) {}
  }
  
  @EventHandler
  public void onLiquidTankOpen(InventoryOpenEvent paramInventoryOpenEvent) {
    try {
      if (paramInventoryOpenEvent.getInventory().getTitle().equals(itemName)) {
        paramInventoryOpenEvent.setCancelled(true);
      }
    }
    catch (Exception localException) {}
  }
  
  @EventHandler
  public void onMove(PlayerMoveEvent paramPlayerMoveEvent) {
    for (Location localLocation : locHashMap.keySet()) {
      if (isLoaded(localLocation)) {
        if ((localLocation.getWorld() == paramPlayerMoveEvent.getPlayer().getWorld()) && (localLocation.distance(paramPlayerMoveEvent.getPlayer().getLocation()) <= 20.0D)) {
          ((liquidTank)locHashMap.get(localLocation)).display(paramPlayerMoveEvent.getPlayer());
        }
        else {
          ((liquidTank)locHashMap.get(localLocation)).removeDisplay(paramPlayerMoveEvent.getPlayer());
        }
      }
    }
  }
  
  public static boolean isLoaded(Location paramLocation)
  {
    int i = paramLocation.getBlockX() >> 4;
    int j = paramLocation.getBlockZ() >> 4;
    if (paramLocation.getWorld().isChunkLoaded(i, j)) {
      return true;
    }
    return false;
  }
  
  @EventHandler
  public void onJoin(PlayerJoinEvent paramPlayerJoinEvent) {
    for (Location localLocation : locHashMap.keySet()) {
      if ((isLoaded(localLocation)) && 
        (localLocation.getWorld() == paramPlayerJoinEvent.getPlayer().getWorld()) && (localLocation.distance(paramPlayerJoinEvent.getPlayer().getLocation()) <= 20.0D)) {
        ((liquidTank)locHashMap.get(localLocation)).removeDisplay(paramPlayerJoinEvent.getPlayer());
        ((liquidTank)locHashMap.get(localLocation)).display(paramPlayerJoinEvent.getPlayer());
      }
    }
  }
  
  @EventHandler
  public void itemCraftEvent(CraftItemEvent paramCraftItemEvent)
  {
    ItemStack localItemStack = new ItemStack(Material.HOPPER, 1);
    ItemMeta localItemMeta = localItemStack.getItemMeta();
    localItemMeta.setDisplayName(itemName);
    localItemStack.setItemMeta(localItemMeta);
    if ((paramCraftItemEvent.getCurrentItem().equals(localItemStack)) && 
      (!paramCraftItemEvent.getWhoClicked().hasPermission("liquidtanks.craft")) && (getConfig().getBoolean("enable-permission"))) {
      paramCraftItemEvent.setCancelled(true);
      return;
    }
  }
  
  @EventHandler
  public void InventoryPickupItemEvent(InventoryPickupItemEvent paramInventoryPickupItemEvent)
  {
    if ((paramInventoryPickupItemEvent.getInventory().getType().equals(InventoryType.HOPPER)) && (paramInventoryPickupItemEvent.getInventory().getTitle().equals(itemName))) paramInventoryPickupItemEvent.setCancelled(true);
  }
  
  @EventHandler
  public void InventoryMoveItemEvent(InventoryMoveItemEvent paramInventoryMoveItemEvent) { if ((paramInventoryMoveItemEvent.getSource().getType().equals(InventoryType.HOPPER)) && (paramInventoryMoveItemEvent.getSource().getTitle().equals(itemName))) {
      paramInventoryMoveItemEvent.setCancelled(true);
    }
    if ((paramInventoryMoveItemEvent.getDestination().getType().equals(InventoryType.HOPPER)) && (paramInventoryMoveItemEvent.getDestination().getTitle().equals(itemName))) {
      paramInventoryMoveItemEvent.setCancelled(true);
      InventoryHolder localInventoryHolder = paramInventoryMoveItemEvent.getDestination().getHolder();
      if ((localInventoryHolder != null) && ((localInventoryHolder instanceof Hopper))) {
        Hopper localHopper = (Hopper)localInventoryHolder;
        if (!locHashMap.containsKey(localHopper.getLocation())) return;
        paramInventoryMoveItemEvent.setCancelled(true);
        liquidTank localLiquidTank = (liquidTank)locHashMap.get(localHopper.getLocation());
        vm.getTankInteract().itemMoveInLiquidTank(paramInventoryMoveItemEvent.getItem(), localLiquidTank, paramInventoryMoveItemEvent);
      }
    }
  }
  
  private void loadTanksFromDatabase() {
    int i = 0;
    try {
      for (String str1 : tanks.getConfigurationSection("tanks").getKeys(false)) {
        i++;
        int j = 0;
        double d1 = 0.0D;double d2 = 0.0D;double d3 = 0.0D;
        String str2 = null;
        String[] arrayOfString = str1.split("_");
        d1 = Integer.parseInt(arrayOfString[0]);
        d2 = Integer.parseInt(arrayOfString[1]);
        d3 = Integer.parseInt(arrayOfString[2]);
        World localWorld = getServer().getWorld(arrayOfString[3]);
        Object localObject1 = new Location(localWorld, d1, d2, d3);
        for (Object localObject2 = tanks.getConfigurationSection("tanks." + str1).getKeys(false).iterator(); ((Iterator<?>)localObject2).hasNext();) { localObject1 = (String)((Iterator<?>)localObject2).next();
          if (((String)localObject1).contains("tankType")) { str2 = tanks.getString("tanks." + str1 + "." + (String)localObject1);
          } else if (((String)localObject1).contains("quantity")) j = tanks.getInt("tanks." + str1 + "." + (String)localObject1);
        }
        liquidTank localObject2 = vm.createLiquidTank((Location)localObject1, j, str2);
        locHashMap.put((Location) localObject1, localObject2);
        ((liquidTank)localObject2).updateVisuals();
      }
    } catch (Exception localException) {}
    getLogger().info("Loaded " + i + " Liquid tanks!");
  }
  
  private void loopEvery5Seconds()
  {
    Bukkit.getScheduler().runTaskTimer(this, 
      new Runnable()
      {

        public void run() {}

      }, 100L, 100L);
  }
  
  private void loopEvery30Seconds() {
    Bukkit.getScheduler().runTaskTimer(this, 
      new Runnable()
      {
        public void run() {
          repeatingTasks.cowFilling();
          repeatingTasks.mushCowFilling();
          repeatingTasks.magmaCubeFilling();
        }
      }, 600L, 600L);
  }
  
  private void loopEvery10Ticks() {
    Bukkit.getScheduler().runTaskTimer(this, 
      new Runnable()
      {
        public void run() {
          repeatingTasks.playerExpFilling();
          repeatingTasks.playerExportFromTank();
          repeatingTasks.checkTank();
        }
      }, 10L, 10L);
  }
  
  private void loopEveryMinute() {
    Bukkit.getScheduler().runTaskTimerAsynchronously(this, 
      new Runnable()
      {
        public void run() {
          Main.tanks.set("tanks", null);
          try {
            Main.tanks.save(Main.tanksDatabase);
          } catch (IOException localIOException1) {}
          for (Location localLocation : Main.locHashMap.keySet()) {
            String str = localLocation.getBlockX() + "_" + localLocation.getBlockY() + "_" + localLocation.getBlockZ() + "_" + localLocation.getWorld().getName();
            Main.tanks.set("tanks." + str + ".tankType", String.valueOf(((liquidTank)Main.locHashMap.get(localLocation)).getType().toString()));
            Main.tanks.set("tanks." + str + ".quantity", Integer.valueOf(((liquidTank)Main.locHashMap.get(localLocation)).getQuantity()));
          }
          try {
            Main.tanks.save(Main.tanksDatabase);
          } catch (IOException localIOException2) {}
        }
      }, 1200L, 1200L);
  }
  
  public static void equipHelmet(final ItemStack paramItemStack, ArmorStand paramArmorStand) {
    Bukkit.getScheduler().runTaskLater(instance, 
      new Runnable()
      {
        public void run() {
        	paramArmorStand.setHelmet(paramItemStack);
        }
      }, 2L);
  }
  
  public static void removeItem(Inventory paramInventory, final Material paramMaterial) { Bukkit.getScheduler().runTaskLater(instance, 
      new Runnable()
      {
        public void run() {
        	paramInventory.remove(paramMaterial);
        }
      }, 0L);
  }
  
  private void addLiquidTankRecipe() {
    ItemStack localItemStack = new ItemStack(Material.HOPPER, 1);
    ItemMeta localItemMeta = localItemStack.getItemMeta();
    localItemMeta.setDisplayName(itemName);
    localItemStack.setItemMeta(localItemMeta);
    @SuppressWarnings("deprecation")
	ShapedRecipe localShapedRecipe = new ShapedRecipe(localItemStack);
    localShapedRecipe.shape(new String[] { 
      "BAB", 
      "BAB", 
      "BSB" });
    localShapedRecipe.setIngredient('A', Material.AIR);
    localShapedRecipe.setIngredient('B', Material.WOOD);
    localShapedRecipe.setIngredient('S', Material.WOOD_STEP);
    getServer().addRecipe(localShapedRecipe);
  }
  
  public static void addItems(Block paramBlock) { Bukkit.getScheduler().runTaskLater(instance, 
      new Runnable()
      {
        public void run() {
          Block b = paramBlock;
        	
        	if (b.getType().equals(Material.HOPPER)) {
            Hopper localHopper = (Hopper)b.getState();
            localHopper.getInventory().setItem(3, new ItemStack(Material.GLASS, 7));
            localHopper.getInventory().setItem(4, new ItemStack(Material.REDSTONE_COMPARATOR, 1));
          }
        }
      }, 2L);
  }
  
  public static void createInventory(InventoryHolder paramInventoryHolder) { Bukkit.createInventory(paramInventoryHolder, InventoryType.HOPPER, itemName); }
}
