import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task2 extends JFrame implements ActionListener {
    private JLabel l1, l2, l6;
    private JTextField tf1;
    private JButton btn1;

    Task2() {
        setSize(700, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Task 2");
        l1 = new JLabel("Task 2");
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Started directory:");
        l6 = new JLabel("Wrong format of input");
        l6.setForeground(Color.RED);
        l6.setVisible(false);
        tf1 = new JTextField();
        btn1 = new JButton("Submit");
        btn1.addActionListener(this);
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l6.setBounds(80, 110, 200, 30);
        tf1.setBounds(300, 70, 350, 30);
        btn1.setBounds(100, 150, 100, 30);
        add(l1);
        add(l2);
        add(tf1);
        add(l6);
        add(btn1);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String startedDirectory = tf1.getText();
        try {
            l6.setVisible(false);
            Handler.handleTask2(startedDirectory);
        } catch (Exception ex) {
            l6.setVisible(true);
        }
    }

    public static void main(String[] args) {
        if (args.length != 0) {
            helpText();
        } else {
            new Task2();
        }
    }

    public static void helpText() {
        System.out.println("usage: java Task2");
//        System.out.println("usage: java Task2 [startedDir]");
//        System.out.println("[startedDir] - started directory");
        System.exit(1);
    }
}
