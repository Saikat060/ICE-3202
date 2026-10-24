import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField display = new JTextField();
    JLabel history = new JLabel(" ", JLabel.RIGHT);
    JButton[] btn = new JButton[16];
    String[] keys = {"7","8","9","/","4","5","6","*",
                     "1","2","3","-","C","0","=","+"};
    double num1, num2, result;
    char op;

    Calculator() {
        setTitle("GUI Calculator");
        setSize(360, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5,5));

        JPanel top = new JPanel(new BorderLayout(5,5));
        top.setBorder(new EmptyBorder(15,15,5,15));
        history.setForeground(Color.BLACK);
        display.setFont(new Font("Arial",Font.BOLD,24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        top.add(history,BorderLayout.NORTH);
        top.add(display,BorderLayout.CENTER);
        add(top,BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(4,4,8,8));
        grid.setBorder(new EmptyBorder(10,15,15,15));
        for(int i=0;i<16;i++) {
            btn[i] = new JButton(keys[i]);
            btn[i].setFont(new Font("Arial",Font.BOLD,18));
            btn[i].setFocusPainted(false);
            btn[i].addActionListener(this);
            grid.add(btn[i]);
        }
        add(grid,BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.matches("[0-9]")) display.setText(display.getText()+s);
        else if(s.equals("C")) {
            display.setText("");
            history.setText(" ");
            num1=num2=result=0;
        } else if(s.equals("=")) {
            if(display.getText().isEmpty()) return;
            num2=Double.parseDouble(display.getText());
            switch(op) {
                case '+': result=num1+num2; break;
                case '-': result=num1-num2; break;
                case '*': result=num1*num2; break;
                case '/':
                    if(num2==0) { display.setText("Error"); return; }
                    result=num1/num2; break;
            }
            history.setText(num1+" "+op+" "+num2+" =");
            display.setText(result==(long)result ?
                String.format("%.0f",result):String.valueOf(result));
        } else {
            if(display.getText().isEmpty()) return;
            num1=Double.parseDouble(display.getText());
            op=s.charAt(0);
            history.setText(num1+" "+op);
            display.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}
