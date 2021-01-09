package lightdot.util;

import lightdot.core.MathHelper;
import net.minecraft.dispenser.IPosition;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockPos
{
	/** An immutable block pos with zero as all coordinates. */
	public  static final BlockPos ZERO = new BlockPos(0, 0, 0);
	private static final int NUM_X_BITS = 1 + MathHelper.log2( MathHelper.smallestEncompassingPowerOfTwo( 30000000 ) );
	private static final int NUM_Z_BITS = NUM_X_BITS;
	private static final int NUM_Y_BITS = 64 - NUM_X_BITS - NUM_Z_BITS;
	private static final long X_MASK = ( 1L << NUM_X_BITS ) - 1L;
	private static final long Y_MASK = ( 1L << NUM_Y_BITS ) - 1L;
	private static final long Z_MASK = ( 1L << NUM_Z_BITS ) - 1L;
	private static final int INVERSE_START_BITS_Z = NUM_Y_BITS;
	private static final int INVERSE_START_BITS_X = NUM_Y_BITS + NUM_Z_BITS;
	
	private int x;
	private int y;
	private int z;
	
	public BlockPos( int x, int y, int z )
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public BlockPos( double x, double y, double z )
	{
		this( MathHelper.floor( x ), MathHelper.floor( y ), MathHelper.floor( z ) );
	}
	
	public BlockPos( IPosition pos )
	{
		this( pos.getX(), pos.getY(), pos.getZ() );
	}
	
	public static long offset( long pos, int x, int y, int z )
	{
		return pack( unpackX( pos ) + x, unpackY( pos ) + y, unpackZ( pos ) + z );
	}
	
	public static long offset( long pos, BlockPos dPos )
	{
		return offset( pos,	dPos.getX(), dPos.getY(), dPos.getZ() );
	}
	
	public static int unpackX( long packedPos )
	{
		return (int) ( packedPos << 64 - INVERSE_START_BITS_X - NUM_X_BITS >> 64 - NUM_X_BITS );
	}
	
	public static int unpackY( long packedPos )
	{
		return (int) ( packedPos << 64 - NUM_Y_BITS >> 64 - NUM_Y_BITS );
	}
	
	public static int unpackZ( long packedPos )
	{
		return (int) ( packedPos << 64 - INVERSE_START_BITS_Z - NUM_Z_BITS >> 64 - NUM_Z_BITS );
	}
	
	public static BlockPos fromLong( long packedPos )
	{
		return new BlockPos( unpackX( packedPos ), unpackY( packedPos ), unpackZ( packedPos ) );
	}
	
	public long toLong()
	{
		return pack( this.getX(), this.getY(), this.getZ() );
	}
	
	public static long pack( int x, int y, int z )
	{
		long i = 0L;
			 i = i | ( (long) x & X_MASK ) << INVERSE_START_BITS_X;
			 i = i | ( (long) y & Y_MASK ) << 0;
		return   i | ( (long) z & Z_MASK ) << INVERSE_START_BITS_Z;
	}
	
	public static long atSectionBottomY( long packedPos )
	{
		return packedPos & -16L;
	}
	
	/**
	 * Add the given coordinates to the coordinates of this BlockPos
	 */
	public BlockPos add( double x, double y, double z )
	{
		if ( x == 0D && y == 0D && z == 0D ) return this;
		return new BlockPos( this.getX() + x, this.getY() + y, this.getZ() + z );
	}
	
	/**
	 * Add the given coordinates to the coordinates of this BlockPos
	 */
	public BlockPos add( int x, int y, int z )
	{
		if ( x == 0 && y == 0 && z == 0 ) return this;
		return new BlockPos( this.getX() + x, this.getY() + y, this.getZ() + z );
	}
	
	/**
	 * Add the given BlockPos to this BlockPos
	 */
	public BlockPos add( BlockPos pos )
	{
		return this.add( pos.getX(), pos.getY(), pos.getZ() );
	}
	
	/**
	 * Subtract the given BlockPos from this BlockPos
	 */
	public BlockPos subtract( BlockPos pos )
	{
		return this.add( -pos.getX(), -pos.getY(), -pos.getZ() );
	}
	
	/**
	 * Offset this BlockPos 1 block up
	 */
	public BlockPos up()
	{
		return this.offset( ForgeDirection.UP );
	}
	
	/**
	 * Offset this BlockPos n blocks up
	 */
	public BlockPos up( int n )
	{
		return this.offset( ForgeDirection.UP, n );
	}
	
	/**
	 * Offset this BlockPos 1 block down
	 */
	public BlockPos down()
	{
		return this.offset( ForgeDirection.DOWN );
	}
	
	/**
	 * Offset this BlockPos n blocks down
	 */
	public BlockPos down( int n )
	{
		return this.offset( ForgeDirection.DOWN, n );
	}
	
	/**
	 * Offset this BlockPos 1 block in northern direction
	 */
	public BlockPos north()
	{
		return this.offset( ForgeDirection.NORTH );
	}
	
	/**
	 * Offset this BlockPos n blocks in northern direction
	 */
	public BlockPos north( int n )
	{
		return this.offset( ForgeDirection.NORTH, n );
	}
	
	/**
	 * Offset this BlockPos 1 block in southern direction
	 */
	public BlockPos south()
	{
		return this.offset( ForgeDirection.SOUTH );
	}
	
	/**
	 * Offset this BlockPos n blocks in southern direction
	 */
	public BlockPos south( int n )
	{
		return this.offset( ForgeDirection.SOUTH, n );
	}
	
	/**
	 * Offset this BlockPos 1 block in western direction
	 */
	public BlockPos west()
	{
		return this.offset( ForgeDirection.EAST );
	}
	
	/**
	 * Offset this BlockPos n blocks in western direction
	 */
	public BlockPos west( int n )
	{
		return this.offset( ForgeDirection.WEST, n );
	}
	
	/**
	 * Offset this BlockPos 1 block in eastern direction
	 */
	public BlockPos east()
	{
		return this.offset( ForgeDirection.EAST );
	}
	
	/**
	 * Offset this BlockPos n blocks in eastern direction
	 */
	public BlockPos east( int n )
	{
		return this.offset( ForgeDirection.EAST, n );
	}
	
	/**
	 * Offset this BlockPos 1 block in the given direction
	 */
	public BlockPos offset( ForgeDirection facing )
	{
		return new BlockPos
		(
			this.getX() + facing.offsetX,
			this.getY() + facing.offsetY,
			this.getZ() + facing.offsetZ
		);
	}
	
	/**
	 * Offsets this BlockPos n blocks in the given direction
	 */
	public BlockPos offset( ForgeDirection facing, int n )
	{
		if ( n == 0 ) return this;
		return new BlockPos
		(
			this.getX() + facing.offsetX * n,
			this.getY() + facing.offsetY * n,
			this.getZ() + facing.offsetZ * n
		);
	}
	
	public BlockPos rotate( Rotation rotation )
	{
		switch( rotation )
		{
			case NONE:
			default:					return this;
			case CLOCKWISE_90:			return new BlockPos( -this.getZ(), this.getY(),  this.getX() );
			case CLOCKWISE_180:			return new BlockPos( -this.getX(), this.getY(), -this.getZ() );
			case COUNTERCLOCKWISE_90:	return new BlockPos(  this.getZ(), this.getY(), -this.getX() );
		}
	}
	
	/**
	 * Calculate the cross product of this and the given Vector
	 */
	public BlockPos crossProduct( BlockPos pos )
	{
		return new BlockPos
		(
			this.getY() * pos.getZ() - this.getZ() * pos.getY(),
			this.getZ() * pos.getX() - this.getX() * pos.getZ(),
			this.getX() * pos.getY() - this.getY() * pos.getX()
		);
	}
	
	/**
	 * Returns a version of this BlockPos that is guaranteed to be immutable.
	 *
	 * <p>When storing a BlockPos given to you for an extended period of time, make sure you
	 * use this in case the value is changed internally.</p>
	 */
	public BlockPos toImmutable()
	{
		return this;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getZ()
	{
		return this.z;
	}
	
	protected void setX( int x )
	{
		this.x = x;
	}
	
	protected void setY( int y )
	{
		this.y = y;
	}
	
	protected void setZ( int z )
	{
		this.z = z;
	}
}
