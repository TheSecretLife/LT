package be.arcaniax.liquidtanks;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class liquidTank
{
  public liquidTank() {}
  
  public abstract void setQuantity(int paramInt);
  
  public abstract int getMaxQuantity();
  
  public abstract void setType(liquidTankType paramLiquidTankType);
  
  public abstract void updateVisuals();
  
  public abstract void removeTank(boolean paramBoolean);
  
  public abstract void display(Player paramPlayer);
  
  public abstract void removeDisplay(Player paramPlayer);
  
  public abstract int getQuantity();
  
  public abstract Location getLoc();
  
  public abstract liquidTankType getType();
  
  public abstract void equipHead(int paramInt, ItemStack paramItemStack, Player paramPlayer);
}
