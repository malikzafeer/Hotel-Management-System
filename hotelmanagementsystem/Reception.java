

package hotelmanagementsystem;
 
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener {
    JButton newc, rooms, dep, allemp, custinfo, maninfo, checkout, upstatus, roomstatus, picser, serroom, logout;

    public Reception()  {
        getContentPane().setBackground(Color.WHITE);
        setLayout( null);
        
        newc = new JButton("New Customer Form");
        newc.setBounds(10, 30, 200, 30);
        newc.setBackground(Color.BLACK);
        newc.setForeground(Color.WHITE);
        newc.addActionListener(this);
        add(newc);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        dep = new JButton("Department");
        dep.setBounds(10, 110, 200, 30);
        dep.setBackground(Color.BLACK);
        dep.setForeground(Color.WHITE);
        dep.addActionListener(this);
        add(dep);
        
        allemp = new JButton("All Employee");
        allemp.setBounds(10, 150, 200, 30);
        allemp.setBackground(Color.BLACK);
        allemp.setForeground(Color.WHITE);
        allemp.addActionListener(this);
        add(allemp);
        
        custinfo = new JButton("Customer Info");
        custinfo.setBounds(10, 190, 200, 30);
        custinfo.setBackground(Color.BLACK);
        custinfo.setForeground(Color.WHITE);
        custinfo.addActionListener(this);
        add(custinfo);
        
        maninfo = new JButton("Manager Info");
        maninfo.setBounds(10, 230, 200, 30);
        maninfo.setBackground(Color.BLACK);
        maninfo.setForeground(Color.WHITE);
        maninfo.addActionListener(this);
        add(maninfo);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        upstatus = new JButton("Update Status");
        upstatus.setBounds(10, 310, 200, 30);
        upstatus.setBackground(Color.BLACK);
        upstatus.setForeground(Color.WHITE);
        upstatus.addActionListener(this);
        add(upstatus);
        
        roomstatus = new JButton("Update Room Status");
        roomstatus.setBounds(10, 350, 200, 30);
        roomstatus.setBackground(Color.BLACK);
        roomstatus.setForeground(Color.WHITE);
        roomstatus.addActionListener(this);
        add(roomstatus);
        
        picser = new JButton("Pickup Service");
        picser.setBounds(10, 390, 200, 30);
        picser.setBackground(Color.BLACK);
        picser.setForeground(Color.WHITE);
        picser.addActionListener(this);
        add(picser);
        
        serroom = new JButton("Search Room");
        serroom.setBounds(10, 430, 200, 30);
        serroom.setBackground(Color.BLACK);
        serroom.setForeground(Color.WHITE);
        serroom.addActionListener(this);
        add(serroom);
        
        logout = new JButton("Logout");
        logout.setBounds(10, 470, 200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = (new ImageIcon(System.getProperty("user.dir")+ "\\src\\icons\\fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);
        add(image);
        
        setBounds(350, 100, 800, 570);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == newc){
           setVisible(false);
           new AddCustomer();
       }
       else if(ae.getSource() == rooms){
           setVisible(false);
           new Room();
       }
       else if(ae.getSource() == dep){
           setVisible(false);
           new Department();
       }
       else if(ae.getSource() == allemp){
           setVisible(false);
           new EmployeeInfo();
       }
       else if(ae.getSource() == maninfo){
           setVisible(false);
           new ManagerInfo();
       }
       else if(ae.getSource() == custinfo){
           setVisible(false);
           new CustomerInfo();
       }
       else if(ae.getSource() == serroom){
           setVisible(false);
           new SearchRoom();
       }
       else if(ae.getSource() == upstatus){
           setVisible(false);
           new UpdateCheck();
       }
       else if(ae.getSource() == roomstatus){
           setVisible(false);
           new UpdateRoom();
       }
       else if(ae.getSource() == picser){
           setVisible(false);
           new Pickup();
       }
       else if(ae.getSource() == checkout){
           setVisible(false);
           new Checkout();
       }
       else if(ae.getSource() == logout){
           setVisible(false);
           System.exit(0);
       }
    }
    
    
    
    public static void main(String[] args) {
        new Reception();
    }
}
