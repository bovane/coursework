package com.student.cw.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author bovane <bovane.ch@gmail.com>
 * @description
 * @create 2023-03-31 20:21
 */
public class DailyAdviceServer {
    String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do NOT make you look fat",
            "One word: inappropriate", "Just for today, be honest.  Tell your boss what you *really* think",
            "You might want to rethink that haircut"};

    public void go() {
        try {
            ServerSocket serverSock = new ServerSocket(4242);
            while( true ) {
                Socket sock = serverSock.accept(); InetAddress inet = sock.getInetAddress();  // Log date and client address.
// Protocol: Send a line of text.
                PrintWriter writer = new PrintWriter( sock.getOutputStream());
                String advice = getAdvice(); writer.println(advice); // To client writer.close();
                System.out.println(advice); // Local server echo sock.close();
            }
        } catch (IOException ex) {

        }
    }
    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }
}
