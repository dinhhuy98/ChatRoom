/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class ChatClientGUI extends javax.swing.JFrame {
    private ChatClient client;
    private ReadThread readThread;
    private WriteThread writeThread;
    Socket socket;
    /**
     * Creates new form ChatClientGUI
     */
    public ChatClientGUI() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        userTF = new javax.swing.JTextField();
        connectB = new javax.swing.JButton();
        disconnectB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        onlineTA = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageTA = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        inputTA = new javax.swing.JTextArea();
        sendB = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        jTextField2.setText("jTextField2");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userTF.setEditable(false);

        connectB.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        connectB.setText("Connect");
        connectB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectBActionPerformed(evt);
            }
        });

        disconnectB.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        disconnectB.setText("Disconect");
        disconnectB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectBActionPerformed(evt);
            }
        });

        onlineTA.setColumns(20);
        onlineTA.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        onlineTA.setLineWrap(true);
        onlineTA.setRows(5);
        jScrollPane1.setViewportView(onlineTA);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Online");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Username:");

        messageTA.setColumns(20);
        messageTA.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        messageTA.setLineWrap(true);
        messageTA.setRows(5);
        jScrollPane2.setViewportView(messageTA);

        inputTA.setColumns(20);
        inputTA.setRows(5);
        jScrollPane3.setViewportView(inputTA);

        sendB.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        sendB.setText("Send");
        sendB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Chat Room");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sendB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userTF, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(connectB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(disconnectB)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel4)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectB)
                    .addComponent(disconnectB)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sendB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)))
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectBActionPerformed
        // TODO add your handling code here:
        String userName = userTF.getText();
        if(!userName.isEmpty()){
            client = new ChatClient("localhost",1998);
            client.setUserName(userName);
            try {
                socket=client.connect();
                userTF.setEditable(false);
                connectB.setEnabled(false);
                disconnectB.setEnabled(true);
               // messageTA.setText("");
               // onlineTA.setText("");
               // inputTA.setText("");
                sendB.setEnabled(true);
                messageTA.setEditable(false);
                onlineTA.setEditable(false);
                inputTA.setEditable(true);
                readThread = new ReadThread(socket,this,userName);
                readThread.start();
                
                writeThread = new WriteThread(socket, this, userName);
                writeThread.write(userName);
                messageTA.append("Connected to the chat server \n");
            
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Server is not running!",null,JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        else
            JOptionPane.showMessageDialog(null, "Please input username!",null,JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_connectBActionPerformed

    private void sendBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBActionPerformed
        // TODO add your handling code here:
        String mess = inputTA.getText();
        if(mess!=""){
            writeThread.write(mess);
            messageTA.append(mess+"\n");
            inputTA.setText("");
        }
    }//GEN-LAST:event_sendBActionPerformed

    private void disconnectBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectBActionPerformed
        try {
            // TODO add your handling code here:
            socket.close();
            readThread.stop();
            writeThread.stop();
            init();
        } catch (IOException ex) {
            Logger.getLogger(ChatClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_disconnectBActionPerformed

    public JButton getConnectB() {
        return connectB;
    }

    public JButton getDisconnectB() {
        return disconnectB;
    }

    public JTextArea getInputTA() {
        return inputTA;
    }

    public JTextArea getMessageTA() {
        return messageTA;
    }

    public JTextArea getOnlineTA() {
        return onlineTA;
    }

    public JButton getSendB() {
        return sendB;
    }

    public JTextField getUserTF() {
        return userTF;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatClientGUI().setVisible(true);
            }
        });
    }
    public void init(){
        userTF.setEditable(true);
        connectB.setEnabled(true);
        disconnectB.setEnabled(false);
        messageTA.setText("");
        onlineTA.setText("");
        inputTA.setText("");
        sendB.setEnabled(false);
        messageTA.setEditable(false);
        onlineTA.setEditable(false);
        inputTA.setEditable(false);
        
    }
    public void loadOnlineUser(ArrayList<String> arrayUser){
        onlineTA.setText("");
        for(String user: arrayUser){
            onlineTA.append(user+"\n");
        }
}
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectB;
    private javax.swing.JButton disconnectB;
    private javax.swing.JTextArea inputTA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextArea messageTA;
    private javax.swing.JTextArea onlineTA;
    private javax.swing.JButton sendB;
    private javax.swing.JTextField userTF;
    // End of variables declaration//GEN-END:variables
}
