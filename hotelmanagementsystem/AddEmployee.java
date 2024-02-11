package hotelmanagementsystem;
 
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tfname, tfage, tfsalary, tfphone, tfemail, tfadhar;
    JRadioButton rbmale, rbfemale;
    JComboBox cbjob;

    public AddEmployee() {
        setLayout(null);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 30, 150,  30);
        add(tfname);
        
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 80, 150,  30);
        add(tfage);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 130, 120, 30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Thoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 130, 100, 30);
        rbfemale.setFont(new Font("Thoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60, 180, 120, 30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbljob);
        
        String str[] ={"Front Desk Clerk", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress", "Manager", "Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60, 230, 120, 30);
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150,  30);
        add(tfsalary);
        
        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60, 280, 120, 30);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150,  30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(60, 330, 120, 30);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150,  30);
        add(tfemail);
        
        JLabel lbladhar = new JLabel("AADHAR");
        lbladhar.setBounds(60, 380, 120, 30);
        lbladhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbladhar);
        
        tfadhar = new JTextField();
        tfadhar.setBounds(200, 380, 150,  30);
        add(tfadhar);
        
        JButton sumbit = new JButton("SUMBIT");
        sumbit.setBackground(Color.BLACK);
        sumbit.setForeground(Color.WHITE);
        sumbit.setBounds(200, 430, 150, 30);
        sumbit.addActionListener(this);
        add(sumbit);
        
        
        
        ImageIcon i1 = (new ImageIcon(System.getProperty("user.dir")+ "\\src\\icons\\tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(380, 60, 450, 370);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 150, 850, 540);
       // setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String name = tfname.getText();
         String age = tfage.getText();
         String salary = tfsalary.getText();
         String phone = tfphone.getText();
         String email = tfemail.getText();
         String aadhar = tfadhar.getText();
         
         String gender = null;
         
         if(rbmale.isSelected()){
             gender = "Male";
         }else if(rbfemale.isSelected()){
             gender = "Female";
         }
         
         String job =(String) cbjob.getSelectedItem();
         
         try{
             Conn conn = new Conn();
             
             String query = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"')"; 
             
             conn.s.executeUpdate(query);
             
             JOptionPane.showMessageDialog(null, "Employee Added Successfully.");
             setVisible(false);
         }catch(Exception ee){
             ee.printStackTrace();
         }
        
    }
    
    
    
    public static void main(String[] args) {
        new AddEmployee();
    }
    
}
