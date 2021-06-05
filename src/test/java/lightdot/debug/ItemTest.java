package lightdot.debug;

import appeng.api.AEApi;
import appeng.api.implementations.items.IItemGroup;
import appeng.api.parts.IPart;
import appeng.api.parts.IPartItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class ItemTest extends Item implements IPartItem, IItemGroup
{
	public ItemTest() {
		setMaxDamage(0);
		setHasSubtypes(true);
		AEApi.instance().partHelper().setItemBusRenderer(this);
	}
	
	@Override
	public String getUnlocalizedGroupName ( Set<ItemStack> set, ItemStack stack ) {
		return null;
	}
	
	@Nullable
	@Override
	public IPart createPartFromItemStack ( ItemStack stack ) {
		return new PartTest( stack );
	}
	
	@Override
	public EnumRarity getRarity(ItemStack itemStack) {
		if ( itemStack != null && itemStack.getItemDamage() == 0 )
			return super.getRarity( itemStack );
		return EnumRarity.rare;
	}
	
	@Override
	@SideOnly ( Side.CLIENT )
	public int getSpriteNumber() {
		return 0;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void getSubItems(Item item, CreativeTabs creativeTab, List itemList) {
		itemList.add( new ItemStack( item, 1, 0 ) );
	}
	
	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world,
			int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		return AEApi.instance().partHelper().placeBus(is, x, y, z, side, player, world);
	}
}
