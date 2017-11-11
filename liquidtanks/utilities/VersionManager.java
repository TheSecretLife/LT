package be.arcaniax.liquidtanks.utilities;

import be.arcaniax.liquidtanks.Main;
import be.arcaniax.liquidtanks.liquidTank;
import be.arcaniax.liquidtanks.liquidTank_v1_12_R1;
import be.arcaniax.liquidtanks.tankInteract;
import be.arcaniax.liquidtanks.tankInteract_v1_9_plus;
import org.bukkit.Location;


public class VersionManager
{
  String version;
  
  public VersionManager()
  {
    String str = Main.instance.getServer().getClass().getPackage().getName();
    version = str.substring(str.lastIndexOf('.') + 1);
  }
  
  public tankInteract getTankInteract() {
    return new tankInteract_v1_9_plus();
  }
  
  public liquidTank createLiquidTank(Location paramLocation)
  {
    return new liquidTank_v1_12_R1(paramLocation);
  }
  
  public liquidTank createLiquidTank(Location paramLocation, int paramInt, String paramString)
  { 
    return new liquidTank_v1_12_R1(paramLocation, paramInt, paramString);
  }
  
  public titleManager getTitleManager()
  {
     return new titleManager_v1_12_R1();
  }
}
