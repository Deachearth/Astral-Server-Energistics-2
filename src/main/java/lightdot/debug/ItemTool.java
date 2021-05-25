package lightdot.debug;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lightdot.util.Platform;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import java.util.List;
import java.util.Set;

public class ItemTool extends Item
{
	public ItemTool()
	{
		this.maxStackSize = 1;
		this.setMaxDamage( 100 );
		this.setNoRepair();
		this.canRepair = false;
		
		this.setHarvestLevel( "pickaxe", 1 );
	}
	
	/**
	 * 是否调用 {@link Block} 默认掉落
	 * @param block 该方块的掉落
	 * @return 执行操作
	 */
	@Override
	public boolean func_150897_b ( Block block )
	{
		return false;
	}
	
	/**
	 * 挖掘速度
	 * @param stack 手中的物品
	 * @param block 破坏的方块
	 * @return 速度
	 */
	@Override
	public float func_150893_a ( ItemStack stack, Block block )
	{
		return 9000.0F;
	}
	
	
	static final String[] MaterialsName =
	{
		"air",    "grass",         "ground",
		"wood",   "rock",          "iron",
		"anvil",  "water",         "lava",
		"leaves", "plants",        "vine",
		"sponge", "cloth",         "fire",
		"sand",   "circuits",      "carpet",
		"glass",  "redstoneLight", "tnt",
		"coral",  "ice",           "packedIce",
		"snow",	  "craftedSnow",   "cactus",
		"clay",   "gourd",         "dragonEgg",
		"portal", "cake",          "web",
		"piston"
	};
	static final Material[] Materials =
	{
		Material.air,    Material.grass,         Material.ground,
		Material.wood,   Material.rock,          Material.iron,
		Material.anvil,	 Material.water,         Material.lava,
		Material.leaves, Material.plants,        Material.vine,
		Material.sponge, Material.cloth,         Material.fire,
		Material.sand,   Material.circuits,      Material.carpet,
		Material.glass,	 Material.redstoneLight, Material.tnt,
		Material.coral,  Material.ice,           Material.packedIce,
		Material.snow,   Material.craftedSnow,   Material.cactus,
		Material.clay,   Material.gourd,         Material.dragonEgg,
		Material.portal, Material.cake,          Material.web,
		Material.piston
	};
	
	int startBreakCount = 1;
	boolean startBreakIs = false;
	
	/**
	 * 方块破坏前调用的函数
	 * @param stack 手中的物品
	 * @param x 方块X坐标
	 * @param y 方块Y坐标
	 * @param z 方块Z坐标
	 * @param p 人物
	 * @return 真，停止挖掘
	 */
	@Override
	public boolean onBlockStartBreak ( ItemStack stack, int x, int y, int z, EntityPlayer p )
	{
		if ( AstralDebug.proxy.isClient() && ( this.startBreakIs = !this.startBreakIs ) )
		{
			Block b = p.worldObj.getBlock( x, y, z );
			int index = Platform.getIndexForArray( Materials, b.getMaterial() );
			String printf;
			if ( -1 < index )
			{
				printf = String.format( "%d; %s; %s.", startBreakCount++, b.getUnlocalizedName(), MaterialsName[ index ] );
			}
			else
			{
				printf = String.format( "%d; %s.", startBreakCount++, b.getUnlocalizedName() );
			}
			p.addChatMessage( new ChatComponentText( printf ) );
		}
		return false;
	}
	
	/**
	 * 命中
	 * @param stack 手中的物品
	 */
	@Override
	public boolean hitEntity ( ItemStack stack, EntityLivingBase a, EntityLivingBase p )
	{
		return true;
	}
	
	/** 右键 */
	@Override
	public ItemStack onItemRightClick ( ItemStack stack, World w, EntityPlayer p )
	{
		return stack;
	}
	
	/** 右键 */
	@Override
	public boolean onItemUse ( ItemStack stack, EntityPlayer p, World w, int x, int y, int z, int side,
			float clickX, float clickY, float clickZ )
	{
		return false;
	}
	
	@Override
	public final Set<String> getToolClasses ( ItemStack stack )
	{
		return super.getToolClasses( stack );
	}
	
	@Override
	public final int getHarvestLevel ( ItemStack stack, String toolClass )
	{
		return super.getHarvestLevel( stack, toolClass );
	}
	
	@Override
	public final void setHarvestLevel ( String toolClass, int level )
	{
		super.setHarvestLevel( toolClass, level );
	}
	
	@Override
	@SideOnly( Side.CLIENT )
	public boolean requiresMultipleRenderPasses()
	{
		return false;
	}
	
	@Override
	@SideOnly( Side.CLIENT )
	public int getRenderPasses ( int meta )
	{
		return 0;
	}
	
	@Override
	@SideOnly( Side.CLIENT )
	public boolean hasEffect ( ItemStack stack )
	{
		return false;
	}
	
	/**
	 * 手中显示的信息 {@func_77624_a} 。
	 * @param stack 手中的物品
	 * @param p 人物
	 * @param info 信息
	 * @param p_77624_4_ {没法判断，这是干什么的。}
	 */
	@Override
	@SideOnly ( Side.CLIENT )
	public void addInformation ( ItemStack stack, EntityPlayer p, List info, boolean p_77624_4_ )
	{
		info.add( String.valueOf( p_77624_4_ ) );
		info.add( stack.toString() );
	}
	
	@Override
	@SideOnly ( Side.CLIENT )
	public IIcon getIcon ( ItemStack stack, int renderPass, EntityPlayer p, ItemStack using, int useRemaining )
	{
		return getIcon( stack, renderPass );
	}
	
	@Override
	@SideOnly ( Side.CLIENT )
	public IIcon getIcon ( ItemStack stack, int pass )
	{
		return getIconFromDamageForRenderPass( stack.getItemDamage(), pass );
	}
	
	@Override
	@SideOnly ( Side.CLIENT )
	public IIcon getIconFromDamageForRenderPass ( int meta, int pass )
	{
		return this.getIconFromDamage( meta );
	}
	
	@Override
	@SideOnly ( Side.CLIENT )
	public IIcon getIconIndex ( ItemStack stack )
	{
		return this.getIconFromDamage( stack.getItemDamage() );
	}
	
	@Override
	@SideOnly ( Side.CLIENT )
	public IIcon getIconFromDamage ( int meta )
	{
		return this.itemIcon;
	}
	
	@Override
	protected String getIconString ()
	{
		return super.getIconString();
	}
	
	@Override
	public Item setTextureName ( String iconString )
	{
		return super.setTextureName( iconString );
	}
	
	@Override
	@SideOnly ( Side.CLIENT )
	public void registerIcons ( IIconRegister iicon )
	{
		super.registerIcons( iicon );
	}
	
	private void printfDebug( String message )
	{
		System.out.print( message );
	}
}
