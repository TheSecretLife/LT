package be.arcaniax.liquidtanks.utilities;

import be.arcaniax.liquidtanks.utilities.titleManager;
import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_12_R1.PlayerConnection;
import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle.EnumTitleAction;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class titleManager_v1_12_R1 extends titleManager {

   public void sendTitle(Player var1, Integer var2, Integer var3, Integer var4, String var5, String var6) {
      PlayerConnection var7 = ((CraftPlayer)var1).getHandle().playerConnection;
      PacketPlayOutTitle var8 = new PacketPlayOutTitle(EnumTitleAction.TIMES, (IChatBaseComponent)null, var2.intValue(), var3.intValue(), var4.intValue());
      var7.sendPacket(var8);
      IChatBaseComponent var9;
      PacketPlayOutTitle var10;
      if(var6 != null) {
         var6 = var6.replaceAll("%player%", var1.getName());
         var6 = ChatColor.translateAlternateColorCodes('&', var6);
         var9 = ChatSerializer.a("{\"text\": \"" + var6 + "\"}");
         var10 = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, var9);
         var7.sendPacket(var10);
      }

      if(var5 != null) {
         var5 = var5.replaceAll("%player%", var1.getName());
         var5 = ChatColor.translateAlternateColorCodes('&', var5);
         var9 = ChatSerializer.a("{\"text\": \"" + var5 + "\"}");
         var10 = new PacketPlayOutTitle(EnumTitleAction.TITLE, var9);
         var7.sendPacket(var10);
      } else {
         var9 = ChatSerializer.a("{\"text\": \"\"}");
         var10 = new PacketPlayOutTitle(EnumTitleAction.TITLE, var9);
         var7.sendPacket(var10);
      }

   }
}
