 
package hotelmanagementsystem;
 
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Checkout extends JFrame implements ActionListener {
    
    Choice ccust;
    JLabel lblrn, lblcheckin, lblcheckout;
    JButton checkout, back;

    public Checkout() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(100, 20, 100, 30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 30);
        add(lblid);
        
        ccust = new Choice();
        ccust.setBounds(150, 80, 150, 25);
        add(ccust);
        
        
        
        ImageIcon i1 = (new ImageIcon(System.getProperty("user.dir")+ "\\src\\icons\\tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310, 80, 20, 20);
        add(image);
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 30);
        add(lblroom);
        
        lblrn = new JLabel();
        lblrn.setBounds(150, 130, 150, 30);
        add(lblrn);
        
        JLabel lblcheckintime = new JLabel("Checkin Time");
        lblcheckintime.setBounds(30, 180, 100, 30);
        add(lblcheckintime);
        
        lblcheckin = new JLabel();
        lblcheckin.setBounds(150, 180, 150, 30);
        add(lblcheckin);
        
        JLabel lblcheckouttime = new JLabel("Checkout Time");
        lblcheckouttime.setBounds(30, 230, 100, 30);
        add(lblcheckouttime);
        
        Date date = new Date();
        lblcheckout = new JLabel("" +date);
        lblcheckout.setBounds(150, 230, 150, 30);
        add(lblcheckout);
        
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30, 280, 120, 30);
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170, 280, 120, 30);
        back.addActionListener(this);
        add(back);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select *from customer");
            while(rs.next()){
                ccust.add(rs.getString("number"));
                lblrn.setText(rs.getString("room"));
                lblcheckin.setText(rs.getString("checkintime"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        ImageIcon i = (new ImageIcon(System.getProperty("user.dir")+ "\\src\\icons\\sixth.jpg"));
        Image i5 = i.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(350, 50, 400, 250);
        add(image1);
        
        setBounds(300, 100, 800, 400);
        setVisible(true);
    }
     
    @Override
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource() == checkout){
             String query1 = "delete from customer where number = '"+ccust.getSelectedItem()+"'";
             String query2 = "update room set availability = 'Available' where roomnumber = '"+lblrn.getName()+"'";
             
             Conn c = new Conn();
             try{
                 c.s.executeUpdate(query1);
                 c.s.executeUpdate(query2);
                 
                 JOptionPane.showMessageDialog(null, "Checkout Done");
                 setVisible(false);
             }catch(Exception e){
                 e.printStackTrace();
             }
         }
         else{
             setVisible(false);
             new Reception();
         }
    }
    
    public static void main(String[] args) {
        new Checkout();
    }
}
