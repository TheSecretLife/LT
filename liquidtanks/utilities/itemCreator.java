package be.arcaniax.liquidtanks.utilities;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class itemCreator
{
  public itemCreator() {}
  
  public static ItemStack newItem(org.bukkit.Material paramMaterial, int paramInt, String paramString1, String paramString2)
  {
    ItemStack localItemStack = new ItemStack(paramMaterial);
    localItemStack.setAmount(paramInt);
    ItemMeta localItemMeta = localItemStack.getItemMeta();
    if (paramString2 != "") {
      String[] arrayOfString1 = paramString2.split("||");
      ArrayList<String> localArrayList = new ArrayList<String>();
      for (String str : arrayOfString1) localArrayList.add(str);
      localItemMeta.setLore(localArrayList);
    }
    if (paramString1 != "") localItemMeta.setDisplayName(paramString1);
    localItemStack.setItemMeta(localItemMeta);
    return localItemStack;
  }
}
