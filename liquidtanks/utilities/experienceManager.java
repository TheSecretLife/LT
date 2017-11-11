package be.arcaniax.liquidtanks.utilities;

import org.bukkit.entity.Player;

public class experienceManager { public experienceManager() {}
  
  public static void addExp(Player paramPlayer, int paramInt) { paramPlayer.giveExp(paramInt); }
  
  public static void removeExp(Player paramPlayer, int paramInt) {
    int i = totalExp(paramPlayer);
    paramPlayer.setExp(0.0F);
    paramPlayer.setLevel(0);
    addExp(paramPlayer, i - paramInt);
  }
  
  public static int totalExp(Player paramPlayer) { int i = (int)(lvlToExp(paramPlayer.getLevel()) + expToLvlUp(paramPlayer.getLevel()) * paramPlayer.getExp());
    return i;
  }
  
  public static int lvlToExp(int paramInt) {
    int i = 0;
    if ((paramInt <= 16) && (paramInt >= 0)) {
      i = paramInt * paramInt + 6 * paramInt;
    }
    if ((paramInt <= 31) && (paramInt >= 17)) {
      i = (int)(2.5D * paramInt * paramInt - 40.5D * paramInt + 360.0D);
    }
    if (paramInt > 31) {
      i = (int)(4.5D * paramInt * paramInt - 162.5D * paramInt + 2220.0D);
    }
    return i; }
  
  public static int expToLvlUp(int paramInt) { int i = 0;
    if ((paramInt <= 16) && (paramInt >= 0)) {
      i = 2 * paramInt + 7;
    }
    if ((paramInt <= 31) && (paramInt >= 17)) {
      i = 5 * paramInt - 38;
    }
    if (paramInt > 31) {
      i = 9 * paramInt - 158;
    }
    return i;
  }
}
