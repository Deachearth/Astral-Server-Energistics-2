package lightdot.debug;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ItemDisplayTypeContainer extends Container
{
	public final IInventory inventory;
	public final InventoryPlayer player;

	public ItemDisplayTypeContainer ( InventoryPlayer p, IInventory i )
	{
		this.player = p;
		this.inventory = i;

		this.addSlotToContainer( new Slot( this.inventory, 0, -20,0 ) );
	}

	@Override
	public boolean canInteractWith( EntityPlayer p )
	{
		return true;
	}

	@Override
	public ItemStack transferStackInSlot( EntityPlayer p, int index )
	{
		if ( index < this.inventory.getSizeInventory() )
		{
			return null;
		}
		else if ( index < this.inventory.getSizeInventory() + this.player.mainInventory.length )
		{
			Slot input  = (Slot) this.inventorySlots.get( 0 );
			Slot output = (Slot) this.inventorySlots.get( index );

			if ( output.getHasStack() )
			{
				ItemStack stack = output.getStack().copy();
				stack.stackSize = 1;
				input.putStack( stack );
			}
		}

		return null;
	}
}
