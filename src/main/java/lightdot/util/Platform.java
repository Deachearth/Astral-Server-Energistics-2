package lightdot.util;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public final class Platform
{
	
	public static final String Empty = "";
	
	/** true if the code is on the client. */
	public static boolean isClient()
	{
		return FMLCommonHandler.instance().getEffectiveSide().isClient();
	}

	/** true if the code is on the server. */
	public static boolean isServer()
	{
		return FMLCommonHandler.instance().getEffectiveSide().isServer();
	}
	
	/** 获取 {@link TileEntity} 的 {@link BlockPos}. */
	public static BlockPos getEntityPos( TileEntity entity )
	{
		return new BlockPos( entity.xCoord, entity.yCoord, entity.zCoord );
	}
	
	/** 获取 {@link ItemStack} 的 {@link Item}. */
	public static Item getForItemStack( final ItemStack stack )
	{
		return stack != null ? stack.getItem() : null;
	}
	
	/** 获取位置 index [0, max) 在数组 array 的内容，失败返回 null. */
	public static <T> T getForArray( final T[] array, final int max, final int index )
	{
		return index < max && index >= 0 ? array[ index ] : null;
	}
	
	/** 获取位置 index [0, array.length) 在数组 array 的内容，失败返回 null. */
	public static <T> T getForArray( final T[] array, final int index )
	{
		return getForArray( array, array.length, index );
	}
	
	/** 获取 key 在数组 array 的位置 index [0, array.length). */
	public static <T> int getIndexForArray( final T[] array, final T key )
	{
		for ( int i = 0; i < array.length; i++ )
		{
			if ( array[ i ] == key )
				return i;
		}
		return -1;
	}
	
}
