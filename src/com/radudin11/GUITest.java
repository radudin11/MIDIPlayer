package com.radudin11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyDrawPanel extends JPanel {

    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,this.getWidth(), this.getHeight());

        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(100,100,Color.blue, 160,180, Color.magenta);

        g2d.setPaint(gradient);
        g2d.fillOval(100,100,100,100);
    }
}

public class GUITest implements ActionListener {
    static JButton  button = new JButton("Click me!");
    public static void main(String args[]) {
        GUITest gui = new GUITest();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();

        button.setBounds(40, 50, 100, 20);
        ActionListener listener = new actionperformclass();

        button.addActionListener(listener);
//
        //frame.getContentPane().add(button);
        frame.add(new MyDrawPanel());
        //frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        button.setText("I've been clicked");
    }
}


