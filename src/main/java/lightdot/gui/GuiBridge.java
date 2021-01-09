package lightdot.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import lightdot.Astral;
import lightdot.util.BlockPos;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

import java.lang.ref.WeakReference;

public enum GuiBridge implements IGuiHandler, IGui
{
	None;
	
	private WeakReference<IGui> gui;
	
	@Override
	public Object getServerGuiElement( final int ID, final EntityPlayer p, final World w, final int x, final int y, final int z )
	{
		return this.getContainer( p, w, new BlockPos( x, y, z ) );
	}
	
	@Override
	public Object getClientGuiElement( final int ID, final EntityPlayer p, final World w, final int x, final int y, final int z )
	{
		return this.getGuiContainer( p, w, new BlockPos( x, y, z ) );
	}
	
	@Override
	public Container getContainer ( final EntityPlayer p, final World w, final BlockPos pos )
	{
		IGui gui = this.gui.get();
		return gui != null ? gui.getContainer( p, w, pos ) : null;
	}
	
	@Override
	public GuiScreen getGuiContainer ( final EntityPlayer p, final World w, final BlockPos pos )
	{
		IGui gui = this.gui.get();
		return gui != null ? gui.getGuiContainer( p, w, pos ) : null;
	}
	
	
	
	public static GuiBridge Set( final IGui gui )
	{
		None.gui = new WeakReference<IGui>( gui );
		return None;
	}
	
	public void openGui( final EntityPlayer p, final World w )
	{
		p.openGui( Astral.instance, 0, w, p.inventory.currentItem, 0 ,0 );
	}
	
	public void openGui( final EntityPlayer p, final World w, final BlockPos pos )
	{
		p.openGui( Astral.instance, 0, w, pos.getX(), pos.getY() ,pos.getZ() );
	}
}
