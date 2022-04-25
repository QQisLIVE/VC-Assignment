package com.company;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            Socket s = new Socket("localhost", 8080);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // Grabbing input from client side
            System.out.print("\nEnter a Number : ");
            int num = scan.nextInt();
            // Writing int. to server and asking if Prime
            dout.writeInt(num);
            String ans = (String) dis.readUTF();
            System.out.println("\n Is " + num +
                    " A Prime Number?: " + ans);
            dout.flush();
            dout.close();
            s.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        scan.close();
    }
}
