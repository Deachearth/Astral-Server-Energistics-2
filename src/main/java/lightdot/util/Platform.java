package lightdot.util;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public final class Platform
{
	/** 空字符串 */
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
	
}
