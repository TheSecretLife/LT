package be.arcaniax.liquidtanks;

import be.arcaniax.liquidtanks.utilities.types;
import org.bukkit.inventory.ItemStack;

public class liquidTankType
{
  ItemStack head = null;
  int maxQuantity;
  types type;
  
  public liquidTankType(types paramTypes, int paramInt, ItemStack paramItemStack) {
    head = paramItemStack;
    maxQuantity = paramInt;
    type = paramTypes;
  }
}
