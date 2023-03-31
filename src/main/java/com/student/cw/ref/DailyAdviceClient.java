package com.student.cw.ref;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author bovane <bovane.ch@gmail.com>
 * @description
 * @create 2023-03-31 20:10
 */
public class DailyAdviceClient {
    @SneakyThrows
    public void connect() {
        Socket s = new Socket("localhost",4242);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader( s.getInputStream()));
        String advice = reader.readLine(); System.out.println("Thought for the day: " + advice); reader.close();
        s.close();
    }
    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.connect();
    }

}
