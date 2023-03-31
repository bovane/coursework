package com.student.cw.ref;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author bovane <bovane.ch@gmail.com>
 * @description
 * @create 2023-03-31 20:14
 */
public class KnockKnockClient {
    private Socket kkSocket = null;
    private PrintWriter socketOutput = null;
    private BufferedReader socketInput = null;
    public void playKnockKnock() {
        try {
            kkSocket = new Socket("localhost",2323); socketOutput = new PrintWriter(
                    kkSocket.getOutputStream(),true);
            socketInput = new BufferedReader(
                    new InputStreamReader(
                            kkSocket.getInputStream()));
        }
        catch( UnknownHostException e ) {

        }
        catch( IOException e ) {

        }
// Continued ...
        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String fromServer; String fromUser;
        try {
            while( (fromServer=socketInput.readLine())!=null ) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye.")) {
                    break;
                }
                fromUser = stdIn.readLine(); if( fromUser!=null ) {
                    System.out.println("Client: " + fromUser);
                    socketOutput.println(fromUser);
                }
            }
// Continued ...
            socketOutput.close(); socketInput.close(); stdIn.close();
            kkSocket.close();
        }
        catch( IOException e ) {
            System.err.println("I/O exception.\n");
            System.exit(1); }
    }
    public static void main(String[] args) {
        KnockKnockClient kkc = new KnockKnockClient();
        kkc.playKnockKnock();
    }
}
