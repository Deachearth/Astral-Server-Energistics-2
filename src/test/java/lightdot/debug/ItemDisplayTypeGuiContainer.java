package lightdot.debug;

import appeng.items.parts.ItemMultiPart;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class ItemDisplayTypeGuiContainer extends GuiContainer
{
	private final ItemDisplayTypeContainer container;

	public ItemDisplayTypeGuiContainer( Container inventory )
	{
		super( inventory );
		this.container = (ItemDisplayTypeContainer) inventory;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer( float ticks, int x, int y )
	{
		final int black = 0xFF000000;
		
		int width = this.guiLeft + this.xSize;
		int height = this.guiTop + this.ySize;
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.drawRect( this.guiLeft, this.guiTop, width, height, black );
	}

	@Override
	protected void drawGuiContainerForegroundLayer( int x, int y )
	{
		final int white = 0xFFFFFFFF;

		this.fontRendererObj.drawString( Integer.toString( x ), 0, 00, white );
		this.fontRendererObj.drawString( Integer.toString( y ), 0, 10, white );
		
		ItemStack stack = this.container.inventory.getStackInSlot( 0 );
		Item item = stack.getItem();
		if ( item != null )
		{
			this.fontRendererObj.drawString( item.getClass().getName(), 0, 20, white );
		}
		if ( item instanceof ItemBlock )
		{
			Block block = ((ItemBlock) item).field_150939_a;
			this.fontRendererObj.drawString( block.getClass().getName(), 0, 30, white );
		}
		if ( item instanceof ItemMultiPart )
		{
			ItemMultiPart itemPart = (ItemMultiPart) item;
			this.fontRendererObj.drawString( itemPart.getTypeByStack( stack ).name(), 0, 40, white );
		}
	}
}
