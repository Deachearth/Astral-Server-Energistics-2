package lightdot.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lightdot.util.Platform;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public abstract class ItemCore extends Item
{
	public final String getInternalName ()
	{
		return this.iconString;
	}
	
	public final ItemCore setInternalName( String name )
	{
		this.setInternalName( name );
		this.iconString = name;
		return this;
	}
	
	/**
	 * 右键
	 */
	@Override
	public boolean onItemUse ( ItemStack stack, EntityPlayer p, World w, int x, int y, int z, int side,
			float clickX, float clickY, float clickZ )
	{
		return false;
	}
	
	/**
	 * 手中显示的信息。{#func_77624_a}
	 * @param stack 手中的物品
	 * @param p 人物
	 * @param info 信息
	 * @param p_77624_4_ {没法判断，这是干什么的。}
	 */
	@Override
	@SideOnly ( Side.CLIENT )
	public void addInformation ( ItemStack stack, EntityPlayer p, List info, boolean p_77624_4_ )
	{
	}
	
	@Override
	@SideOnly ( Side.CLIENT )
	public void registerIcons ( IIconRegister register )
	{
		this.itemIcon = register.registerIcon( super.getIconString() );
	}
	
	@Override
	@SideOnly ( Side.CLIENT )
	protected final String getIconString ()
	{
		return Platform.Empty;
	}
	
	@Override
	public final Item setTextureName ( String texture )
	{
		return this;
	}
}
