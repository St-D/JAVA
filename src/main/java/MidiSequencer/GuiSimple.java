package MidiSequencer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiSimple implements ActionListener {

    private static JFrame frame = new JFrame();
    private static JButton button = new JButton("Click Me");

    public static void main(String[] args) {

        GuiSimple gui = new GuiSimple();
        gui.start();
    }

    public void start() {

        JFrame frame = new JFrame();
        button = new JButton("Click Me");

        button.addActionListener(this);

        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("I've been clicked");
    }
}
