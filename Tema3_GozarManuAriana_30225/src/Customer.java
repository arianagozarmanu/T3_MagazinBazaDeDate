/*
 * Metoda tipprodusPopupMenuWillBecomeInvisible actualizeaza tabelul cu date specifice alese din ComcoBox
 * Metoda UpdateTable afiseaza in tabel toate produsele din magazin
 * Metoda FillCombo umple ComboBox-ul cu date
 * Metoda cumparaActionPerformed care actualizeaza Baza de Date functie de dorinta user-ului de a achizitiona vreun obiect
 */

/**
 *
 * @author Ariana
 */
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Customer extends javax.swing.JFrame {
Connection conn = null;
ResultSet rs = null;
PreparedStatement pst=null;
String date;
String name;
String price;
String stoc;
String userId;
    /**
     * Creates new form Customer
     */
    public Customer() {
        initComponents();
        conn=JavaConnect.ConnectDB();
        UpdateTable();
        FillCombo();
        date=CurrentDate();     
    }
    
    public Customer(String id) {
        initComponents();
        conn=JavaConnect.ConnectDB();
        UpdateTable();
        FillCombo();
        date=CurrentDate(); 
        this.userId=id;
    }

     public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
       public String CurrentDate(){
           Calendar cal=new GregorianCalendar();
           int month=cal.get(Calendar.MONTH);
           month++;
           int year=cal.get(Calendar.YEAR);
           int day=cal.get(Calendar.DAY_OF_MONTH);
           date=""+day+"/"+month+"/"+year;
           jLabel4.setText(date);
           return date;
       }
private void UpdateTable(){
    try {
        String sql="SELECT * FROM Product";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        ProductsTable.setModel(DbUtils.resultSetToTableModel(rs));
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    } finally{
        try{
            rs.close();
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}

private void FillCombo(){
    try{
        String sql="SELECT * FROM Product";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        while(rs.next()){
            String name=rs.getString("tip");
            tipprodus.addItem(name);
        }
    }catch(Exception e){
        System.out.println(e);
    }finally{
        try{
            rs.close();
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ProductsTable = new javax.swing.JTable();
        vezicos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tipprodus = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        idprodus = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cumpara = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cantfield = new javax.swing.JTextField();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(200, 200));

        ProductsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(ProductsTable);

        vezicos.setText("Vezi cosul tau!");
        vezicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vezicosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("PRODUSE:");

        tipprodus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        tipprodus.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                tipprodusPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        tipprodus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipprodusActionPerformed(evt);
            }
        });

        jLabel2.setText("Introduceti ID-ul produsului pe care doriti sa il achizitionati:");

        jLabel3.setText("ID:");

        cumpara.setText("Cumpara");
        cumpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cumparaActionPerformed(evt);
            }
        });

        jLabel5.setText("Cantitate:");

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(vezicos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tipprodus, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cantfield))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idprodus, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(125, 125, 125)
                        .addComponent(cumpara)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tipprodus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(125, 125, 125)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(idprodus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cumpara))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(cantfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addComponent(vezicos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipprodusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipprodusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipprodusActionPerformed

    private void tipprodusPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_tipprodusPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String tmp=(String)tipprodus.getSelectedItem();
        //System.out.println(tmp);
        String sql="SELECT * FROM Product WHERE tip=?";
        try{
           pst=conn.prepareStatement(sql);
           pst.setString(1, tmp);
           rs=pst.executeQuery();
           
           ProductsTable.setModel(DbUtils.resultSetToTableModel(rs));
           
        }catch(Exception e){
            System.out.println(e);
        }finally{
        try{
            rs.close();
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    }//GEN-LAST:event_tipprodusPopupMenuWillBecomeInvisible

    private void cumparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cumparaActionPerformed
        // TODO add your handling code here:
        
        String tmp=idprodus.getText();
      //  System.out.println(tmp);
        String cant=cantfield.getText();
        int bun=0;
        
        for(int i=0;i<tmp.length();i++)
            if(tmp.charAt(i)<'0' || tmp.charAt(i)>'9')
                bun=1;
        
        for(int i=0;i<cant.length();i++)
            if(cant.charAt(i)<'0' || cant.charAt(i)>'9')
                bun=1;
        
        int ok=0;
        
        if(bun==0){
        String sql1="INSERT INTO Cos(productName,price,amount,status,userid) VALUES (?,?,?,?,?)";
        String sql2="SELECT * FROM Product WHERE ID=?";
       
          try{
           pst=conn.prepareStatement(sql2);
           pst.setString(1, tmp);
 
           rs=pst.executeQuery();
           
           while(rs.next()){
               name=rs.getString("productName");
               price=rs.getString("price");
               stoc=rs.getString("stoc");
           }
           
           int amount=Integer.parseInt(stoc);
           int wantam=Integer.parseInt(cant);
           if(wantam>amount){
               JOptionPane.showMessageDialog(null, "Nu exista in magazin cantitatea ceruta");
               OPDept dep;
               dep = new OPDept(name,cant,tmp,userId);
               dep.SearchProd();
           }
           else
               ok=1;
           
        }catch(Exception e){
            System.out.println(e);
        }finally{
        try{
            rs.close();
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
       
    if(ok==1){ 
        try{
           pst=conn.prepareStatement(sql1);
           pst.setString(1, name);
           pst.setString(2, price);
           pst.setString(3, cant);
           pst.setString(4,"No status!");
           pst.setString(5,userId);
           
           pst.executeUpdate();
           
           
        }catch(Exception e){
            System.out.println(e);
        }finally{
        try{
            rs.close();
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
    int cantitate=Integer.parseInt(stoc);
    int cant2=Integer.parseInt(cant);
    cantitate=cantitate-cant2;
    //System.out.println(cantitate);
    String sql3="UPDATE Product set stoc='"+cantitate+"' where ID='"+tmp+"'";
    try{
           pst=conn.prepareStatement(sql3);
           pst.executeUpdate();
    }catch(Exception e){
            System.out.println(e);
     }finally{
        try{
            rs.close();
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
     }
    UpdateTable();
    
    }
     }else{
            JOptionPane.showMessageDialog(null, "Dati un ID sau o cantitate numar intreg pozitiv!");
        }
    }//GEN-LAST:event_cumparaActionPerformed

    private void vezicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vezicosActionPerformed
        // TODO add your handling code here:
        Order o=new Order(userId);
        o.setVisible(true);
    }//GEN-LAST:event_vezicosActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        Login log=new Login();
        log.setVisible(true);
        close();
    }//GEN-LAST:event_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
     java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ProductsTable;
    private javax.swing.JTextField cantfield;
    private javax.swing.JButton cumpara;
    private javax.swing.JTextField idprodus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JComboBox tipprodus;
    private javax.swing.JButton vezicos;
    // End of variables declaration//GEN-END:variables
}
