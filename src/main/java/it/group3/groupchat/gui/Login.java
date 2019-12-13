package it.group3.groupchat.gui;

import PCP.services.PCPServer;
import it.group3.groupchat.*;
import it.group3.groupchat.implementation.clientPackets;
import it.group3.groupchat.implementation.packetListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Drogheh
 */
class lThread extends Thread{

    private clientPackets cp;
    public lThread(clientPackets clientS)
    {
        cp = clientS;
    }
    
    @Override
    public void run(){
        packetListener pl = new packetListener();
        
        try {
            pl.listening(cp);
        } catch (IOException ex) {
            Logger.getLogger(lThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

public class Login extends javax.swing.JFrame 
{
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        aliasField = new javax.swing.JTextField();
        topicField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        inviaButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Group 5 Client");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        aliasField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        aliasField.setText("Alias");
        aliasField.setToolTipText("Inserisci alias");
        aliasField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                aliasFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                aliasFieldFocusLost(evt);
            }
        });

        topicField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        topicField.setText("Topic");
        topicField.setToolTipText("Inserisci Topic");
        topicField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                topicFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                topicFieldFocusLost(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("ESCI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        inviaButton.setBackground(new java.awt.Color(255, 204, 204));
        inviaButton.setText("INVIA");
        inviaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inviaButtonActionPerformed(evt);
            }
        });
        jPanel3.add(inviaButton);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LOGIN");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Group 5 Chat");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(aliasField)
                    .addComponent(topicField, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aliasField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(topicField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        aliasField.getAccessibleContext().setAccessibleName("Alias");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void aliasFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aliasFieldFocusGained
        if (aliasField.getText().equals("Alias")) {
            aliasField.setText("");
        }
    }//GEN-LAST:event_aliasFieldFocusGained

    private void aliasFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aliasFieldFocusLost
        if (aliasField.getText().equals("")) {
            aliasField.setText("Alias");
        }
    }//GEN-LAST:event_aliasFieldFocusLost

    private void topicFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_topicFieldFocusGained
        if (topicField.getText().equals("Topic")) {
            topicField.setText("");
        }
    }//GEN-LAST:event_topicFieldFocusGained

    private void topicFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_topicFieldFocusLost
        if (topicField.getText().equals("")) {
            topicField.setText("Topic");
        }
    }//GEN-LAST:event_topicFieldFocusLost

    private void inviaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inviaButtonActionPerformed
        String alias = aliasField.getText();
        String topic = topicField.getText();
        
        this.dispose();
        try {
            startConnection(alias,topic);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_inviaButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void startConnection(String alias, String topic) throws IOException, InterruptedException
    {
        Socket clientSocket = new Socket("95.249.16.150", 53101);
        clientPackets cp = new clientPackets(clientSocket);
        
        Thread listener = new lThread(cp);
        listener.start();
        
        cp.registration(alias, topic);
        
        try {
            new MainGuiChat(alias,cp).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String args[]) throws IOException {
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aliasField;
    private javax.swing.JButton inviaButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField topicField;
    // End of variables declaration//GEN-END:variables
}
