package it.group3.groupchat.gui;


import it.group3.groupchat.implementation.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Gjergjaj Albert
 */
public class MainGuiChat extends javax.swing.JFrame {
    
    public static ArrayList<UserToUserPanel> chatPrivate = new ArrayList();

    public clientPackets cp;
    public MainGuiChat() {
        initComponents();
    }

    public MainGuiChat(String alias, clientPackets cp) throws IOException 
    {
        initComponents();
        jLabel2.setText(alias);
        setPacketInteraction(cp);
        this.addWindowListener(new WindowListener() {
            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosing(WindowEvent e) { 
                //TODO chiudere thread quando la finestra sta per chiudersi. + socket
            }
            @Override public void windowClosed(WindowEvent e) {}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {}
        });
    }

    public void setPacketInteraction(clientPackets clientP){
        this.cp = clientP;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        msgText = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        inviaButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        aliasText = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        richiediUtenti = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 204));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTabbedPane1MousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        outputArea.setColumns(20);
        outputArea.setRows(5);
        outputArea.setEnabled(false);
        jScrollPane1.setViewportView(outputArea);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        inviaButton.setText("INVIA");
        inviaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inviaButtonActionPerformed(evt);
            }
        });
        jPanel4.add(inviaButton);

        jList1.setBackground(new java.awt.Color(255, 255, 204));
        jList1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1) Private" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USERS");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        aliasText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        aliasText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        richiediUtenti.setText("Richiedi lista utenti");
        richiediUtenti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                richiediUtentiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(msgText, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(richiediUtenti, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aliasText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(53, 53, 53))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(msgText)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(aliasText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(richiediUtenti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("GENERAL ROOM", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void inviaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inviaButtonActionPerformed
            if(msgText.getText().equals("")){}
            else{
                try {
                    cp.sendMsgToChat(msgText.getText().trim());
                } catch (IOException ex) {
                    Logger.getLogger(MainGuiChat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_inviaButtonActionPerformed

    
    private void usersListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersListMouseClicked
        int[] indices = jList1.getSelectedIndices();

        if (evt.getClickCount() == 2) {
                chatPrivate.add(new UserToUserPanel(jList1.getSelectedValue(),this.cp));
            for (int i = 0; i < indices.length; i++) {
                jTabbedPane1.add(jList1.getSelectedValue(), chatPrivate.get(chatPrivate.size()-1));
            }
        }
    }//GEN-LAST:event_usersListMouseClicked

    private void jTabbedPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MousePressed
        if (evt.getClickCount() == 2) {
            if (jTabbedPane1.getSelectedIndex() == 0) {

            } else {
                jTabbedPane1.remove(jTabbedPane1.getSelectedIndex());
                chatPrivate.remove(jTabbedPane1.getSelectedIndex());
            }

        }
    }//GEN-LAST:event_jTabbedPane1MousePressed

    private void richiediUtentiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_richiediUtentiActionPerformed

            try {
                cp.requireUserList();
            } catch (IOException ex) {
                Logger.getLogger(MainGuiChat.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_richiediUtentiActionPerformed
    
    public static ArrayList<UserToUserPanel> getChatPrivate() {
        return chatPrivate;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aliasText;
    private javax.swing.JButton inviaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField msgText;
    public static javax.swing.JTextArea outputArea;
    private javax.swing.JButton richiediUtenti;
    // End of variables declaration//GEN-END:variables
}
