 package hotelmanagementsystem;
 
 
import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HotelManagementSystem extends JFrame implements ActionListener {

    public HotelManagementSystem()   {
        setTitle("Hotel Management System");
        setSize(1366, 565);
        setLocation(0, 100);
        setLayout(null);
        setResizable(false);
        
        ImageIcon i1 = (new ImageIcon(System.getProperty("user.dir")+ "\\src\\icons\\first.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1366, 565, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(0, 0, 1366, 565);
        add(image);
        
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 1100, 50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 100, 30);
        next.setBackground(Color.white);
        next.setForeground(Color.magenta);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        next.addActionListener(this);
        image.add(next);
         
        setVisible(true);
        
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
             try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }

   
    public static void main(String[] args) {
         new HotelManagementSystem();
    }
}
