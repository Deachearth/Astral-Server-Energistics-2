package lightdot.debug;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
	@Override
	public void init( final FMLInitializationEvent event )
	{
		MinecraftForge.EVENT_BUS.register( this );
		super.init( event );
		this.registerRenderers();
	}
	
	protected void registerRenderers()
	{
	}
	
	@SubscribeEvent
	protected void registerTextures( TextureStitchEvent.Pre textureStitchEvent )
	{
	}
	
	@Override
	protected boolean isClient()
	{
		return true;
	}
	
	@Override
	protected boolean isServer()
	{
		return false;
	}
}
