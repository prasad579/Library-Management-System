/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.awt.BorderLayout;
import java.sql.*;
import java.util.*;
import javax.swing.*;
public class ViewLibrarian extends javax.swing.JFrame {

    Connection con;
    Statement st;
    ResultSet rs;
    String s;
    public ViewLibrarian() {
        initComponents();
        try
        {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            st=con.createStatement();
            s="select * from librarian";
            rs=st.executeQuery(s);
            ResultSetMetaData rsmt=rs.getMetaData();
            int c=rsmt.getColumnCount();
            Vector column=new Vector();
            for(int i=1;i<=c;i++)
                column.add(rsmt.getColumnName(i));
            Vector data=new Vector();
            Vector row=new Vector();
            while(rs.next())
            {
                row=new Vector(c);
                for(int i=1;i<=c;i++)
                    row.add(rs.getString(i));
                data.add(row);
            }
            //
           setSize(500,120);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel=new JPanel();
            JTable table=new JTable(data,column);
            JScrollPane jsp=new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            setContentPane(panel);
            setVisible(true);
        }
         
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        Class.forName("com.mysql.jdbc.Driver"); 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLibrarian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
