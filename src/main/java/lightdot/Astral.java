package lightdot;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lightdot.proxy.CommonProxy;

@Mod
(
	modid   = Astral.modID,
	name    = Astral.modName,
	version = Astral.Version,
	acceptedMinecraftVersions = "[1.7.10]"
)
public final class Astral
{
	public static final String modID   = "astralserverenergistics2";
	public static final String modName = "Astral Server Energistics 2";
	public static final String Version = "1.0";

	@Mod.Instance( Astral.modID )
	public static Astral instance;
	
	@SidedProxy
	(
		clientSide = "lightdot.proxy.ClientProxy",
		serverSide = "lightdot.proxy.CommonProxy"
	)
    public static CommonProxy proxy;
	
	@Mod.EventHandler
    public void preInit( final FMLPreInitializationEvent event )
    {
		proxy.preInit( event );
    }
	
    @Mod.EventHandler
    public void init( final FMLInitializationEvent event )
    {
    	proxy.init( event );
    }
    
    @Mod.EventHandler
    public void postInit( final FMLPostInitializationEvent event )
    {
    	proxy.postInit( event );
    }
}
