package lightdot.util;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class NBTable
{
	protected NBTTagCompound nbt;
	
	public NBTable( NBTTagCompound value )
	{
		if ( value == null )
			value = new NBTTagCompound();
		this.nbt = value;
	}
	
	public NBTTagCompound getNBTTagCompound()
	{
		return this.nbt;
	}
	
	
	
	public boolean isEmpty()
	{
		return this.nbt.hasNoTags();
	}
	
	public void remove( final String name )
	{
		this.nbt.removeTag( name );
	}
	
	public NBTTagCompound copy()
	{
		return (NBTTagCompound) this.nbt.copy();
	}
	
	
	
	public NBTTagCompound getCompoundTag( final String... names )
	{
		if ( names == null || names.length < 1 )
			return null;
		NBTTagCompound nbt = null, value = this.nbt;
		for ( String name : names )
		{
			nbt = value;
			if ( !nbt.hasKey( name ) )
				return null;
			value = nbt.getCompoundTag( name );
		}
		return value;
	}
	
	public NBTTagCompound setCompoundTag( final String... names )
	{
		if ( names == null || names.length < 1 )
			return null;
		NBTTagCompound nbt = null, value = this.nbt;
		for ( String name : names )
		{
			nbt = value;
			if ( nbt.hasKey( name ) )
				value = nbt.getCompoundTag( name );
			else
				nbt.setTag( name, value = new NBTTagCompound() );
		}
		return value;
	}
	
	
	
	public void set( final String name, final NBTBase nbt ) {
		this.nbt.setTag( name, nbt );
	}
	
	public void set( final String name, final byte value ) {
		this.nbt.setByte( name, value );
	}
	
	public void set( final String name, final short value )
	{
		this.nbt.setShort( name, value );
	}
	
	public void set( final String name, final int value ) {
		this.nbt.setInteger( name, value );
	}
	
	public void set( final String name, final long value ) {
		this.nbt.setLong( name, value );
	}
	
	public void set( final String name, final float value ) {
		this.nbt.setFloat( name, value );
	}
	
	public void set( final String name, final double value ) {
		this.nbt.setDouble( name, value );
	}
	
	public void set( final String name, final String value ) {
		this.nbt.setString( name, value );
	}
	
	public void set( final String name, final byte[] value ) {
		this.nbt.setByteArray( name, value );
	}
	
	public void set( final String name, final int[] value ) {
		this.nbt.setIntArray( name, value );
	}
}
