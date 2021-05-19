package lightdot.debug;

import lightdot.gui.GuiBridge;
import lightdot.gui.IGui;
import lightdot.util.BlockPos;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDisplayType extends Item implements IGui
{
	protected String InternalName;
	
	@Override
	public String getUnlocalizedName ( ItemStack stack ) {
		return this.InternalName;
	}
	
	@Override
	public String getUnlocalizedName () {
		return this.InternalName;
	}
	
	@Override
	public Item setUnlocalizedName ( String name ) {
		this.InternalName = name;
		return this;
	}
	
	@Override
	public ItemStack onItemRightClick( ItemStack stack, World w, EntityPlayer p )
	{
		GuiBridge.Set( this ).openGui( p, w );
		return stack;
	}
	
	@Override
	public Container getContainer ( EntityPlayer p, World w, BlockPos pos )
	{
		IInventory inventory = new InventoryDisplayType();
		inventory.setInventorySlotContents( 0, p.inventory.mainInventory[ 0 ] );
		return new ItemDisplayTypeContainer( p.inventory, inventory );
	}
	
	@Override
	public GuiScreen getGuiContainer ( EntityPlayer p, World w, BlockPos pos )
	{
		// return new net.minecraft.client.gui.GuiScreen(); // run ok.
		return new ItemDisplayTypeGuiContainer( this.getContainer( p, w, pos ) );
	}
}
