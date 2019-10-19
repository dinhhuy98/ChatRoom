/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;
import java.util.ArrayList;
import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class ChatServer {
    public ArrayList<ClientHandler> connectionArray = new ArrayList<ClientHandler>();
    public ArrayList<String> userArray = new ArrayList<String>();
   
    
    public static void main(String[] args) {
        new ChatServer().start();
    }
    
    public void start() {
        try{
            final int port = 1998;
            ServerSocket server = new ServerSocket(port);
            System.out.println("Waitting for client...");
            while(true){
                Socket socket = server.accept();
               DataInputStream in = new DataInputStream(socket.getInputStream());
               String user = in.readUTF();
                System.out.println(user+ "connected");
                userArray.add(user);
                ClientHandler ch = new ClientHandler(socket,connectionArray,user,userArray);
                connectionArray.add(ch);
                new Thread(ch).start();
                /*
               new Thread(()->{
                        try{
                            while(true){
                            String mess = reader.readLine();
                            out.writeUTF(mess);
                            }
                        }catch(IOException e){
                            e.printStackTrace();
                   
                    } 
                }).start();
               
                new Thread(()->{
                    
                        try{
                            while(true){
                            String respone = in.readUTF();
                            
                            System.out.println("[Client]: "+respone);
                            }
                        }catch(IOException e){
                            e.printStackTrace();
                                }
                    
                }).start();
                
                */
            }
        }catch(IOException e){
            System.out.println("1");
            e.printStackTrace();
        }
    }
  
}
