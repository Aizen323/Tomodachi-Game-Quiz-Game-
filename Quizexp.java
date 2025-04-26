package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quizexp extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question, timerLabel;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;
    Timer quizTimer;
    boolean lifelineUsed = false; // Flag to track if lifeline is used

    Quizexp(String name , int count,int timer) {
        this.name = name;
        Quizexp.count=count;
        Quizexp.timer=timer;
        setBounds(50, 0, 1200, 700);
        getContentPane().setBackground(new Color(45, 45, 45)); // Dark background
        setLayout(null);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Quiz time 2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledImage = new ImageIcon(i2);
        JLabel image = new JLabel(scaledImage);
        image.setBounds(0, 0, 1200, 400); 
        add(image);

        // Question number label
        qno = new JLabel();
        qno.setBounds(70, 420, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        qno.setForeground(Color.WHITE);
        add(qno);

        // Question text label
        question = new JLabel();
        question.setBounds(120, 420, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        question.setForeground(Color.WHITE);
        add(question);

        // Define and initialize questions
        questions[0][0] = "Which is used to find and fix bugs in Java programs?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";
        
        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
        
        
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "Java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM ";
        // Options for the questions
        opt1 = new JRadioButton();
        opt1.setBounds(140, 490, 700, 30);
        opt1.setBackground(new Color(65, 65, 65));
        opt1.setForeground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(140, 530, 700, 30);
        opt2.setBackground(new Color(65, 65, 65));
        opt2.setForeground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(140, 570, 700, 30);
        opt3.setBackground(new Color(65, 65, 65));
        opt3.setForeground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(140, 610, 700, 30);
        opt4.setBackground(new Color(65, 65, 65));
        opt4.setForeground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        // Next button
        next = new JButton("Next");
        next.setBounds(930, 470, 150, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN,22));
        next.setBackground(new Color(70, 70, 70));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        // Lifeline button
        lifeline = new JButton("1010 Lifeline");
        lifeline.setBounds(930, 530, 150, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(70, 70, 70));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        // Submit button
        submit = new JButton("Submit");
        submit.setBounds(930, 590, 150, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(70, 70, 70));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        // Timer label
        timerLabel = new JLabel("Time left: " + timer + " seconds");
        timerLabel.setBounds(900, 420, 240, 30);
        timerLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        timerLabel.setForeground(Color.RED);
        add(timerLabel);

        startQuizTimer();  // Initialize and start the timer

        start(count);  // Start the quiz with the first question

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            handleNextAction();
        } else if (ae.getSource() == lifeline) {
            handleLifeline();
        } else if (ae.getSource() == submit) {
            handleSubmit();
        }
    }

    // Timer method using javax.swing.Timer
    private void startQuizTimer() {
        quizTimer = new Timer(1000, new ActionListener() {  // Timer will tick every second (1000 ms)
            @Override
            public void actionPerformed(ActionEvent e) {
                timerLabel.setText("Time left: " + timer + " seconds");
                if (timer > 0) {
                    timer--;
                } else {
                    timer = 15;
                    if (ans_given == 0) {
                        useranswers[count][0] = "";
                    }
                    handleNextAction();
                }
            }
        });
        quizTimer.start();
    }

    private void handleNextAction() {
        ans_given = 1;
        if (groupoptions.getSelection() == null) {
            useranswers[count][0] = "";
        } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
        }

        if (count == 8) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }

        count++;
        if (count < 10) {
            start(count);  // Start the next question
        } else {
            quizTimer.stop();  // Stop the timer when quiz ends
            handleSubmit();  // Handle the submission when all questions are done
        }

        timer = 15;  // Reset the timer for the next question
    }

    private void handleLifeline() {
        if (!lifelineUsed) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
            lifelineUsed = true; // Set the flag to true
        }
    }

    private void handleSubmit() {
        ans_given = 1;
        if (groupoptions.getSelection() == null) {
            useranswers[count][0] = "";
        } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
        }

        for (int i = 0; i < useranswers.length; i++) {
            if (useranswers[i][0].equals(answers[i][1])) {
                score += 10;
            }
        }
        

        setVisible(false);
        new Scoreexp(name, score);  // Show the score after submission
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        // Re-enable all options if lifeline was used
        if (lifelineUsed) {
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            lifelineUsed = false; // Reset flag for next question
        }

        groupoptions.clearSelection();
    }


    public static void main(String[] args) {
        new Quizexp("User",0,15);
    }
}
