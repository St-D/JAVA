package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircleButton {

    private JFrame frame;
    private JLabel label;

    public static void main(String[] args) {
        CircleButton gui = new CircleButton();
        gui.loop();
    }

    private void loop() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton colorButton = new JButton("Change color");
        colorButton.addActionListener(new ColorListener());

        JButton labelButton = new JButton("Change label");
        labelButton.addActionListener(new LabelListener());

        label = new JLabel("I'm label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(300, 300);
        frame.setVisible(true);

    }

    class LabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText(" TST text");

        }
    }

    class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.repaint();

        }
    }

}

class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {

        g.fillRect(0, 0, this.getWidth(), this.getHeight()); // filling area with black color (default color)

        Color randomColor = new Color((int) (Math.random() * 0XFFFFFF));

        g.setColor(randomColor);
        g.fillOval(10, 10, 100, 100);
    }
}
