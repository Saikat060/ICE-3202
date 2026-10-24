import javax.swing.*;
public class DisplayImage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Display Image");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("photo.jfif");
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setVisible(true);
    }
}
