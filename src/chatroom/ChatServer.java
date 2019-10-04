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
              //  connectionArray.add(socket);
              //  AddUserName(socket);
               BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
               DataOutputStream out = new DataOutputStream(socket.getOutputStream());
               DataInputStream in = new DataInputStream(socket.getInputStream());
               String user = in.readUTF();
               currentUsers.add(user);
                System.out.println(user+ "connected");
                
                ClientHandler ch = new ClientHandler(socket,connectionArray,user);
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
     public void notify(String message){
         
     }
}
