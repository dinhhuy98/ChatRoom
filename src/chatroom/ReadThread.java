/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
class ReadThread extends Thread{
    private DataInputStream in;
    private Socket socket;
    private String userName;
    private ObjectInputStream inObject;
    private ChatClientGUI clientGUI;
    ArrayList<String> userArray;
    
    public ReadThread(Socket socket, ChatClientGUI clientGUI, String userName) {
        this.socket=socket;
        this.clientGUI=clientGUI;
        try{
            in = new DataInputStream(socket.getInputStream());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void run(){
            try{
                inObject = new ObjectInputStream(socket.getInputStream());
                try {
                    userArray =(ArrayList) inObject.readObject();
                    
                    clientGUI.loadOnlineUser(userArray);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ReadThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                while(true){
                    //clientGUI.getMessageTA().append("kkk");
                    String respone = in.readUTF();
                   
                  if(respone.matches("\\[server\\]:\\[(.+){1,}\\]: connected")){
                         Pattern pattern = Pattern.compile("[^server]\\[(.+?)\\]");
                         
                        Matcher matcher = pattern.matcher(respone);
                        if (matcher.find())
                            {
                                userArray.add(matcher.group(1));
                                clientGUI.loadOnlineUser(userArray);
                            }
                  }
                  else if(respone.matches("\\[server\\]:\\[(.+){1,}\\]: is disconnected")){
                      Pattern pattern = Pattern.compile("[^server]\\[(.+?)\\]");
                         
                        Matcher matcher = pattern.matcher(respone);
                        if (matcher.find())
                            {
                                userArray.remove(matcher.group(1));
                                clientGUI.loadOnlineUser(userArray);
                            }
                  }
                    if(respone!=null && respone!="#?connection?"){
                        System.out.println(respone);
                        clientGUI.getMessageTA().append(respone+"\n");
                        
                    }
                 
                }
            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "The username is already in use!",null,JOptionPane.ERROR_MESSAGE);
                clientGUI.init();
                e.printStackTrace();
            }
        
    }
    
}
