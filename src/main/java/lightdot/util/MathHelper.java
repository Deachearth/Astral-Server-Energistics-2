package lightdot.core;

public class MathHelper
{
	/**
	 * 返回最大整数小于或等于参数
	 * Returns the greatest integer less than or equal to the double argument
	 */
	public static int floor( double value )
	{
		int i = (int) value;
		return value < (double) i ? i - 1 : i;
	}
	
	/**
	 * 将输入值四舍五入到两个最大功率的下一个最高功率。
	 * Returns the input value rounded up to the next highest power of two.
	 */
	public static int smallestEncompassingPowerOfTwo( int value )
	{
		int i = value - 1;
		i = i | i >>  1;
		i = i | i >>  2;
		i = i | i >>  4;
		i = i | i >>  8;
		i = i | i >> 16;
		return i + 1;
	}
	
	/**
	 * 高效计算整数值的基-2日志的地板。 这实际上是设置的最高位的索引。 例如，如果二进制文件中的数字为 0...100101，则返回 5。
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
		 * 虽然它看起来像一个阵列，这真的更像一个映射。
		 * 密钥（此阵列的索引）是将 B(2, 5) De Bruijn 序列0x077CB531乘以 32 位未签名整数的结果的上 5 位。
		 * 值（存储在阵列中的价值）是左莫（从右侧）的独特索引
		 * Though it looks like an array, this is really more like a mapping. Key (index of this array) is the upper 5 bits
		 * of the result of multiplying a 32-bit unsigned integer by the B(2, 5) De Bruijn sequence 0x077CB531. Value (value
		 * stored in the array) is the unique index (from the right) of the leftmo
		 */
		final int[] MULTIPLY_DE_BRUIJN_BIT_POSITION = new int[]{0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9};
		value = isPowerOfTwo( value ) ? value : smallestEncompassingPowerOfTwo( value );
		return MULTIPLY_DE_BRUIJN_BIT_POSITION[ (int) ( (long) value * 125613361L >> 27 ) & 31 ];
	}
	
	/**
	 * 给定值是两种力量吗？ (1, 2, 4, 8, 16, ...)
	 * Is the given value a power of two?  (1, 2, 4, 8, 16, ...)
	 */
	public static boolean isPowerOfTwo(int value)
	{
		return value != 0 && ( value & value - 1 ) == 0;
	}
}
