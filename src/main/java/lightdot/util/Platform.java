package lightdot.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.tileentity.TileEntity;

public class Platform
{
	/*
	 * returns true if the code is on the client.
	 */
	public static boolean isClient()
	{
		return FMLCommonHandler.instance().getEffectiveSide().isClient();
	}

	/*
	 * returns true if the code is on the server.
	 */
	public static boolean isServer()
	{
		return FMLCommonHandler.instance().getEffectiveSide().isServer();
	}
	
	public static BlockPos getEntityPos( TileEntity entity )
	{
		return new BlockPos( entity.xCoord, entity.yCoord, entity.zCoord );
	}

	public static Item getForItemStack( final ItemStack stack )
	{
		return stack != null ? stack.getItem() : null;
	}
	
	public static <T> T getForArray( final T[] array, final int max, final int index )
	{
		return index < max && index >= 0 ? array[ index ] : null;
	}
	
	public static <T> T getForArray( final T[] array, final int index )
	{
		return getForArray( array, array.length, index );
	}
	
	public static NBT getTagCompound( final ItemStack stack )
	{
		if ( stack.hasTagCompound() )
		{
			return NBT.translatorNBT( stack.getTagCompound() );
		}
		else
		{
			NBT nbt = new NBT();
			stack.setTagCompound( nbt );
			return nbt;
		}
	}
}
