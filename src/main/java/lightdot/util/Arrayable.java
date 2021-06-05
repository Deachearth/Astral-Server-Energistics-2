package lightdot.util;

public final class Arrayable
{
	/** 获取位置 index [0, max) 在数组 array 的内容，失败返回 null. */
	public static <T> T ElementAt( final T[] array, final int index, int max )
	{
		if ( array.length < max )
			max = array.length;
		return -1 < index && index < max ? array[ index ] : null;
	}
	
	/** 获取位置 index [0, array.length) 在数组 array 的内容，失败返回 null. */
	public static <T> T ElementAt( final T[] array, final int index )
	{
		return ElementAt( array, index, array.length );
	}
	
	/** 获取 key 在数组 array 的位置 index [index, count). */
	public static <T> int IndexOf( final T[] array, final T key, final int index, int count )
	{
		if ( ( count += index ) > array.length )
			count = array.length;
		for ( int i = index; i < count; i++ )
		{
			if ( array[ i ] == key )
				return i;
		}
		return -1;
	}
	
	/** 获取 key 在数组 array 的位置 index [index, array.length). */
	public static <T> int IndexOf( final T[] array, final T key, int index )
	{
		return IndexOf( array, key, index, array.length );
	}
	
	/** 获取 key 在数组 array 的位置 index [0, array.length). */
	public static <T> int IndexOf( final T[] array, final T key )
	{
		return IndexOf( array, key, 0, array.length );
	}
	
}
