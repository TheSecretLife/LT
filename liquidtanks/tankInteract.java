package be.arcaniax.liquidtanks;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;

public abstract class tankInteract
{
  public tankInteract() {}
  
  public abstract void clickOnLiquidTank(Player paramPlayer, liquidTank paramLiquidTank);
  
  public abstract void itemMoveInLiquidTank(ItemStack paramItemStack, liquidTank paramLiquidTank, InventoryMoveItemEvent paramInventoryMoveItemEvent);
}
