package lightdot.proxy;

import appeng.api.AEApi;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import lightdot.Astral;
import lightdot.gui.GuiBridge;

import java.io.File;

public class CommonProxy
{
	public void preInit( final FMLPreInitializationEvent event )
	{
		this.registerItems();
		this.registerBlocks();
	}
	
	public void init( final FMLInitializationEvent event )
	{
		NetworkRegistry.INSTANCE.registerGuiHandler( Astral.instance, GuiBridge.None );
		this.registerTileEntities();
		this.addRecipes();
	}
	
	public void postInit( final FMLPostInitializationEvent event )
	{
	}
	
	protected void addRecipes()
	{
	}
	
	protected void registerBlocks()
	{
	}
	
	protected void registerItems()
	{
	}
	
	protected void registerTileEntities()
	{
	}
	
	protected boolean isClient()
	{
		return false;
	}
	
	protected boolean isServer()
	{
		return true;
	}
}
