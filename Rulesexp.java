package quiz.application;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rulesexp extends JFrame implements ActionListener {
    
    String name;
    JButton start, back;
    
    Rulesexp(String name) {
        this.name = name;
        getContentPane().setBackground(new Color(45, 45, 45)); // Dark background
        setLayout(null);
        
        // Heading with updated color
        JLabel heading = new JLabel("Welcome " + name + " to Tomodachi Game");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viper Hand ITC", Font.BOLD, 28)); 
        heading.setForeground(new Color(255, 255, 255)); // White for visibility in dark theme
        add(heading);
        
        // Rulesexp label with light text
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setForeground(new Color(200, 200, 200)); // Light gray for contrast
        rules.setText(
            "<html>" + 
            "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
            "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
            "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
            "4. You have 15 Seconds for each questions." + "<br><br>" +
            "5. You have a Lifeline option which can be only used once." + "<br><br>" +
            "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
            "7. Score at least 50 points." + "<br><br>" +
            "8. If you cannot score above 50 points, you have to play again" + "<br><br>" +
            "9. If you've failed and playing again, the timer is going to speed up." + "<br><br>" +        
            "<html>"
        );
        add(rules);
        
        // Back button with dark theme colors
        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(70, 70, 70)); // Darker button background
        back.setForeground(Color.WHITE); // White text
        back.addActionListener(this);
        add(back);
        
        // Start button with dark theme colors
        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(70, 70, 70)); // Darker button background
        start.setForeground(Color.WHITE); // White text
        start.addActionListener(this);
        add(start);
        
        // Frame settings
        setSize(800, 650);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quizexp(name,0,15); // Assuming Quizexp class exists
        } else {
            setVisible(false);
            new Loginexp(); // Assuming Loginexp class exists
        }
    }
    
    public static void main(String[] args) {
        new Rulesexp("User");
    }
}
