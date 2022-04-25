package com.company;
import java.io.*;
import java.net.*;
public class Server {
    public static String isPrime(int num) {
        if(num<2) {
            return "Server: No";
        }
        int i=2;
        while(i<num) {
            if(num%i==0) {
                return "Server: No";
            }
            i++;
        }
        return "Server: Yes";
    }
    public static void main(String[] args){
        try{
            ServerSocket ss=new ServerSocket(8080);
            //establishes connection notification
            Socket s=ss.accept();
            DataInputStream dis=new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());

            int num = (int)dis.readInt();
            // calling the function
            // returning the answer to the client
            dout.writeUTF(isPrime(num));
            dout.flush();

            dout.close();
            ss.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
