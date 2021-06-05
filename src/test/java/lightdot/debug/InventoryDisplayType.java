package lightdot.debug;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryDisplayType implements IInventory
{
	protected ItemStack stack;

	@Override
	public int getSizeInventory ()
	{
		return 1;
	}

	@Override
	public ItemStack getStackInSlot ( int index )
	{
		return this.stack;
	}

	@Override
	public ItemStack decrStackSize ( int index, int number )
	{
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing ( int index )
	{
		return null;
	}

	@Override
	public void setInventorySlotContents ( int index, ItemStack other )
	{
		this.stack = other;

		if ( this.stack != null && this.stack.stackSize > 1 ) {
			this.stack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName ()
	{
		return null;
	}

	@Override
	public boolean hasCustomInventoryName ()
	{
		return false;
	}

	@Override
	public int getInventoryStackLimit ()
	{
		return 1;
	}

	@Override
	public void markDirty () {
	}

	@Override
	public boolean isUseableByPlayer ( EntityPlayer p )
	{
		return true;
	}

	@Override
	public void openInventory () {
	}

	@Override
	public void closeInventory () {
	}

	@Override
	public boolean isItemValidForSlot ( int index, ItemStack other )
	{
		return false;
	}
}
