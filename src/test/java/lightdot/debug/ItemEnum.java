package lightdot.debug;

import net.minecraft.item.Item;

public enum ItemEnum
{
	ItemTest( new ItemTest(), "ae.test"),
	DebugDisplay( new ItemDisplayType(), "debug.display" ),
	ItemToolTest( new ItemTool(), "debug.tool"),
	;
	
	private final Item item;
	
	ItemEnum ( Item item, String name )
	{
		item.setUnlocalizedName( "ase." + name );
		item.setCreativeTab( AstralDebug.AseTab );
		this.item = item;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public String getInternalName() {
		return this.item.getUnlocalizedName();
	}
}
