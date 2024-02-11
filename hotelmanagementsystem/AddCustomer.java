 
package hotelmanagementsystem;
 
import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AddCustomer extends JFrame implements ActionListener{
    JComboBox comid;
    JTextField tfnum, tfname, tfcountry, tfdeposit;
    JRadioButton rbmale, rbfemale;
    Choice croom;
    JLabel checkintime;
    JButton add, back;

    public AddCustomer() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Railway", Font.BOLD, 20));
        add(text);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35, 80, 100, 20);
        lblid.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblid);
        
        String str[] = {"Aadhar Card", "Passport", "Driving License", "Voter ID Card", "Rashan Card"};
        comid = new JComboBox(str);
        comid.setBounds(200, 80, 150, 25);
        comid.setBackground(Color.WHITE);
        add(comid);
        
        JLabel lblnum = new JLabel("Number");
        lblnum.setBounds(35, 120, 100, 20);
        lblnum.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblnum);
        
        tfnum = new JTextField();
        tfnum.setBounds(200, 120, 150, 25);
        add(tfnum);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35, 160, 100, 20);
        lblname.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35, 200, 100, 20);
        lblgender.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 200, 60, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 200, 80, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35, 240, 100, 20);
        lblcountry.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 25);
        add(tfcountry);
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(35, 280, 150, 20);
        lblroom.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblroom);
        
        croom = new Choice();
        
        try{
            Conn conn = new Conn();
            String query = "select *from room";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
      
        croom.setBounds(200, 280, 150, 25);
        add(croom);
        
        JLabel lbltime = new JLabel("Checkin Time");
        lbltime.setBounds(35, 320, 150, 20);
        lbltime.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lbltime);
        
        Date date = new Date();
        
        checkintime = new JLabel("" +date);
        checkintime.setBounds(200, 320, 160, 25);
        checkintime.setFont(new Font("Railway", Font.PLAIN, 16));
        add(checkintime);
        
        JLabel lbldepoist = new JLabel("Deposit");
        lbldepoist.setBounds(35, 360, 100, 20);
        lbldepoist.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lbldepoist);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 360, 150, 25);
        add(tfdeposit);
        
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(35, 410, 120, 30);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 410, 120, 30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = (new ImageIcon(System.getProperty("user.dir")+ "\\src\\icons\\fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);
        
        setBounds(350, 100, 800, 550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add){
            String id = (String) comid.getSelectedItem();
            String number = tfnum.getText();
            String name = tfname.getText();
            String gender = null;
            
            if(rbmale.isSelected()){
                gender = "Male";
            }else {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();
            
            try{
                String query = "insert into customer values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+room+"', '"+time+"', '"+deposit+"')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = '"+room+"'";
                Conn conn = new Conn();
                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    
    
    
    public static void main(String[] args) {
        new AddCustomer();
    }
}
