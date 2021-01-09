package lightdot.core;

public class MathHelper
{
	/**
	 * Returns the greatest integer less than or equal to the double argument
	 */
	public static int floor( double value )
	{
		int i = (int) value;
		return value < (double) i ? i - 1 : i;
	}
	
	/**
	 * Returns the input value rounded up to the next highest power of two.
	 */
	public static int smallestEncompassingPowerOfTwo( int value )
	{
		int i = value - 1;
		i = i | i >> 1;
		i = i | i >> 2;
		i = i | i >> 4;
		i = i | i >> 8;
		i = i | i >> 16;
		return i + 1;
	}
	
	/**
	 * Efficiently calculates the floor of the base-2 log of an integer value.  This is effectively the index of the
	 * highest bit that is set.  For example, if the number in binary is 0...100101, this will return 5.
	 */
	public static int log2( int value )
	{
		return log2DeBruijn( value ) - ( isPowerOfTwo( value ) ? 0 : 1 );
	}
	
	public static int log2DeBruijn( int value )
	{
		/**
		 * Though it looks like an array, this is really more like a mapping. Key (index of this array) is the upper 5 bits
		 * of the result of multiplying a 32-bit unsigned integer by the B(2, 5) De Bruijn sequence 0x077CB531. Value (value
		 * stored in the array) is the unique index (from the right) of the leftmo
		 */
		final int[] MULTIPLY_DE_BRUIJN_BIT_POSITION = new int[]{0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9};
		value = isPowerOfTwo( value ) ? value : smallestEncompassingPowerOfTwo( value );
		return MULTIPLY_DE_BRUIJN_BIT_POSITION[ (int) ( (long) value * 125613361L >> 27 ) & 31 ];
	}
	
	/**
	 * Is the given value a power of two?  (1, 2, 4, 8, 16, ...)
	 */
	public static boolean isPowerOfTwo(int value)
	{
		return value != 0 && ( value & value - 1 ) == 0;
	}
}
