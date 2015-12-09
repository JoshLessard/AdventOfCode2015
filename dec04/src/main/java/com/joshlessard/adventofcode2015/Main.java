package com.joshlessard.adventofcode2015;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

	private static final BigInteger THRESHOLD_5_ZEROES = new BigInteger( "00001000000000000000000000000000", 16 );
	private static final BigInteger THRESHOLD_6_ZEROES = new BigInteger( "00000100000000000000000000000000", 16 );
	
	public static void main( String[] args ) throws NoSuchAlgorithmException {
		System.out.println( "Part A: " + getIteration( args[0], THRESHOLD_5_ZEROES ) );
		System.out.println( "Part B: " + getIteration( args[0], THRESHOLD_6_ZEROES ) );
	}

	private static int getIteration( String prefix, BigInteger threshold ) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance( "MD5" );
		for ( int i = 1; ; ++i ) {
			byte[] digest = messageDigest.digest( (prefix + i).getBytes() );
			if ( new BigInteger( 1, digest ).compareTo( threshold ) < 0 ) {
				return i;
			}
		}
	}
}
