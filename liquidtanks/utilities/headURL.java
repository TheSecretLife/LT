package be.arcaniax.liquidtanks.utilities;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.lang.reflect.Field;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class headURL
{
  public headURL() {}
  
  public static String experienceB64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWNlMGJkNWY3OWRkMWE3ZTg5MjA1YWQ3Y2I1ODMxZDIxNGM5NDQ1MjBiZGU5YTg1OWQ1NWYyODYwYmNlOCJ9fX0=";
  public static String waterB64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWM3ZWNiZmQ2ZDMzZTg3M2ExY2Y5YTkyZjU3ZjE0NjE1MmI1MmQ5ZDczMTE2OTQ2MDI2NzExMTFhMzAyZiJ9fX0=";
  public static String lavaB64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjY5NjVlNmE1ODY4NGMyNzdkMTg3MTdjZWM5NTlmMjgzM2E3MmRmYTk1NjYxMDE5ZGJjZGYzZGJmNjZiMDQ4In19fQ==";
  public static String milkB64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTVhNzcwZTdlNDRiM2ExZTZjM2I4M2E5N2ZmNjk5N2IxZjViMjY1NTBlOWQ3YWE1ZDUwMjFhMGMyYjZlZSJ9fX0=";
  public static String mushroomStewB64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzZmZDc0MjUyODJlOWZiMzgzYzdmZTE2NDllMTE5NzYzNTE2M2RhZmYxOGFkNTgyMmE0OTMwZjQzNDJkNDc3MiJ9fX0=";
  public static String rabbitStewB64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDJkYThlMDk0ZDNkMDM4YjM4ZWU1NWEyZWNhMjlhZDY5ZjNlZDFhYzgzMjlkNTM0YmI3OWFiNjRjYzFkOTEyIn19fQ==";
  public static String dragonBreathB64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmI2NjM5NTVmNDg3MzFhZTEzNTdhY2EzODdmNWQxOWRhZTQxNzZhZDFkYmQ1MWE0ODQxZjZlNWEyODIxODIifX19";
  public static String beetrootB64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTNiZjM5NGQyZDZjZWZkNDdmNmIyNmU4NWEwZDU1OGFkN2MzYjRjOGRmZGVlNGFkZmEwYjkzY2UzNTEzZCJ9fX0=";
  
  public static ItemStack create(String paramString) { ItemStack localItemStack = new ItemStack(Material.SKULL_ITEM);
    localItemStack.setDurability((short)3);
    SkullMeta localSkullMeta = (SkullMeta)localItemStack.getItemMeta();
    GameProfile localGameProfile = new GameProfile(java.util.UUID.randomUUID(), null);
    localGameProfile.getProperties().put("textures", new Property("textures", new String(paramString)));
    Field localField = null;
    try
    {
      localField = localSkullMeta.getClass().getDeclaredField("profile");
      localField.setAccessible(true);
      localField.set(localSkullMeta, localGameProfile);
    }
    catch (Exception localException) {}
    localItemStack.setItemMeta(localSkullMeta);
    return localItemStack;
  }
}
