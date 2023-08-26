package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername, tfpassword; /* */
    
    Login() {
        
        getContentPane().setBackground(Color.WHITE);  /*Creating control */
        setLayout(null); /*By Default template not use*/
        
        JLabel lblusername = new JLabel("Username");  /*creating username text field  */
        lblusername.setBounds(40, 20, 100, 30);  /*Creating Our Layout */ 
        add(lblusername);            /*Add username in Frame  */
        
        tfusername = new JTextField();   /* Creating text field for username */
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
        
    /*-------------------------------------------------------------------------------------------------------- */
       
        JLabel lblpassword = new JLabel("Password"); /* creating label for password */
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);
        
        tfpassword = new JTextField();   /*Creating Textfield for Password Field */
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        
    /*-------------------------------------------------------------------------------------------------------- */
        JButton login = new JButton("LOGIN");  /*Creating login button */
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);  /* Button click Task*/
        add(login);
     
    /*-------------------------------------------------------------------------------------------------------- */
     
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {  /* Method Override */
        try {   /*We uses my sql therefore occurs exception*/
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'"; /* values goes in DB or not*/
            
            ResultSet rs = c.s.executeQuery(query); /* call the conn class file| class */
            if (rs.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password"); /* Triggering error*/
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
