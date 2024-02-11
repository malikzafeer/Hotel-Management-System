 
package hotelmanagementsystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

 
public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton b1;
    CustomerInfo(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(10, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Number");
        l2.setBounds(130, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(270, 10, 100, 20);
        add(l3);
        
         JLabel l4 = new JLabel("Gender");
        l4.setBounds(400, 10, 100, 20);
        add(l4);
        
         JLabel l5 = new JLabel("Country");
        l5.setBounds(520, 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(640, 10, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Checkin Time");
        l7.setBounds(760, 10, 100, 20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(890, 10, 100, 20);
        add(l8);
        
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select *from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(420, 500, 120, 30);
        b1.addActionListener(this);
        add(b1);
        
        setBounds(300, 100, 1000, 600);
        setVisible(true);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
    
    
    
    public static void main(String[] args) {
        new CustomerInfo();
    }
}
