import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task1 extends JFrame implements ActionListener {
    private JLabel l1, l2, l3, l4, l5, l6;
    private JTextField tf1, tf2, tf5, tf6;
    private JButton btn1;

    Task1() {
        setSize(700, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Task 1");
        l1 = new JLabel("Task 1");
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Started directory:");
        l3 = new JLabel("Files count (integer):");
        l4 = new JLabel("Threshold (integer):");
        l5 = new JLabel("Directory with copied files:");
        l6 = new JLabel("Wrong format of input");
        l6.setForeground(Color.RED);
        l6.setVisible(false);
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        btn1 = new JButton("Submit");
        btn1.addActionListener(this);
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 240, 200, 30);
        tf1.setBounds(300, 70, 350, 30);
        tf2.setBounds(300, 110, 350, 30);
        tf5.setBounds(300, 150, 350, 30);
        tf6.setBounds(300, 190, 350, 30);
        btn1.setBounds(100, 290, 100, 30);
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(l5);
        add(tf5);
        add(tf6);
        add(l6);
        add(btn1);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String startedDirectory = tf1.getText();
        String filesCount = tf2.getText();
        String threshold = tf5.getText();
        String endDir = tf6.getText();
        try {
            l6.setVisible(false);
            Handler.handleTask1(startedDirectory, Integer.parseInt(filesCount), Integer.parseInt(threshold), endDir);
        } catch (NumberFormatException | NullPointerException ex) {
            l6.setVisible(true);
        }
    }

    public static void main(String[] args) {
        if (args.length != 0) {
            helpText();
        } else {
            new Task1();
        }
    }

    public static void helpText() {
        System.out.println("usage: java Task1\n");
//        System.out.println("usage: java Task1 [startedDir] [filesCount] [threshold] [endDir]\n");
//        System.out.println("[startedDir] - started directory\n");
//        System.out.println("[filesCount] - count of files\n");
//        System.out.println("[threshold] - threshold size of file in byte\n");
//        System.out.println("[endDir] - directory, where all files that don\'t pass threshold will be copied\n");
        System.exit(1);
    }
}
