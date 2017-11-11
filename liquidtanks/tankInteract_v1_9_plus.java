package be.arcaniax.liquidtanks;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class tankInteract_v1_9_plus extends tankInteract
{
  public tankInteract_v1_9_plus() {}
  
  public void clickOnLiquidTank(Player paramPlayer, liquidTank paramLiquidTank)
  {
    if (paramPlayer.getInventory().getItemInMainHand().getType().equals(Material.WATER_BUCKET)) {
      if (paramLiquidTank.getQuantity() + 2 < paramLiquidTank.getMaxQuantity()) {
        if (paramLiquidTank.getType().equals(Main.waterType)) {
          paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.1F, 2.0F);
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 3);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BUCKET) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET));
            }
          }
        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.1F, 2.0F);
          paramLiquidTank.setType(Main.waterType);
          paramLiquidTank.setQuantity(3);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BUCKET) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET));
            }
          }
        }
      }
    }
    else if (paramPlayer.getInventory().getItemInMainHand().getType().equals(Material.MUSHROOM_SOUP)) {
      if (paramLiquidTank.getQuantity() != paramLiquidTank.getMaxQuantity()) {
        if (paramLiquidTank.getType().equals(Main.mushroomStewType)) {
          paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.033F, 1.5F);
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 1);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.BOWL));
          }
        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.033F, 1.5F);
          paramLiquidTank.setType(Main.mushroomStewType);
          paramLiquidTank.setQuantity(1);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.BOWL));
          }
        }
      }
    }
    else if (paramPlayer.getInventory().getItemInMainHand().getType().equals(Material.RABBIT_STEW)) {
      if (paramLiquidTank.getQuantity() != paramLiquidTank.getMaxQuantity()) {
        if (paramLiquidTank.getType().equals(Main.rabbitStewType)) {
          paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.033F, 1.5F);
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 1);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.BOWL));
          }
        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.033F, 1.5F);
          paramLiquidTank.setType(Main.rabbitStewType);
          paramLiquidTank.setQuantity(1);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.BOWL));
          }
        }
      }
    }
    else if (paramPlayer.getInventory().getItemInMainHand().getType().equals(Material.BEETROOT_SOUP)) {
      if (paramLiquidTank.getQuantity() != paramLiquidTank.getMaxQuantity()) {
        if (paramLiquidTank.getType().equals(Main.beetrootSoupType)) {
          paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.033F, 1.5F);
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 1);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.BOWL));
          }
        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.033F, 1.5F);
          paramLiquidTank.setType(Main.beetrootSoupType);
          paramLiquidTank.setQuantity(1);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.BOWL));
          }
        }
      }
    }
    else if (paramPlayer.getInventory().getItemInMainHand().getType().equals(Material.BOWL)) {
      if (paramLiquidTank.getType() == Main.mushroomStewType) {
        paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.022F, 1.0F);
        if (paramLiquidTank.getQuantity() > 1) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() - 1);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.MUSHROOM_SOUP));
            }
          }
        }
        else {
          paramLiquidTank.setType(Main.emptyType);
          paramLiquidTank.setQuantity(0);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.MUSHROOM_SOUP));
            }
          }
        }
      }
      else if (paramLiquidTank.getType() == Main.rabbitStewType) {
        paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.022F, 1.0F);
        if (paramLiquidTank.getQuantity() > 1) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() - 1);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.RABBIT_STEW) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.RABBIT_STEW));
            }
          }
        }
        else {
          paramLiquidTank.setType(Main.emptyType);
          paramLiquidTank.setQuantity(0);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.RABBIT_STEW) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.RABBIT_STEW));
            }
          }
        }
      }
      else if (paramLiquidTank.getType() == Main.beetrootSoupType) {
        paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.022F, 1.0F);
        if (paramLiquidTank.getQuantity() > 1) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() - 1);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BEETROOT_SOUP) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.BEETROOT_SOUP));
            }
          }
        }
        else {
          paramLiquidTank.setType(Main.emptyType);
          paramLiquidTank.setQuantity(0);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BEETROOT_SOUP) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.BEETROOT_SOUP));
            }
          }
        }
      }
    }
    else if (paramPlayer.getInventory().getItemInMainHand().getType().equals(Material.EXP_BOTTLE)) {
      if (paramLiquidTank.getQuantity() + 6 < paramLiquidTank.getMaxQuantity()) {
        if (paramLiquidTank.getType().equals(Main.experienceType)) {
          paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.1F, 2.0F);
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 7);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GLASS_BOTTLE) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.GLASS_BOTTLE));
            }
          }
        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.1F, 2.0F);
          paramLiquidTank.setType(Main.experienceType);
          paramLiquidTank.setQuantity(7);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GLASS_BOTTLE) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.GLASS_BOTTLE));
            }
          }
        }
      }
      else if ((paramLiquidTank.getQuantity() <= paramLiquidTank.getMaxQuantity()) && (paramLiquidTank.getType().equals(Main.experienceType))) {
        paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.1F, 2.0F);
        paramLiquidTank.setQuantity(paramLiquidTank.getMaxQuantity());
        paramLiquidTank.updateVisuals();
        if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
          if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
            paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
            paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GLASS_BOTTLE) });
          }
          else {
            paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.GLASS_BOTTLE));
          }
        }
      }
    }
    else if ((paramPlayer.getInventory().getItemInMainHand().getType().equals(Material.POTION)) && (paramPlayer.getInventory().getItemInMainHand().getDurability() == 0)) {
      if (paramLiquidTank.getQuantity() != paramLiquidTank.getMaxQuantity()) {
        paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.033F, 2.0F);
        if (paramLiquidTank.getType().equals(Main.waterType)) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 1);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.GLASS_BOTTLE));
          }
        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramLiquidTank.setType(Main.waterType);
          paramLiquidTank.setQuantity(1);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.GLASS_BOTTLE));
          }
        }
      }
    }
    else if (paramPlayer.getInventory().getItemInMainHand().getType().equals(Material.DRAGONS_BREATH)) {
      if (paramLiquidTank.getQuantity() != paramLiquidTank.getMaxQuantity()) {
        paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.033F, 2.0F);
        if (paramLiquidTank.getType().equals(Main.dragonBreathType)) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 1);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GLASS_BOTTLE) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.GLASS_BOTTLE));
            }
          }
        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramLiquidTank.setType(Main.dragonBreathType);
          paramLiquidTank.setQuantity(1);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GLASS_BOTTLE) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.GLASS_BOTTLE));
            }
          }
        }
      }
    }
    else if (paramPlayer.getInventory().getItemInMainHand().getType().equals(Material.GLASS_BOTTLE)) {
      if (paramLiquidTank.getType() == Main.waterType) {
        paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.022F, 1.0F);
        if (paramLiquidTank.getQuantity() > 1) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() - 1);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.POTION) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.POTION));
            }
          }
        }
        else {
          paramLiquidTank.setType(Main.emptyType);
          paramLiquidTank.setQuantity(0);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.POTION) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.POTION));
            }
          }
        }
      }
      else if (paramLiquidTank.getType() == Main.dragonBreathType) {
        paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.022F, 1.0F);
        if (paramLiquidTank.getQuantity() > 1) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() - 1);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.DRAGONS_BREATH) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.DRAGONS_BREATH));
            }
          }
        }
        else {
          paramLiquidTank.setType(Main.emptyType);
          paramLiquidTank.setQuantity(0);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.DRAGONS_BREATH) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.DRAGONS_BREATH));
            }
          }
        }
      }
      else if (paramLiquidTank.getType() == Main.experienceType) {
        if (paramLiquidTank.getQuantity() > 7) {
          paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.022F, 1.0F);
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() - 7);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.EXP_BOTTLE) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.EXP_BOTTLE));
            }
          }
        }
        else if (paramLiquidTank.getQuantity() == 7) {
          paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.022F, 1.0F);
          paramLiquidTank.setType(Main.emptyType);
          paramLiquidTank.setQuantity(0);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.EXP_BOTTLE) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.EXP_BOTTLE));
            }
          }
        }
      }
    }
    else if (paramPlayer.getInventory().getItemInMainHand().getType().equals(Material.LAVA_BUCKET)) {
      if (paramLiquidTank.getQuantity() + 2 < paramLiquidTank.getMaxQuantity()) {
        paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY_LAVA, 0.4F, 0.8F);
        if (paramLiquidTank.getType().equals(Main.lavaType)) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 3);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BUCKET) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET));
            }
          }
        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramLiquidTank.setType(Main.lavaType);
          paramLiquidTank.setQuantity(3);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BUCKET) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET));
            }
          }
        }
      }
    }
    else if (paramPlayer.getInventory().getItemInMainHand().getType().equals(Material.MILK_BUCKET)) {
      paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.1F, 1.7F);
      if (paramLiquidTank.getQuantity() + 2 < paramLiquidTank.getMaxQuantity()) {
        if (paramLiquidTank.getType().equals(Main.milkType)) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 3);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BUCKET) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET));
            }
          }
        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramLiquidTank.setType(Main.milkType);
          paramLiquidTank.setQuantity(3);
          paramLiquidTank.updateVisuals();
          if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
            if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
              paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
              paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BUCKET) });
            }
            else {
              paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET));
            }
          }
        }
      }
    }
    else if ((paramPlayer.getInventory().getItemInMainHand().getType().equals(Material.BUCKET)) && 
      (paramLiquidTank.getQuantity() > 2)) {
      if (paramLiquidTank.getType().equals(Main.waterType)) {
        paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.066F, 1.0F);
        if (paramLiquidTank.getQuantity() > 3) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() - 3);
          paramLiquidTank.updateVisuals();
        }
        else {
          paramLiquidTank.setType(Main.emptyType);
          paramLiquidTank.setQuantity(0);
          paramLiquidTank.updateVisuals();
        }
        if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
          if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
            paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
            paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.WATER_BUCKET) });
          }
          else {
            paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.WATER_BUCKET));
          }
          
        }
      }
      else if (paramLiquidTank.getType().equals(Main.lavaType)) {
        paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_FILL_LAVA, 0.3F, 0.5F);
        if (paramLiquidTank.getQuantity() > 3) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() - 3);
          paramLiquidTank.updateVisuals();
        }
        else {
          paramLiquidTank.setType(Main.emptyType);
          paramLiquidTank.setQuantity(0);
          paramLiquidTank.updateVisuals();
        }
        if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
          if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
            paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
            paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.LAVA_BUCKET) });
          }
          else {
            paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.LAVA_BUCKET));
          }
        }
      }
      else if (paramLiquidTank.getType().equals(Main.milkType)) {
        paramPlayer.playSound(paramLiquidTank.getLoc(), org.bukkit.Sound.ITEM_BUCKET_EMPTY, 0.066F, 1.2F);
        if (paramLiquidTank.getQuantity() > 3) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() - 3);
          paramLiquidTank.updateVisuals();
        }
        else {
          paramLiquidTank.setType(Main.emptyType);
          paramLiquidTank.setQuantity(0);
          paramLiquidTank.updateVisuals();
        }
        if (!paramPlayer.getGameMode().equals(GameMode.CREATIVE)) {
          if (paramPlayer.getInventory().getItemInMainHand().getAmount() > 1) {
            paramPlayer.getInventory().getItemInMainHand().setAmount(paramPlayer.getInventory().getItemInMainHand().getAmount() - 1);
            paramPlayer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MILK_BUCKET) });
          }
          else {
            paramPlayer.getInventory().setItemInMainHand(new ItemStack(Material.MILK_BUCKET));
          }
        }
      }
    }
    
    int i = 0;
    String str1 = "&7[";
    String str2 = "&7";
    int j; if (paramLiquidTank.getType() != Main.experienceType)
    {
      if (paramLiquidTank.getType() == Main.lavaType) str2 = "&4";
      if (paramLiquidTank.getType() == Main.waterType) str2 = "&3";
      if (paramLiquidTank.getType() == Main.milkType) str2 = "&f";
      if (paramLiquidTank.getType() == Main.mushroomStewType) str2 = "&e";
      if (paramLiquidTank.getType() == Main.rabbitStewType) str2 = "&6";
      if (paramLiquidTank.getType() == Main.dragonBreathType) str2 = "&d";
      if (paramLiquidTank.getType() == Main.beetrootSoupType) str2 = "&c";
      str1 = str1 + str2;
      if (paramLiquidTank.getMaxQuantity() <= 40) {
        for (j = 0; j < paramLiquidTank.getMaxQuantity(); j++) {
          if ((j == paramLiquidTank.getMaxQuantity() / 2) && (paramLiquidTank.getQuantity() <= paramLiquidTank.getMaxQuantity() / 2)) str1 = str1 + "&7" + paramLiquidTank.getQuantity() + "&8";
          if ((j == paramLiquidTank.getMaxQuantity() / 2) && (paramLiquidTank.getQuantity() > paramLiquidTank.getMaxQuantity() / 2)) str1 = str1 + "&7" + paramLiquidTank.getQuantity() + str2;
          if (j < paramLiquidTank.getQuantity()) str1 = str1 + "|";
          if (j == paramLiquidTank.getQuantity()) str1 = str1 + "&8";
          if (j >= paramLiquidTank.getQuantity()) { str1 = str1 + "|";
          }
        }
      } else if (paramLiquidTank.getMaxQuantity() <= 80)
      {
        for (j = 0; j < paramLiquidTank.getMaxQuantity() / 2; j++) {
          if ((j == paramLiquidTank.getMaxQuantity() / 2 / 2) && (paramLiquidTank.getQuantity() / 2 <= paramLiquidTank.getMaxQuantity() / 2 / 2)) str1 = str1 + "&7" + paramLiquidTank.getQuantity() + "&8";
          if ((j == paramLiquidTank.getMaxQuantity() / 2 / 2) && (paramLiquidTank.getQuantity() / 2 > paramLiquidTank.getMaxQuantity() / 2 / 2)) str1 = str1 + "&7" + paramLiquidTank.getQuantity() + str2;
          if (j < paramLiquidTank.getQuantity() / 2) str1 = str1 + "|";
          if (j == paramLiquidTank.getQuantity() / 2) str1 = str1 + "&8";
          if (j >= paramLiquidTank.getQuantity() / 2) { str1 = str1 + "|";
          }
        }
      } else if (paramLiquidTank.getMaxQuantity() <= 160)
      {
        for (j = 0; j < paramLiquidTank.getMaxQuantity() / 4; j++) {
          if ((j == paramLiquidTank.getMaxQuantity() / 4 / 2) && (paramLiquidTank.getQuantity() / 4 <= paramLiquidTank.getMaxQuantity() / 4 / 2)) str1 = str1 + "&7" + paramLiquidTank.getQuantity() + "&8";
          if ((j == paramLiquidTank.getMaxQuantity() / 4 / 2) && (paramLiquidTank.getQuantity() / 4 > paramLiquidTank.getMaxQuantity() / 4 / 2)) str1 = str1 + "&7" + paramLiquidTank.getQuantity() + str2;
          if (j < paramLiquidTank.getQuantity() / 4) str1 = str1 + "|";
          if (j == paramLiquidTank.getQuantity() / 4) str1 = str1 + "&8";
          if (j >= paramLiquidTank.getQuantity() / 4) { str1 = str1 + "|";
          }
          
        }
      } else {
        for (j = 0; j < paramLiquidTank.getMaxQuantity() / 8; j++) {
          if ((j == paramLiquidTank.getMaxQuantity() / 8 / 2) && (paramLiquidTank.getQuantity() / 8 <= paramLiquidTank.getMaxQuantity() / 8 / 2)) str1 = str1 + "&7" + paramLiquidTank.getQuantity() + "&8";
          if ((j == paramLiquidTank.getMaxQuantity() / 8 / 2) && (paramLiquidTank.getQuantity() / 8 > paramLiquidTank.getMaxQuantity() / 8 / 2)) str1 = str1 + "&7" + paramLiquidTank.getQuantity() + str2;
          if (j < paramLiquidTank.getQuantity() / 8) str1 = str1 + "|";
          if (j == paramLiquidTank.getQuantity() / 8) str1 = str1 + "&8";
          if (j >= paramLiquidTank.getQuantity() / 8) str1 = str1 + "|";
        }
      }
    }
    else {
      str1 = str1 + "&a";
      i = 0;
      for (j = 1; j <= 30; j++) {
        int k;
        if (j > 16) k = (int)(2.5D * j * j - 40.5D * j + 360.0D); else
          k = j * j + 6 * j;
        if (paramLiquidTank.getQuantity() >= k) {
          i = j;
        } else
          j = 30;
      }
      for (j = 1; j <= 30; j++) {
        if ((i == 0) && (j == 1)) str1 = str1 + "|&8";
        if ((j == 16) && (i < 16)) str1 = str1 + "&7" + i + "&8";
        if ((j == 16) && (i >= 16)) str1 = str1 + "&7" + i + "&a";
        if (j <= i) str1 = str1 + "|";
        if (j == i) str1 = str1 + "&8";
        if ((j > i) && ((i != 0) || (j != 1))) str1 = str1 + "|";
      }
    }
    str1 = str1 + "&7]";
    Main.vm.getTitleManager().sendTitle(paramPlayer, Integer.valueOf(0), Integer.valueOf(10), Integer.valueOf(5), "", str1);
  }
  
  public void itemMoveInLiquidTank(ItemStack paramItemStack, liquidTank paramLiquidTank, org.bukkit.event.inventory.InventoryMoveItemEvent paramInventoryMoveItemEvent) {
    if (paramItemStack.getType().equals(Material.WATER_BUCKET)) {
      if (paramLiquidTank.getQuantity() + 2 < paramLiquidTank.getMaxQuantity()) {
        if (paramLiquidTank.getType().equals(Main.waterType)) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 3);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.WATER_BUCKET);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.BUCKET) });

        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramLiquidTank.setType(Main.waterType);
          paramLiquidTank.setQuantity(3);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.WATER_BUCKET);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.BUCKET) });
        }
      }
    }
    else if (paramItemStack.getType().equals(Material.LAVA_BUCKET)) {
      if (paramLiquidTank.getQuantity() + 2 < paramLiquidTank.getMaxQuantity()) {
        if (paramLiquidTank.getType().equals(Main.lavaType)) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 3);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.LAVA_BUCKET);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.BUCKET) });
        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramLiquidTank.setType(Main.lavaType);
          paramLiquidTank.setQuantity(3);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.LAVA_BUCKET);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.BUCKET) });
        }
      }
    }
    else if (paramItemStack.getType().equals(Material.MILK_BUCKET)) {
      if (paramLiquidTank.getQuantity() + 2 < paramLiquidTank.getMaxQuantity()) {
        if (paramLiquidTank.getType().equals(Main.milkType)) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 3);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.MILK_BUCKET);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.BUCKET) });

        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramLiquidTank.setType(Main.milkType);
          paramLiquidTank.setQuantity(3);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.MILK_BUCKET);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.BUCKET) });
        }
      }
    }
    else if (paramItemStack.getType().equals(Material.EXP_BOTTLE)) {
      if (paramLiquidTank.getQuantity() + 6 < paramLiquidTank.getMaxQuantity()) {
        if (paramLiquidTank.getType().equals(Main.experienceType)) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 7);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.EXP_BOTTLE);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.GLASS_BOTTLE) });
        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramLiquidTank.setType(Main.experienceType);
          paramLiquidTank.setQuantity(7);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.EXP_BOTTLE);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.GLASS_BOTTLE) });
        }
      }
    }
    else if ((paramItemStack.getType().equals(Material.POTION)) && (paramItemStack.getDurability() == 0)) {
      if (paramLiquidTank.getQuantity() < paramLiquidTank.getMaxQuantity()) {
        if (paramLiquidTank.getType().equals(Main.waterType)) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 1);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.POTION);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.GLASS_BOTTLE) });
        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramLiquidTank.setType(Main.waterType);
          paramLiquidTank.setQuantity(1);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.POTION);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.GLASS_BOTTLE) });
        }
      }
    }
    else if (paramItemStack.getType().equals(Material.DRAGONS_BREATH)) {
      if (paramLiquidTank.getQuantity() < paramLiquidTank.getMaxQuantity()) {
        if (paramLiquidTank.getType().equals(Main.dragonBreathType)) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 1);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.DRAGONS_BREATH);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.GLASS_BOTTLE) });
        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramLiquidTank.setType(Main.dragonBreathType);
          paramLiquidTank.setQuantity(1);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.DRAGONS_BREATH);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.GLASS_BOTTLE) });
        }
      }
    }
    else if (paramItemStack.getType().equals(Material.MUSHROOM_SOUP)) {
      if (paramLiquidTank.getQuantity() < paramLiquidTank.getMaxQuantity()) {
        if (paramLiquidTank.getType().equals(Main.mushroomStewType)) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 1);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.MUSHROOM_SOUP);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.BOWL) });
        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramLiquidTank.setType(Main.mushroomStewType);
          paramLiquidTank.setQuantity(1);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.MUSHROOM_SOUP);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.BOWL) });
        }
      }
    }
    else if (paramItemStack.getType().equals(Material.RABBIT_STEW)) {
      if (paramLiquidTank.getQuantity() < paramLiquidTank.getMaxQuantity()) {
        if (paramLiquidTank.getType().equals(Main.rabbitStewType)) {
          paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 1);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.RABBIT_STEW);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.BOWL) });
        }
        else if (paramLiquidTank.getType().equals(Main.emptyType)) {
          paramLiquidTank.setType(Main.rabbitStewType);
          paramLiquidTank.setQuantity(1);
          paramLiquidTank.updateVisuals();
          paramInventoryMoveItemEvent.setCancelled(false);
          Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.RABBIT_STEW);
          paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.BOWL) });
        }
      }
    }
    else if ((paramItemStack.getType().equals(Material.BEETROOT_SOUP)) && 
      (paramLiquidTank.getQuantity() < paramLiquidTank.getMaxQuantity())) {
      if (paramLiquidTank.getType().equals(Main.beetrootSoupType)) {
        paramLiquidTank.setQuantity(paramLiquidTank.getQuantity() + 1);
        paramLiquidTank.updateVisuals();
        paramInventoryMoveItemEvent.setCancelled(false);
        Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.BEETROOT_SOUP);
        paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.BOWL) });
      }
      else if (paramLiquidTank.getType().equals(Main.emptyType)) {
        paramLiquidTank.setType(Main.beetrootSoupType);
        paramLiquidTank.setQuantity(1);
        paramLiquidTank.updateVisuals();
        paramInventoryMoveItemEvent.setCancelled(false);
        Main.removeItem(paramInventoryMoveItemEvent.getDestination(), Material.BEETROOT_SOUP);
        paramInventoryMoveItemEvent.getSource().addItem(new ItemStack[] { new ItemStack(Material.BOWL) });
      }
    }
  }
}
