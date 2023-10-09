package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            Socket socket = new Socket("localhost",3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeBytes("ciao a tutti" + "\n");
            String risp = in.readLine();

            System.out.println("Il server ha risposto: " + risp);
            
            socket.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
