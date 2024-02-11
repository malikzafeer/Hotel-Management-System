package hotelmanagementsystem;
 
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back, submit;
     Choice typeofcar;

    public Pickup() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(430, 30, 200, 30);
        add(text);
        
        JLabel lblbed = new JLabel("Type of Car");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150, 100, 200, 25);
        add(typeofcar);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from driver ");
            while(rs.next()){
                typeofcar.add(rs.getString("brand"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(10, 160, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(160, 160, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(310, 160, 100, 20);
        add(l3);
        
         JLabel l4 = new JLabel("Company");
        l4.setBounds(460, 160, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Type of Car");
        l5.setBounds(610, 160, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(740, 160, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Location");
        l7.setBounds(880, 160, 100, 20);
        add(l7);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select *from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300, 520, 120, 30);
        submit.addActionListener(this);
        add(submit);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500, 520, 120, 30);
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 100, 1000, 600);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == submit){
            try{
                String query = "select *from driver where brand = '"+typeofcar.getSelectedItem()+"'";
               
                
                Conn conn = new Conn();
                ResultSet rs;
                 
                rs = conn.s.executeQuery(query);
               
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
        setVisible(false);
        new Reception();
        }
        
    }
    
    
    
    public static void main(String[] args) {
        new Pickup();
    }
}
