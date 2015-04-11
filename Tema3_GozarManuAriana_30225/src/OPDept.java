/*
 * Metoda SearchProd cauta un produs in depozit
 */

/**
 *
 * @author Ariana
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class OPDept {
    
Connection conn = null;
ResultSet rs = null;
PreparedStatement pst=null;
String name;
String cant,idp;
String stoc;
String userId;

 public OPDept(String name,String cant,String idp,String userId) {
        conn=JavaConnect.ConnectDB();  
        this.name=name;
        this.cant=cant;
        this.idp=idp;
        this.userId=userId;
 }

 
 public void SearchProd(){
    try{
        String sql="SELECT * FROM Warehouse WHERE productName=? ";
        pst=conn.prepareStatement(sql);
        pst.setString(1, name);
        rs=pst.executeQuery();
       
        
            String id=rs.getString("ID");
            stoc=rs.getString("stoc");
            int stoci=Integer.parseInt(stoc);
            if(stoci>0){
                ExistWin win = new ExistWin(id,cant,idp,userId);
                win.setVisible(true); 
            }
        
        
    }catch(Exception e){
         JOptionPane.showMessageDialog(null, "Produsul nu exista nici in depozit. Ne pare rau!","",0);
    }finally{
        try{
            rs.close();
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
 }
 
 
}
