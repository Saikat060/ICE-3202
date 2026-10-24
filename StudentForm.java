import javax.swing.*;
import java.awt.*;

public class StudentForm extends JFrame {
    JTextField name = new JTextField();
    JTextField roll = new JTextField();
    JTextField email = new JTextField();
    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    JComboBox<String> dept =
        new JComboBox<>(new String[]{"ICE", "CSE", "EEE", "ECE"});

    StudentForm() {
        setTitle("Student Registration Form");
        setSize(420, 430);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("STUDENT REGISTRATION", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.WHITE);

        JPanel header = new JPanel();
        header.setBackground(new Color(41, 128, 185));
        header.add(title);
        add(header, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 15));
        form.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        form.setBackground(new Color(248, 249, 250));

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        JPanel gender = new JPanel();
        gender.add(male);
        gender.add(female);
        gender.setBackground(new Color(248, 249, 250));

        form.add(new JLabel("Full Name:")); form.add(name);
        form.add(new JLabel("Roll No:")); form.add(roll);
        form.add(new JLabel("Gender:")); form.add(gender);
        form.add(new JLabel("Department:")); form.add(dept);
        form.add(new JLabel("Email:")); form.add(email);
        add(form, BorderLayout.CENTER);

        JButton submit = new JButton("Submit");
        JButton reset = new JButton("Reset");
        JPanel buttons = new JPanel();
        buttons.add(submit);
        buttons.add(reset);
        add(buttons, BorderLayout.SOUTH);

        submit.addActionListener(e -> {
            if (name.getText().trim().isEmpty()
                || roll.getText().trim().isEmpty()
                || email.getText().trim().isEmpty()
                || (!male.isSelected() && !female.isSelected())) {
                JOptionPane.showMessageDialog(this, "Fill all fields!");
                return;
            }

            JOptionPane.showMessageDialog(this,
                "STUDENT DETAILS\n\nName: " + name.getText()
                + "\nRoll: " + roll.getText()
                + "\nGender: " + (male.isSelected() ? "Male" : "Female")
                + "\nDepartment: " + dept.getSelectedItem()
                + "\nEmail: " + email.getText(),
                "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
        });

        reset.addActionListener(e -> {
            name.setText("");
            roll.setText("");
            email.setText("");
            bg.clearSelection();
            dept.setSelectedIndex(0);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentForm());
    }
}
