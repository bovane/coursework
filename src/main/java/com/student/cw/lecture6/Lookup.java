package com.student.cw.lecture6;

import java.net.*;								// For InetAddress and UnknownHostException.

public class Lookup {

	private InetAddress inet = null;

	public void resolve(String host) {
		try {
			// Try to create an instance of InetAddress using the factory method (public static).
			// If fails, may throw an instance of UnknownHostException.
			inet = InetAddress.getByName( host );

			// Use two getter methods to print the results. Can also just print the object itself (which combines both).
			System.out.println( "Host name : " + inet.getHostName   () );
			System.out.println( "IP Address: " + inet.getHostAddress() );
		}
		catch( UnknownHostException e ){ 		// If an exception was thrown, echo to stdout.
			e.printStackTrace();
		}
	}

	public static void main( String[] args ) {
		Lookup lookup = new Lookup();
		lookup.resolve( args[0] );				// The first command line argument is args[0].
	}
}


