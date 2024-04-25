/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandemieprojet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

/**
 *
 * @author asus
 */
public class SuivieWorld extends javax.swing.JFrame {
DefaultTableModel modelo;
    /**
     * Creates new form SuivieWorld
     */
    public SuivieWorld() throws ClassNotFoundException, SQLException {
        initComponents();
        showDate();
        showTime();
        showwcase();
        showDeath();
        showREC();
        showTabledata();
    }
    void showTabledata() throws ClassNotFoundException, SQLException{
    
    connection con;
       String [] t2={"pays","cas","deces","retabli"};
       
            String [] t=new String[4];
            modelo =new DefaultTableModel(null,t2); 
            
            
            con = new connection();
            Statement cmd = con.c.createStatement();
             ResultSet res = cmd.executeQuery("SELECT nomP ,SUM(nbC),SUM(nbDT),SUM(nbREC) FROM worldcases GROUP BY nomP;");
             while(res.next()){ t[0]= res.getString("nomP");
             t[1]= res.getString("SUM(nbC)");
             t[2]= res.getString("SUM(nbDT)");
             t[3]= res.getString("SUM(nbREC)");
             modelo.addRow(t);}
             tworld.setModel(modelo);
    }
void showwcase() throws ClassNotFoundException, SQLException{
     connection con;
       
            con = new connection();
            Statement cmd = con.c.createStatement();
             ResultSet res = cmd.executeQuery("SELECT SUM(nbC) FROM worldcases ;");
             /*int columnCount = res.getMetaData().getColumnCount();
 System.out.println("column count : "+columnCount);*/
            
              while(res.next())
        {       String count = res.getString("SUM(nbC)");
           
        wcase.setText(count);}
              
          
             
             con.c.close();
}
void showDeath() throws ClassNotFoundException, SQLException{
     connection con;
       
            con = new connection();
            Statement cmd = con.c.createStatement();
             ResultSet res = cmd.executeQuery("SELECT SUM(nbDT) FROM worldcases ;");
             /*int columnCount = res.getMetaData().getColumnCount();
 System.out.println("column count : "+columnCount);*/
            
              while(res.next())
        {       String count = res.getString("SUM(nbDT)");
           
        wdeces.setText(count);}
              
          
             
             con.c.close();
}
void showREC() throws ClassNotFoundException, SQLException{
     connection con;
       
            con = new connection();
            Statement cmd = con.c.createStatement();
             ResultSet res = cmd.executeQuery("SELECT SUM(nbREC) FROM worldcases ;");
             /*int columnCount = res.getMetaData().getColumnCount();
 System.out.println("column count : "+columnCount);*/
            
              while(res.next())
        {       String count = res.getString("SUM(nbREC)");
           
        wretab.setText(count);}
              
          
             
             con.c.close();
}
void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-YYYY");
        date.setText(s.format(d));
    }

 void showTime() {
        new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
        time.setText(s.format(d));
            }

        }
        ).start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        wrech = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        wdate = new javax.swing.JTextField();
        pays = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        wcase = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        wdeces = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        wretab = new javax.swing.JLabel();
        wstat = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tworld = new javax.swing.JTable();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        wrech.setText("Rechercher");
        wrech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wrechActionPerformed(evt);
            }
        });

        jLabel1.setText("Date:");

        pays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paysActionPerformed(evt);
            }
        });

        jLabel2.setText("Pays:");

        jLabel4.setText("oblig*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(wdate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(pays, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(wrech)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(wdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(wrech))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(20, 20, 20))
        );

        jButton2.setText("Retour");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel3.setText("Total cas positives : ");

        wcase.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel5.setText("Total décès:");

        wdeces.setText("jLabel6");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel7.setText("Total cas retablis :");

        wretab.setText("jLabel8");

        wstat.setText("Statistiques");
        wstat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wstatActionPerformed(evt);
            }
        });

        date.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        date.setForeground(new java.awt.Color(153, 153, 255));
        date.setText("jLabel9");

        time.setBackground(new java.awt.Color(153, 153, 255));
        time.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        time.setForeground(new java.awt.Color(153, 153, 255));
        time.setText("jLabel10");

        jButton1.setText("voir details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tworld.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Pays", "cas", "Déces", "Retabli"
            }
        ));
        jScrollPane3.setViewportView(tworld);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(wstat))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wcase)
                                    .addComponent(wdeces))
                                .addGap(69, 69, 69))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(wretab)
                                .addGap(71, 71, 71))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(31, 31, 31))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(wcase)
                                .addGap(65, 65, 65))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(31, 31, 31)))
                        .addComponent(wdeces))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(wretab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(wstat)
                    .addComponent(time)
                    .addComponent(date)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paysActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
accueil ac =new accueil();
        ac.setVisible(true);
        this.hide();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void wstatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wstatActionPerformed
wsatat ac =new wsatat();
        ac.setVisible(true);
        this.hide();        // TODO add your handling code here:
    }//GEN-LAST:event_wstatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:connection con;
      connection con = null;
       String [] t2={"pays","cas","deces","retabli"};
       
            String [] t=new String[4];
            modelo =new DefaultTableModel(null,t2); 
            
            
    try {
        con = new connection();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(SuivieWorld.class.getName()).log(Level.SEVERE, null, ex);
    }
            Statement cmd = null;
    try {
        cmd = con.c.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(SuivieWorld.class.getName()).log(Level.SEVERE, null, ex);
    }
             ResultSet res = null;
    try {
        res = cmd.executeQuery("SELECT nomP ,SUM(nbC),SUM(nbDT),SUM(nbREC) FROM worldcases GROUP BY nomP;");
    } catch (SQLException ex) {
        Logger.getLogger(SuivieWorld.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        while(res.next()){ t[0]= res.getString("nomP");
        t[1]= res.getString("SUM(nbC)");
        t[2]= res.getString("SUM(nbDT)");
        t[3]= res.getString("SUM(nbREC)");
        modelo.addRow(t);}
    } catch (SQLException ex) {
        Logger.getLogger(SuivieWorld.class.getName()).log(Level.SEVERE, null, ex);
    }
             tworld.setModel(modelo);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void wrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wrechActionPerformed
        // TODO add your handling code here:connection con;
       connection con = null ;
        String [] t2={"pays","cas","deces","retabli"};
       
            String [] t=new String[4];
            modelo =new DefaultTableModel(null,t2); 
            String p=toUpperCase(pays.getText());
            System.out.print(p);
            String d=wdate.getText();
            System.out.print(d);
            
    try {
        con = new connection();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(SuivieWorld.class.getName()).log(Level.SEVERE, null, ex);
    }
            Statement cmd = null;
    try {
        cmd = con.c.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(SuivieWorld.class.getName()).log(Level.SEVERE, null, ex);
    }
             ResultSet res = null;
    try {
        if(p.equals("")) {
            
        res = cmd.executeQuery("SELECT nomP,nbC,nbDT,nbREC FROM worldcases where datecase='"+d+"' ;");}
        else {
                res = cmd.executeQuery("SELECT nomP,nbC,nbDT,nbREC FROM worldcases where nomP='"+p+"' and datecase='"+d+"' ;");}
    } catch (SQLException ex) {
        Logger.getLogger(SuivieWorld.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        while(res.next()){ t[0]= res.getString("nomP");
        t[1]= res.getString("nbC");
        t[2]= res.getString("nbDT");
        t[3]= res.getString("nbREC");
        modelo.addRow(t);}
    } catch (SQLException ex) {
        Logger.getLogger(SuivieWorld.class.getName()).log(Level.SEVERE, null, ex);
    }
             tworld.setModel(modelo);
             pays.setText("");
             wdate.setText("");
        
    }//GEN-LAST:event_wrechActionPerformed

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
            java.util.logging.Logger.getLogger(SuivieWorld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuivieWorld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuivieWorld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuivieWorld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SuivieWorld().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SuivieWorld.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(SuivieWorld.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField pays;
    private javax.swing.JLabel time;
    private javax.swing.JTable tworld;
    private javax.swing.JLabel wcase;
    private javax.swing.JTextField wdate;
    private javax.swing.JLabel wdeces;
    private javax.swing.JButton wrech;
    private javax.swing.JLabel wretab;
    private javax.swing.JButton wstat;
    // End of variables declaration//GEN-END:variables
}