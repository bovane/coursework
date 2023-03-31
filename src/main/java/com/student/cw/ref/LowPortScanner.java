package com.student.cw.ref;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author bovane <bovane.ch@gmail.com>
 * @description
 * @create 2023-03-31 19:58
 */
public class LowPortScanner {
    @SneakyThrows
    public static void main( String[] args ) {
        String hostname = "localhost";
        if( args.length > 0 ) {
            hostname = args[0];
        }
    // Try every preserved port number.
        for( int i = 1; i < 1024; i++ ) {
            Socket s = new Socket(hostname, i);
            System.out.println("There is a server on port " + i + " of " + hostname);
        }
    }
}
