import javax.swing.*;
import java.awt.*;
public class RestaurantBill {
    public static void main(String[] args) {
        JFrame f = new JFrame("Foodie");
        f.setSize(500, 300);
        f.setLayout(new GridLayout(5, 2, 10, 10));
        f.getContentPane().setBackground(Color.WHITE);
        f.setLocationRelativeTo(null);

        JLabel title = new JLabel("FOODIE\n");
        title.setFont(new Font("Times New Roman", Font.BOLD, 20));
        title.setForeground(Color.RED);
        f.add(title);
        f.add(new JLabel("Restaurant Bill"));

        JTextField name = new JTextField();
        JTextField price = new JTextField();
        JTextField qty = new JTextField();

        f.add(new JLabel("  Item Name:")); f.add(name);
        f.add(new JLabel("  Price:"));     f.add(price);
        f.add(new JLabel("  Quantity:"));  f.add(qty);

        JButton btn = new JButton("Generate Bill");
        btn.setBackground(Color.RED);
        btn.setForeground(Color.WHITE);
        f.add(btn);
        f.add(new JLabel("  Welcome!"));

        btn.addActionListener(e -> {
            try {
                double total = Double.parseDouble(price.getText())
                             * Integer.parseInt(qty.getText());
                double vat = total * 0.15;
                JOptionPane.showMessageDialog(f,
                    " FOODIE'S HAVEN\n--------------------\n"
                    + "Item: " + name.getText()
                    + "\nTotal: " + total
                    + "\nVAT (15%): " + vat
                    + "\nPayable: " + (total + vat),
                    "Your Bill", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Enter valid details!");
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
