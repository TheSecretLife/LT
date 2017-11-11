package be.arcaniax.liquidtanks;

import be.arcaniax.liquidtanks.Main;
import be.arcaniax.liquidtanks.liquidTank;
import be.arcaniax.liquidtanks.utilities.experienceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Furnace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class repeatingTasks {

   public static void furnacePowering() {
      Iterator<liquidTank> var1 = Main.locHashMap.values().iterator();

      while(var1.hasNext()) {
         liquidTank var0 = (liquidTank)var1.next();
         if(var0.getType() == Main.lavaType && isLoaded(var0.getLoc())) {
            ArrayList<Block> var2 = new ArrayList<Block>();
            var2.add(var0.getLoc().getBlock().getRelative(BlockFace.DOWN));
            var2.add(var0.getLoc().getBlock().getRelative(BlockFace.SOUTH));
            var2.add(var0.getLoc().getBlock().getRelative(BlockFace.NORTH));
            var2.add(var0.getLoc().getBlock().getRelative(BlockFace.WEST));
            var2.add(var0.getLoc().getBlock().getRelative(BlockFace.EAST));
            Iterator<Block> var4 = var2.iterator();

            while(var4.hasNext()) {
               Block var3 = (Block)var4.next();
               if(var0.getQuantity() == 0) {
                  return;
               }

               if(var3.getType().equals(Material.FURNACE)) {
                  Furnace var5 = (Furnace)var3.getState();
                  ItemStack var6 = null;

                  try {
                     var6 = var5.getInventory().getItem(0);
                  } catch (Exception var8) {
                     ;
                  }

                  if(var6 != null && var5.getBurnTime() == 0) {
                     var5.setBurnTime((short)6667);
                     if(var0.getQuantity() > 1) {
                        var0.setQuantity(var0.getQuantity() - 1);
                        var0.updateVisuals();
                     } else if(var0.getQuantity() == 1) {
                        var0.setType(Main.emptyType);
                        var0.setQuantity(0);
                        var0.updateVisuals();
                     }
                  }
               }
            }
         }
      }

   }

   public static boolean isLoaded(Location var0) {
      int var1 = var0.getBlockX() >> 4;
      int var2 = var0.getBlockZ() >> 4;
      return var0.getWorld().isChunkLoaded(var1, var2);
   }

   public static void cowFilling() {
      Iterator<?> var1 = Bukkit.getWorlds().iterator();

      while(var1.hasNext()) {
         World var0 = (World)var1.next();
         Iterator<?> var3 = var0.getEntities().iterator();

         while(var3.hasNext()) {
            Entity var2 = (Entity)var3.next();
            if(var2.getType().equals(EntityType.COW) && isLoaded(var2.getLocation()) && var2.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.HOPPER)) {
               Location var4 = var2.getLocation().getBlock().getRelative(BlockFace.DOWN).getLocation();
               Random var5 = new Random();
               if(Main.locHashMap.containsKey(var4) && var5.nextInt(10) == 0) {
                  liquidTank var6 = (liquidTank)Main.locHashMap.get(var4);
                  if(var6.getType().equals(Main.milkType) && var6.getQuantity() < var6.getMaxQuantity()) {
                     var6.setQuantity(var6.getQuantity() + 1);
                     var6.updateVisuals();
                  } else if(var6.getType().equals(Main.emptyType)) {
                     var6.setType(Main.milkType);
                     var6.setQuantity(1);
                     var6.updateVisuals();
                  }
               }
            }
         }
      }

   }

   public static void mushCowFilling() {
      Iterator<?> var1 = Bukkit.getWorlds().iterator();

      while(var1.hasNext()) {
         World var0 = (World)var1.next();
         Iterator<?> var3 = var0.getEntities().iterator();

         while(var3.hasNext()) {
            Entity var2 = (Entity)var3.next();
            if(var2.getType().equals(EntityType.MUSHROOM_COW) && isLoaded(var2.getLocation()) && var2.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.HOPPER)) {
               Location var4 = var2.getLocation().getBlock().getRelative(BlockFace.DOWN).getLocation();
               Random var5 = new Random();
               if(Main.locHashMap.containsKey(var4) && var5.nextInt(10) == 0) {
                  liquidTank var6 = (liquidTank)Main.locHashMap.get(var4);
                  if(var6.getType().equals(Main.milkType) && var6.getQuantity() < var6.getMaxQuantity()) {
                     var6.setQuantity(var6.getQuantity() + 1);
                     var6.updateVisuals();
                  } else if(var6.getType().equals(Main.mushroomStewType) && var6.getQuantity() < var6.getMaxQuantity()) {
                     var6.setQuantity(var6.getQuantity() + 1);
                     var6.updateVisuals();
                  } else if(var6.getType().equals(Main.emptyType)) {
                     var6.setType(Main.mushroomStewType);
                     var6.setQuantity(1);
                     var6.updateVisuals();
                  }
               }
            }
         }
      }

   }

   public static void magmaCubeFilling() {
      Iterator<?> var1 = Bukkit.getWorlds().iterator();

      while(var1.hasNext()) {
         World var0 = (World)var1.next();
         Iterator<?> var3 = var0.getEntities().iterator();

         while(var3.hasNext()) {
            Entity var2 = (Entity)var3.next();
            if(var2.getType().equals(EntityType.MAGMA_CUBE) && isLoaded(var2.getLocation())) {
               MagmaCube var4 = (MagmaCube)var2;
               if(var4.getSize() == 2 && var2.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.HOPPER)) {
                  Location var5 = var2.getLocation().getBlock().getRelative(BlockFace.DOWN).getLocation();
                  Random var6 = new Random();
                  if(Main.locHashMap.containsKey(var5) && var6.nextInt(10) == 0) {
                     liquidTank var7 = (liquidTank)Main.locHashMap.get(var5);
                     if(var7.getType().equals(Main.lavaType) && var7.getQuantity() + 3 <= var7.getMaxQuantity()) {
                        var7.setQuantity(var7.getQuantity() + 3);
                        var7.updateVisuals();
                     } else if(var7.getType().equals(Main.emptyType)) {
                        var7.setType(Main.lavaType);
                        var7.setQuantity(3);
                        var7.updateVisuals();
                     }
                  }
               }

               if(var4.getSize() == 4) {
                  ArrayList<Block> var10 = new ArrayList<Block>();
                  var10.add(var2.getLocation().add(0.5D, -1.0D, 0.5D).getBlock());
                  var10.add(var2.getLocation().add(-0.5D, -1.0D, 0.5D).getBlock());
                  var10.add(var2.getLocation().add(-0.5D, -1.0D, -0.5D).getBlock());
                  var10.add(var2.getLocation().add(0.5D, -1.0D, -0.5D).getBlock());
                  Iterator<Block> var12 = var10.iterator();

                  while(var12.hasNext()) {
                     Block var11 = (Block)var12.next();
                     if(var11.getType().equals(Material.HOPPER)) {
                        Random var8 = new Random();
                        if(Main.locHashMap.containsKey(var11.getLocation()) && var8.nextInt(4) == 0) {
                           liquidTank var9 = (liquidTank)Main.locHashMap.get(var11.getLocation());
                           if(var9.getType().equals(Main.lavaType) && var9.getQuantity() < var9.getMaxQuantity()) {
                              var9.setQuantity(var9.getQuantity() + 1);
                              var9.updateVisuals();
                           } else if(var9.getType().equals(Main.emptyType)) {
                              var9.setType(Main.lavaType);
                              var9.setQuantity(1);
                              var9.updateVisuals();
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public static void playerExpFilling() {
      Iterator<?> var1 = Bukkit.getOnlinePlayers().iterator();

      while(var1.hasNext()) {
         Player var0 = (Player)var1.next();
         if(var0.isSneaking()) {
            int var2 = experienceManager.totalExp(var0);
            if(var2 != 0) {
               Block var3 = var0.getLocation().add(0.0D, -0.5D, 0.0D).getBlock();
               if(var3.getType().equals(Material.HOPPER) && Main.locHashMap.containsKey(var3.getLocation())) {
                  liquidTank var4 = (liquidTank)Main.locHashMap.get(var3.getLocation());
                  if(var4.getType().equals(Main.experienceType) && var4.getQuantity() < var4.getMaxQuantity()) {
                     if(var4.getQuantity() + 100 <= var4.getMaxQuantity() && var2 >= 100) {
                        experienceManager.removeExp(var0, 100);
                        var4.setQuantity(var4.getQuantity() + 100);
                        var4.updateVisuals();
                     } else if(var2 < 100 && var4.getMaxQuantity() - var4.getQuantity() <= var2) {
                        experienceManager.removeExp(var0, var4.getMaxQuantity() - var4.getQuantity());
                        var4.setQuantity(var4.getMaxQuantity());
                        var4.updateVisuals();
                     } else if(var2 >= 100 && var4.getMaxQuantity() - var4.getQuantity() <= 100) {
                        experienceManager.removeExp(var0, var4.getMaxQuantity() - var4.getQuantity());
                        var4.setQuantity(var4.getMaxQuantity());
                        var4.updateVisuals();
                     } else if(var2 < 100 && var4.getMaxQuantity() - var4.getQuantity() > var2) {
                        experienceManager.removeExp(var0, var2);
                        var4.setQuantity(var4.getQuantity() + var2);
                        var4.updateVisuals();
                     }
                  } else if(var4.getType().equals(Main.emptyType)) {
                     if(var2 >= 100) {
                        experienceManager.removeExp(var0, 100);
                        var4.setType(Main.experienceType);
                        var4.setQuantity(100);
                        var4.updateVisuals();
                     } else if(var2 < 100) {
                        experienceManager.removeExp(var0, var2);
                        var4.setType(Main.experienceType);
                        var4.setQuantity(var2);
                        var4.updateVisuals();
                        var0.updateInventory();
                     }
                  }
               }
            }
         }
      }

   }

   public static void playerExportFromTank() {
      Iterator<?> var1 = Bukkit.getOnlinePlayers().iterator();

      while(var1.hasNext()) {
         Player var0 = (Player)var1.next();
         Block var2 = var0.getLocation().add(0.0D, 2.25D, 0.0D).getBlock();
         if(var2.getType().equals(Material.HOPPER) && Main.locHashMap.containsKey(var2.getLocation())) {
            liquidTank var3 = (liquidTank)Main.locHashMap.get(var2.getLocation());
            if(var3.getType().equals(Main.waterType)) {
               if(var0.getFireTicks() > 0) {
                  var0.setFireTicks(0);
                  var3.setQuantity(var3.getQuantity() - 1);
                  if(var3.getQuantity() == 0) {
                     var3.setType(Main.emptyType);
                  }

                  var3.updateVisuals();
               }
            } else if(var3.getType().equals(Main.milkType)) {
               Iterator<?> var5 = var0.getActivePotionEffects().iterator();

               while(var5.hasNext()) {
                  PotionEffect var4 = (PotionEffect)var5.next();
                  Boolean var6 = Boolean.valueOf(false);
                  if(var6.booleanValue()) {
                     var0.removePotionEffect(var4.getType());
                  } else {
                     var3.setQuantity(var3.getQuantity() - 1);
                     if(var3.getQuantity() == 0) {
                        var3.setType(Main.emptyType);
                     }

                     var3.updateVisuals();
                     var0.removePotionEffect(var4.getType());
                     var6 = Boolean.valueOf(true);
                  }
               }
            } else if(!var3.getType().equals(Main.mushroomStewType) && !var3.getType().equals(Main.rabbitStewType) && !var3.getType().equals(Main.beetrootSoupType)) {
               if(var3.getType().equals(Main.experienceType)) {
                  if(var3.getQuantity() >= 100) {
                     experienceManager.addExp(var0, 100);
                     var3.setQuantity(var3.getQuantity() - 100);
                     if(var3.getQuantity() == 0) {
                        var3.setType(Main.emptyType);
                     }

                     var3.updateVisuals();
                  } else if(var3.getQuantity() < 100) {
                     experienceManager.addExp(var0, var3.getQuantity());
                     var3.setQuantity(0);
                     var3.setType(Main.emptyType);
                     var3.updateVisuals();
                  }
               }
            } else if(var0.getFoodLevel() < 20) {
                  var0.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 12, 0));
               } else {
                  var0.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 8, 0));
               }

               var3.setQuantity(var3.getQuantity() - 1);
               if(var3.getQuantity() == 0) {
                  var3.setType(Main.emptyType);
               }

               var3.updateVisuals();
            }
         
      }
   }

   @SuppressWarnings("deprecation")
public static void checkTank() {
      ArrayList<liquidTank> var0 = new ArrayList<liquidTank>();
      Iterator<liquidTank> var2 = Main.locHashMap.values().iterator();

      liquidTank var1;
      while(var2.hasNext()) {
         var1 = (liquidTank)var2.next();
         if(isLoaded(var1.getLoc()) && !var1.getLoc().getBlock().getType().equals(Material.HOPPER)) {
            var0.add(var1);
         }
      }

      var2 = var0.iterator();

      while(var2.hasNext()) {
         var1 = (liquidTank)var2.next();
         if(isLoaded(var1.getLoc())) {
            Main.locHashMap.remove(var1.getLoc().getBlock().getLocation());
         }
      }

      var2 = Main.locHashMap.values().iterator();

      while(var2.hasNext()) {
         var1 = (liquidTank)var2.next();
         if(var1.getType().equals(Main.lavaType) || var1.getType().equals(Main.waterType) || var1.getType().equals(Main.emptyType)) {
            if(!isLoaded(var1.getLoc())) {
               break;
            }

            Block var3 = var1.getLoc().clone().add(0.0D, 1.0D, 0.0D).getBlock();
            if(var3.getType().equals(Material.STATIONARY_LAVA) && var3.getData() == 0) {
               if(var1.getType().equals(Main.emptyType)) {
                  var3.setType(Material.AIR);
                  var1.setType(Main.lavaType);
                  var1.setQuantity(3);
                  var1.updateVisuals();
               } else if(var1.getType().equals(Main.lavaType) && var1.getMaxQuantity() > var1.getQuantity() && var1.getQuantity() + 3 <= var1.getMaxQuantity()) {
                  var3.setType(Material.AIR);
                  var1.setQuantity(var1.getQuantity() + 3);
                  var1.updateVisuals();
               } else if(var1.getType().equals(Main.lavaType) && var1.getMaxQuantity() > var1.getQuantity()) {
                  var3.setType(Material.AIR);
                  var1.setQuantity(var1.getMaxQuantity());
                  var1.updateVisuals();
               }
            } else if(var3.getType().equals(Material.STATIONARY_WATER) && var3.getData() == 0) {
               if(var1.getType().equals(Main.emptyType)) {
                  var3.setType(Material.AIR);
                  var1.setType(Main.waterType);
                  var1.setQuantity(3);
                  var1.updateVisuals();
               } else if(var1.getType().equals(Main.waterType) && var1.getMaxQuantity() > var1.getQuantity() && var1.getQuantity() + 3 <= var1.getMaxQuantity()) {
                  var3.setType(Material.AIR);
                  var1.setQuantity(var1.getQuantity() + 3);
                  var1.updateVisuals();
               } else if(var1.getType().equals(Main.waterType) && var1.getMaxQuantity() > var1.getQuantity()) {
                  var3.setType(Material.AIR);
                  var1.setQuantity(var1.getMaxQuantity());
                  var1.updateVisuals();
               }
            }
         }
      }

   }
}
