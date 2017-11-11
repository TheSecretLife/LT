package be.arcaniax.liquidtanks;

import be.arcaniax.liquidtanks.Main;
import be.arcaniax.liquidtanks.liquidTank;
import be.arcaniax.liquidtanks.liquidTankType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.v1_12_R1.EntityArmorStand;
import net.minecraft.server.v1_12_R1.EnumItemSlot;
import net.minecraft.server.v1_12_R1.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_12_R1.PacketPlayOutEntityEquipment;
import net.minecraft.server.v1_12_R1.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_12_R1.Vector3f;
import net.minecraft.server.v1_12_R1.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Hopper;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class liquidTank_v1_12_R1 extends liquidTank {

   int quantity = 0;
   List<String> inRange;
   Location loc = null;
   Location aLoc = null;
   int ID1;
   PacketPlayOutSpawnEntityLiving packet1;
   int ID2;
   PacketPlayOutSpawnEntityLiving packet2;
   liquidTankType type;


   public liquidTank_v1_12_R1(Location var1) {
      this.type = Main.emptyType;
      var1.setYaw(0.0F);
      var1.setPitch(0.0F);
      this.aLoc = new Location(var1.getWorld(), var1.getX(), var1.getY(), var1.getZ());
      this.aLoc.setX(this.aLoc.getX() + 0.5D);
      this.aLoc.setZ(this.aLoc.getZ() + 0.5D);
      this.aLoc.setY(this.aLoc.getY() + 0.35D);
      Main.addItems(this.aLoc.getBlock());
      this.loc = var1;
      this.inRange = new ArrayList<String>();
      this.createPackets();
   }

   public liquidTank_v1_12_R1(Location var1, int var2, String var3) {
      this.type = Main.emptyType;
      this.aLoc = new Location(var1.getWorld(), var1.getX(), var1.getY(), var1.getZ());
      this.aLoc.setX(var1.getX() + 0.5D);
      this.aLoc.setZ(var1.getZ() + 0.5D);
      this.aLoc.setY(var1.getY() + 0.35D);
      if(var3.contains("empty")) {
         this.type = Main.emptyType;
      } else if(var3.contains("lava")) {
         this.type = Main.lavaType;
      } else if(var3.contains("water")) {
         this.type = Main.waterType;
      } else if(var3.contains("milk")) {
         this.type = Main.milkType;
      } else if(var3.contains("experience")) {
         this.type = Main.experienceType;
      } else if(var3.contains("mushroomStew")) {
         this.type = Main.mushroomStewType;
      } else if(var3.contains("rabbitStew")) {
         this.type = Main.rabbitStewType;
      } else if(var3.contains("dragonBreath")) {
         this.type = Main.dragonBreathType;
      }

      if(var2 > this.type.maxQuantity) {
         var2 = this.type.maxQuantity;
      }

      this.quantity = var2;
      this.loc = var1;
      this.inRange = new ArrayList<String>();
      this.createPackets();
   }

   public void setQuantity(int var1) {
      this.quantity = var1;
   }

   public int getMaxQuantity() {
      return this.type.maxQuantity;
   }

   public void setType(liquidTankType var1) {
      this.type = var1;
   }

   public void updateVisuals() {
      Location var1 = new Location(this.aLoc.getWorld(), this.aLoc.getX(), this.aLoc.getY(), this.aLoc.getZ());
      if(this.quantity > 0) {
         double var2 = -0.025D;
         double var4 = 0.35D;
         double var6 = (var4 - var2) * ((double)this.quantity / (double)this.type.maxQuantity);
         var1.setY(var1.getY() - var4 + var6);
         Iterator<?> var9 = Bukkit.getOnlinePlayers().iterator();

         while(var9.hasNext()) {
            Player var8 = (Player)var9.next();
            CraftPlayer var10 = (CraftPlayer)var8;
            PacketPlayOutEntityDestroy var11 = new PacketPlayOutEntityDestroy(new int[]{this.ID2});
            var10.getHandle().playerConnection.sendPacket(var11);
         }

         WorldServer var16 = ((CraftWorld)this.loc.getWorld()).getHandle();
         EntityArmorStand var17 = new EntityArmorStand(var16);
         var17.setLocation(var1.getX(), var1.getY(), var1.getZ(), 0.0F, 0.0F);
         var17.setInvisible(true);
         var17.setMarker(true);
         var17.setSmall(true);
         var17.setNoGravity(true);
         var17.setHeadPose(new Vector3f(0.0F, 0.0F, 180.0F));
         PacketPlayOutSpawnEntityLiving var18 = new PacketPlayOutSpawnEntityLiving(var17);
         this.packet2 = var18;
         this.ID2 = var17.getId();
         Iterator<?> var12 = Bukkit.getOnlinePlayers().iterator();

         while(var12.hasNext()) {
            Player var19 = (Player)var12.next();
            if(var19.getWorld() == this.aLoc.getWorld() && var19.getLocation().distance(this.aLoc) <= 20.0D && this.type != Main.emptyType) {
               CraftPlayer var13 = (CraftPlayer)var19;
               var13.getHandle().playerConnection.sendPacket(var18);
               this.equipHead(this.ID2, this.type.head, var19);
            }
         }
      } else {
         Iterator<?> var3 = Bukkit.getOnlinePlayers().iterator();

         while(var3.hasNext()) {
            Player var14 = (Player)var3.next();
            CraftPlayer var15 = (CraftPlayer)var14;
            PacketPlayOutEntityDestroy var5 = new PacketPlayOutEntityDestroy(new int[]{this.ID2});
            var15.getHandle().playerConnection.sendPacket(var5);
         }
      }

   }

   public void removeTank(boolean var1) {
      if(var1) {
         this.loc.getWorld().dropItem(this.loc, new ItemStack(Material.HOPPER));
      } else if(this.loc.getBlock().getType().equals(Material.HOPPER)) {
         Hopper var2 = (Hopper)this.loc.getBlock().getState();
         var2.getInventory().clear();
      }

      this.loc.getBlock().setType(Material.AIR);
      Iterator<?> var3 = Bukkit.getOnlinePlayers().iterator();

      while(var3.hasNext()) {
         Player var7 = (Player)var3.next();
         if(this.inRange.contains(var7.getName())) {
            CraftPlayer var4 = (CraftPlayer)var7;
            PacketPlayOutEntityDestroy var5 = new PacketPlayOutEntityDestroy(new int[]{this.ID1});
            PacketPlayOutEntityDestroy var6 = new PacketPlayOutEntityDestroy(new int[]{this.ID2});
            var4.getHandle().playerConnection.sendPacket(var5);
            var4.getHandle().playerConnection.sendPacket(var6);
         }
      }

      Main.locHashMap.remove(this.loc.getBlock().getLocation());
   }

   private void createPackets() {
      WorldServer var1 = ((CraftWorld)this.loc.getWorld()).getHandle();
      EntityArmorStand var2 = new EntityArmorStand(var1);
      var2.setLocation(this.aLoc.getX(), this.aLoc.getY(), this.aLoc.getZ(), 0.0F, 0.0F);
      var2.setInvisible(true);
      var2.setMarker(true);
      var2.setSmall(true);
      var2.setNoGravity(true);
      var2.setHeadPose(new Vector3f(0.0F, 0.0F, 180.0F));
      PacketPlayOutSpawnEntityLiving var3 = new PacketPlayOutSpawnEntityLiving(var2);
      this.packet1 = var3;
      this.ID1 = var2.getId();
      EntityArmorStand var4 = new EntityArmorStand(var1);
      var4.setLocation(this.aLoc.getX(), this.aLoc.getY(), this.aLoc.getZ(), 0.0F, 0.0F);
      var4.setInvisible(true);
      var4.setMarker(true);
      var4.setSmall(true);
      var4.setNoGravity(true);
      var4.setHeadPose(new Vector3f(0.0F, 0.0F, 180.0F));
      PacketPlayOutSpawnEntityLiving var5 = new PacketPlayOutSpawnEntityLiving(var4);
      this.packet2 = var5;
      this.ID2 = var4.getId();
   }

   public void display(Player var1) {
      if(!this.inRange.contains(var1.getName())) {
         CraftPlayer var2 = (CraftPlayer)var1;
         var2.getHandle().playerConnection.sendPacket(this.packet1);
         this.equipHead(this.ID1, new ItemStack(Material.GLASS), var1);
         if(this.type != Main.emptyType) {
            var2.getHandle().playerConnection.sendPacket(this.packet2);
            this.equipHead(this.ID2, this.type.head, var1);
         }

         this.inRange.add(var1.getName());
      }

   }

   public void removeDisplay(Player var1) {
      if(this.inRange.contains(var1.getName())) {
         CraftPlayer var2 = (CraftPlayer)var1;
         PacketPlayOutEntityDestroy var3 = new PacketPlayOutEntityDestroy(new int[]{this.ID1});
         PacketPlayOutEntityDestroy var4 = new PacketPlayOutEntityDestroy(new int[]{this.ID2});
         var2.getHandle().playerConnection.sendPacket(var3);
         var2.getHandle().playerConnection.sendPacket(var4);
         this.inRange.remove(var1.getName());
      }

   }

   public void equipHead(int var1, ItemStack var2, Player var3) {
      CraftPlayer var4 = (CraftPlayer)var3;
      PacketPlayOutEntityEquipment var5 = new PacketPlayOutEntityEquipment(var1, EnumItemSlot.HEAD, CraftItemStack.asNMSCopy(var2));
      var4.getHandle().playerConnection.sendPacket(var5);
   }

   public int getQuantity() {
      return this.quantity;
   }

   public Location getLoc() {
      return this.loc;
   }

   public liquidTankType getType() {
      return this.type;
   }
}
