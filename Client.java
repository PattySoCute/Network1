package Socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            // create a socket to a local host with port # 6789
            Socket s = new Socket("192.168.1.26", 6789);
            
            
            System.out.println("A connection is established and I'll now send a message");

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());

            Scanner in = new Scanner(System.in);

            
            
            //Thread.sleep(5000);
            System.out.println("1st word: ");
            String word_1 = in.nextLine();
            dout.writeUTF(word_1);
            dout.flush();

            System.out.println("2nd word that want to check is: ");
            String word_2 = in.nextLine();
            dout.writeUTF(word_2);
            dout.flush();

            String str = (String) din.readUTF();
            System.out.println("Message received from server: " + str);
            


            dout.close();
            s.close();

        } catch (IOException e) { System.out.println(e); }
    }
}