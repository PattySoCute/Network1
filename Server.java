package Socket;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        try {

            // create a socket at port # 6789
            ServerSocket ss = new ServerSocket(6789);  // create a socket
            System.out.println("A socket is created and now waiting for connection.");

            // establish and wait for an incoming connection
            Socket s = ss.accept();
            System.out.println("A client has made a connection in.");

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // wait for input message and display it
            int cnt = 0, flag = 0, i, cnt_w2 = 0;
            System.out.println("Waiting for an incoming message...");

            String str = (String) din.readUTF();
            String str2 = (String) din.readUTF();
            System.out.println("Message received: " + "1." + str + " 2." +str2);
            
            for(i=0;i<str2.length();i++){
                cnt_w2++;
            }

            for(i=0;i<str.length();i++){
                if(str.charAt(i) == str2.charAt(cnt)){
                    cnt++;
                    if(cnt == cnt_w2){
                        dout.writeUTF("There is kangaroo word");
                        dout.flush();
                        flag = 1;
                    }
                }
            }

            if(flag == 0){
                dout.writeUTF("There isn't kangaroo word");
                dout.flush();
            }

            ss.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
