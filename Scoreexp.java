package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Scoreexp extends JFrame implements ActionListener {

    private JButton close, playAgain;
    private String name;
    private int score;

    Scoreexp(String name, int score) {
        this.name = name;
        this.score = score;
        
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(new Color(45, 45, 45)); // Dark background
        setLayout(null);
        
        // Update header image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Score.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 150, 300, 300);
        add(image);
        
        // Determine the message based on score
        String message;
        if (score < 50) {
            message = "You failed " + name + "!";
        } else {
            message = "Thank you " + name + " for playing Tomodachi Game!";
        }

        // Heading label
        JLabel heading = new JLabel(message);
        heading.setBounds(0, 30, 750, 30); // Centered horizontally
        heading.setHorizontalAlignment(SwingConstants.CENTER); // Center text
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        heading.setForeground(Color.WHITE);
        add(heading);
        
        // Score label
        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(350, 200, 300, 30); // Centered horizontally
        lblscore.setHorizontalAlignment(SwingConstants.CENTER); // Center text
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblscore.setForeground(Color.WHITE);
        add(lblscore);
        
        // Play Again button
        playAgain = new JButton("Play Again");
        playAgain.setBounds(380, 270, 120, 30);
        playAgain.setBackground(new Color(30, 144, 255)); // Bright button color for contrast
        playAgain.setForeground(Color.WHITE);
        playAgain.addActionListener(this);
        add(playAgain);

        // Close button
        close = new JButton("Close");
        close.setBounds(510, 270, 120, 30);
        close.setBackground(new Color(255, 69, 0)); // Bright button color for contrast
        close.setForeground(Color.WHITE);
        close.addActionListener(this);

        // Disable close button if score is below 50
        if (score < 50) {
            close.setEnabled(false);
        } else {
            close.setEnabled(true);
        }

        add(close);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == playAgain) {
            setVisible(false);  // Hide the score window
            if (score < 50) {
                new Rulesexp(name);  // Restart the quiz with the same name
            } else {
                new Loginexp();  // Redirect to Loginexp if score is 50 or above
            }
        } else if (ae.getSource() == close) {
            System.exit(0);  // Close the program if the close button is enabled
        }
    }

    public static void main(String[] args) {
        new Scoreexp("User", 0);
    }
}
