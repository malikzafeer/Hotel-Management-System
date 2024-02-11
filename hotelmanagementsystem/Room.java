 
package hotelmanagementsystem;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.ResultSet;
import javax.swing.JButton;
import net.proteanit.sql.*;

 
public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton b1;

    public Room() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = (new ImageIcon(System.getProperty("user.dir")+ "\\src\\icons\\eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(10, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(120, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(230, 10, 100, 20);
        add(l3);
        
         JLabel l4 = new JLabel("Price");
        l4.setBounds(340, 10, 100, 20);
        add(l4);
        
         JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(430, 10, 100, 20);
        add(l5);
        
        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select *from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(200, 500, 120, 30);
        b1.addActionListener(this);
        add(b1);
        
        setBounds(300, 100, 1050, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }
    
    
    public static void main(String[] args) {
        new Room();
    }
}
