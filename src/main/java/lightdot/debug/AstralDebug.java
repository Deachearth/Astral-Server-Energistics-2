package lightdot.debug;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod
(
	modid   = AstralDebug.modID,
	name    = AstralDebug.modName,
	version = AstralDebug.Version,
	acceptedMinecraftVersions = "[1.7.10]",
	dependencies = "required-after:appliedenergistics2"
)
public class AstralDebug
{
	public static final String modID   = "ase2-d";
	public static final String modName = "Astral Server Energistics 2 Debug";
	public static final String Version = "1.0";
	
	@Mod.Instance( AstralDebug.modID )
	public static AstralDebug instance;
	
	@SidedProxy
	(
		clientSide = "lightdot.debug.ClientProxy",
		serverSide = "lightdot.debug.CommonProxy"
	)
	public static CommonProxy proxy;
	
	public static final CreativeTabs AseTab = new CreativeTabs( "AstralServerEnergistics2" ) {
		@Override
		public Item getTabIconItem () {
			return ItemEnum.DebugDisplay.getItem();
		}
	};
	
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
