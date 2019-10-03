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
    public ArrayList<Socket> connectionArray = new ArrayList<Socket>();
    public ArrayList<String> currentUsers = new ArrayList<String>();
    
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
                connectionArray.add(socket);
                AddUserName(socket);
                new ServerThread(socket,connectionArray).start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void AddUserName(Socket socket) throws IOException{
        Scanner input = new Scanner(socket.getInputStream());
        String userName= input.nextLine();
        currentUsers.add(userName);
        for(int i=0; i<connectionArray.size();i++){
            Socket tempSocket = (Socket)connectionArray.get(i);
            PrintWriter out= new PrintWriter(tempSocket.getOutputStream());
            out.println("#?!" + currentUsers);
            out.flush();
        }
    }
     public void checkConnection(Socket socket) throws IOException{
        if(socket.isConnected()){
            for(int i=0; i<connectionArray.size();i++){
                if(connectionArray.get(i)==socket)
                    connectionArray.remove(i);
            }
            for(int i=0; i<connectionArray.size();i++){
                Socket tempSocket = (Socket)connectionArray.get(i);
                PrintWriter  out = new PrintWriter(tempSocket.getOutputStream());
                out.println(tempSocket.getLocalAddress().getHostName()+"disconnected!");
                out.flush();
                System.out.println(tempSocket.getLocalAddress().getHostName()+"disconnected!");
                
            }
        }
        
     }
}
