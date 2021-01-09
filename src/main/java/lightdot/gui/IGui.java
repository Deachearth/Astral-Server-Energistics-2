package lightdot.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lightdot.util.BlockPos;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public interface IGui
{
	Container getContainer( final EntityPlayer p, final World w, final BlockPos pos );

	@SideOnly ( Side.CLIENT )
	GuiScreen getGuiContainer( final EntityPlayer p, final World w, final BlockPos pos );
}
