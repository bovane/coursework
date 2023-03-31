package com.student.cw.lecture13;

import javax.net.ssl.*;

public class ListCipherSuites
{
	public static void main( String args[] )
	{
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		for( String suite : factory.getSupportedCipherSuites() ) {
			System.out.println( suite );
		}
	}
}