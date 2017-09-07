import java.awt.BorderLayout;
import java.sql.*;
import java.util.*;
import javax.swing.*;
public class ViewBook extends javax.swing.JFrame {

    Connection con;
    Statement st;
    ResultSet rs;
    String s;
    public ViewBook() {
        initComponents();
        try
        {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            st=con.createStatement();
            s="select * from book";
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
            setDefaultCloseOperation(EXIT_ON_CLOSE);
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

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
         Class.forName("com.mysql.jdbc.Driver");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}