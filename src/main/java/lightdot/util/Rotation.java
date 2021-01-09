package lightdot.util;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public enum Rotation
{
	NONE,
	CLOCKWISE_90,
	CLOCKWISE_180,
	COUNTERCLOCKWISE_90;
	
	public Rotation add( Rotation rotation )
	{
		switch( rotation )
		{
			case CLOCKWISE_180:
				switch( this )
				{
					case NONE:					return CLOCKWISE_180;
					case CLOCKWISE_90: 			return COUNTERCLOCKWISE_90;
					case CLOCKWISE_180:			return NONE;
					case COUNTERCLOCKWISE_90:	return CLOCKWISE_90;
				}
			case COUNTERCLOCKWISE_90:
				switch( this )
				{
					case NONE:					return COUNTERCLOCKWISE_90;
					case CLOCKWISE_90: 			return NONE;
					case CLOCKWISE_180:			return CLOCKWISE_90;
					case COUNTERCLOCKWISE_90:	return CLOCKWISE_180;
				}
			case CLOCKWISE_90:
				switch( this )
				{
					case NONE:					return CLOCKWISE_90;
					case CLOCKWISE_90: 			return CLOCKWISE_180;
					case CLOCKWISE_180:			return COUNTERCLOCKWISE_90;
					case COUNTERCLOCKWISE_90:	return NONE;
				}
			default: return this;
		}
	}
	
	public int rotate( int rotation, int positionCount )
	{
		switch( this )
		{
			case CLOCKWISE_90:			return ( rotation + positionCount / 4 )     % positionCount;
			case CLOCKWISE_180:			return ( rotation + positionCount / 2 )     % positionCount;
			case COUNTERCLOCKWISE_90:	return ( rotation + positionCount * 3 / 4 ) % positionCount;
			default:					return rotation;
		}
	}
	
	public static Rotation randomRotation( Random rand )
	{
		return getRandomObject( values(), rand );
	}
	
	/**
	 * Chooses a random rotation from {@link Rotation}.
	 */
	public static <T> T getRandomObject( T[] selections, Random rand )
	{
		return selections[ rand.nextInt( selections.length ) ];
	}
	
	/**
	 * Generates a shuffled list with all rotations.
	 */
	public static List<Rotation> shuffledRotations( Random rand )
	{
		List<Rotation> list = Lists.newArrayList( values() );
		Collections.shuffle(list, rand);
		return list;
	}
}
