package lightdot.debug;

import appeng.api.networking.IGridNode;
import appeng.api.parts.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class PartTest implements IPart
{
	private ISimplifiedBundle renderCache = null;
	private ItemStack is = null;
	private IPartHost host = null;
	private ForgeDirection mySide;
	
	public PartTest(ItemStack is) {
		this.mySide = ForgeDirection.UP;
		this.is = is;
	}
	
	public void getBoxes(IPartCollisionHelper bch) {
		if (this.host != null && this.host.getFacadeContainer().getFacade(this.mySide) != null) {
			bch.addBox(7.0D, 7.0D, 10.0D, 9.0D, 9.0D, 14.0D);
		} else {
			bch.addBox(7.0D, 7.0D, 10.0D, 9.0D, 9.0D, 16.0D);
		}
	}
	
	public ItemStack getItemStack(PartItemStack wrenched) {
		return this.is;
	}
	
	@SideOnly(Side.CLIENT)
	public void renderInventory(IPartRenderHelper instance, RenderBlocks renderer) {
		instance.setTexture(this.is.getIconIndex());
		instance.setBounds(7.0F, 7.0F, 4.0F, 9.0F, 9.0F, 14.0F);
		instance.renderInventoryBox(renderer);
		instance.setTexture( null );
	}
	
	@SideOnly(Side.CLIENT)
	public void renderStatic(int x, int y, int z, IPartRenderHelper rh, RenderBlocks renderer) {
		this.renderCache = rh.useSimplifiedRendering(x, y, z, this, this.renderCache);
		IIcon myIcon = this.is.getIconIndex();
		rh.setTexture(myIcon);
		if (this.host != null && this.host.getFacadeContainer().getFacade(this.mySide) != null) {
			rh.setBounds(7.0F, 7.0F, 10.0F, 9.0F, 9.0F, 14.0F);
		} else {
			rh.setBounds(7.0F, 7.0F, 10.0F, 9.0F, 9.0F, 16.0F);
		}
		
		rh.renderBlock(x, y, z, renderer);
		rh.setTexture( null );
	}
	
	@SideOnly(Side.CLIENT)
	public void renderDynamic(double x, double y, double z, IPartRenderHelper rh, RenderBlocks renderer) {
	}
	
	public IIcon getBreakingTexture() {
		return null;
	}
	
	public boolean requireDynamicRender() {
		return false;
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public boolean canConnectRedstone() {
		return false;
	}
	
	public void writeToNBT(NBTTagCompound data) {
	}
	
	public void readFromNBT(NBTTagCompound data) {
	}
	
	public int getLightLevel() {
		return 0;
	}
	
	public boolean isLadder(EntityLivingBase entity) {
		return this.mySide.offsetY == 0 && (entity.isCollidedHorizontally || !entity.onGround);
	}
	
	public void onNeighborChanged() {
	}
	
	public int isProvidingStrongPower() {
		return 0;
	}
	
	public int isProvidingWeakPower() {
		return 0;
	}
	
	public void writeToStream(ByteBuf data) throws IOException {
	}
	
	public boolean readFromStream(ByteBuf data) throws IOException {
		return false;
	}
	
	public IGridNode getGridNode() {
		return null;
	}
	
	public void onEntityCollision(Entity entity) {
	}
	
	public void removeFromWorld() {
	}
	
	public void addToWorld() {
	}
	
	public IGridNode getExternalFacingNode() {
		return null;
	}
	
	public void setPartHostInfo(ForgeDirection side, IPartHost host, TileEntity tile) {
		this.host = host;
		this.mySide = side;
	}
	
	public boolean onActivate(EntityPlayer player, Vec3 pos) {
		return false;
	}
	
	public boolean onShiftActivate(EntityPlayer player, Vec3 pos) {
		return false;
	}
	
	public void getDrops(List<ItemStack> drops, boolean wrenched) {
	}
	
	public int cableConnectionRenderTo() {
		return 0;
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random r) {
	}
	
	public void onPlacement(EntityPlayer player, ItemStack held, ForgeDirection side) {
	}
	
	public boolean canBePlacedOn(BusSupport what) {
		return what == BusSupport.CABLE || what == BusSupport.DENSE_CABLE;
	}
}
