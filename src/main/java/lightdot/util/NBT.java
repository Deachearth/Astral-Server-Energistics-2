package lightdot.util;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

import java.util.Iterator;

public class NBT extends NBTTagCompound
{
	public boolean isEmpty() {
		return this.hasNoTags();
	}
	
	public void remove( final String name ) {
		this.removeTag( name );
	}
	
	@Override
	public NBT copy ()
	{
		NBT value = new NBT();
		
		Iterator iterator = value.func_150296_c().iterator();
		while ( iterator.hasNext() )
		{
			String s = (String) iterator.next();
			value.setTag( s, this.getTag( s ).copy() );
		}
		
		return value;
	}
	
	
	
	@Override
	public NBT getCompoundTag( final String name ) {
		NBTTagCompound nbt = super.getCompoundTag( name );
		NBT value = null;
		
		if ( nbt == null) {
			value = new NBT();
		}
		else if ( nbt instanceof NBT ) {
			return (NBT) nbt;
		} else {
			value = new NBT();
			Iterator iterator = nbt.func_150296_c().iterator();
			while ( iterator.hasNext() )
			{
				String s = (String) iterator.next();
				value.setTag( s, nbt.getTag( s ).copy() );
			}
		}
		
		this.set( name, value );
		return value;
	}
	
	public byte get( final String name, final byte def ) {
		if ( this.hasKey( name ) ) {
			return this.getByte( name );
		}
		else {
			this.set( name, def );
			return def;
		}
	}
	
	public short get( final String name, final short def ) {
		if ( this.hasKey( name ) ) {
			return this.getShort( name );
		}
		else {
			this.set( name, def );
			return def;
		}
	}
	
	public int get( final String name, final int def ) {
		if ( this.hasKey( name ) ) {
			return this.getInteger( name );
		}
		else {
			this.set( name, def );
			return def;
		}
	}
	
	public long get( final String name, final long def ) {
		if ( this.hasKey( name ) ) {
			return this.getLong( name );
		}
		else {
			this.set( name, def );
			return def;
		}
	}
	
	public float get( final String name, final float def ) {
		if ( this.hasKey( name ) ) {
			return this.getFloat( name );
		}
		else {
			this.set( name, def );
			return def;
		}
	}
	
	public double get( final String name, final double def ) {
		if ( this.hasKey( name ) ) {
			return this.getDouble( name );
		}
		else {
			this.set( name, def );
			return def;
		}
	}
	
	public String get( final String name, final String def ) {
		if ( this.hasKey( name ) ) {
			return this.getString( name );
		}
		else {
			this.set( name, def );
			return def;
		}
	}
	
	public byte[] get( final String name, final byte[] def ) {
		if ( this.hasKey( name ) ) {
			return this.getByteArray( name );
		}
		else {
			this.set( name, def );
			return def;
		}
	}
	
	public int[] get( final String name, final int[] def ) {
		if ( this.hasKey( name ) ) {
			return this.getIntArray( name );
		}
		else {
			this.set( name, def );
			return def;
		}
	}
	
	
	
	public void set( final String name, final NBTBase nbt ) {
		this.setTag( name, nbt );
	}
	
	public void set( final String name, final byte value ) {
		this.setByte( name, value );
	}
	
	public void set( final String name, final short value )
	{
		this.setShort( name, value );
	}
	
	public void set( final String name, final int value ) {
		this.setInteger( name, value );
	}
	
	public void set( final String name, final long value ) {
		this.setLong( name, value );
	}
	
	public void set( final String name, final float value ) {
		this.setFloat( name, value );
	}
	
	public void set( final String name, final double value ) {
		this.setDouble( name, value );
	}
	
	public void set( final String name, final String value ) {
		this.setString( name, value );
	}
	
	public void set( final String name, final byte[] value ) {
		this.setByteArray( name, value );
	}
	
	public void set( final String name, final int[] value ) {
		this.setIntArray( name, value );
	}
	
	
	
	public static NBT translatorNBT ( final NBTTagCompound nbt )
	{
		if ( nbt == null) {
			return null;
		}
		else if ( nbt instanceof NBT ) {
			return (NBT) nbt;
		} else {
			NBT value = new NBT();
			Iterator iterator = nbt.func_150296_c().iterator();
			while ( iterator.hasNext() )
			{
				String s = (String) iterator.next();
				value.setTag( s, nbt.getTag( s ).copy() );
			}
			return value;
		}
	}
}
