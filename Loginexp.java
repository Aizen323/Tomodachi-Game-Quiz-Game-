package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Loginexp extends JFrame implements ActionListener {

    JButton rules, back;
    JTextField tfname;

    Loginexp() {
        // Frame settings
        setBounds(200, 150, 1100, 500);
        getContentPane().setBackground(new Color(45, 45, 45)); // Dark background
        setLayout(null);

        // Load and resize the custom image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login.jpg")); // Use your actual image path
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH); // Resize to fit 600x500
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 600, 500);
        add(image);
        
        // Title in a dark-themed style
        JLabel heading = new JLabel("Tomodachi Game");
        heading.setBounds(650, 50, 400, 60);
        heading.setFont(new Font("Viper Hand ITC", Font.BOLD, 36));
        heading.setForeground(new Color(200, 200, 200)); // Light gray
        add(heading);
        
        // Label for user to enter name
        JLabel name = new JLabel("Enter your name:");
        name.setBounds(650, 150, 250, 30);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
        name.setForeground(new Color(200, 200, 200)); // Light gray
        add(name);
        
        // Text field for user input
        tfname = new JTextField();
        tfname.setBounds(650, 190, 300, 40);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tfname.setBackground(new Color(70, 70, 70)); // Darker text field
        tfname.setForeground(new Color(255, 255, 255)); // White text
        add(tfname);
        
        // Rules button in dark theme
        rules = new JButton("Rules");
        rules.setBounds(650, 270, 120, 40);
        rules.setBackground(new Color(50, 50, 50)); // Dark background
        rules.setForeground(new Color(255, 69, 0)); // Bright red-orange
        rules.setFont(new Font("Tahoma", Font.BOLD, 18));
        rules.addActionListener(this);
        add(rules);
        
        // Back button in dark theme
        back = new JButton("Back");
        back.setBounds(830, 270, 120, 40);
        back.setBackground(new Color(50, 50, 50)); // Dark background
        back.setForeground(new Color(255, 255, 255)); // White text
        back.setFont(new Font("Tahoma", Font.BOLD, 18));
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rulesexp(name); // Assuming Rulesexp class exists
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Loginexp();
    }
}
