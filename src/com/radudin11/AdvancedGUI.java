package com.radudin11;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class AdvancedDrawPanel extends JPanel {

    public void paintComponent(Graphics g) {
        // make background black
        g.setColor(Color.black);
        g.fillRect(0,0,this.getWidth(), this.getHeight());

        Graphics2D g2d = (Graphics2D) g;

        // get start color
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        Color startColor = new Color(red, green, blue);

        // get end color
        red = (int) (Math.random() * 256);
        green = (int) (Math.random() * 256);
        blue = (int) (Math.random() * 256);
        Color endColor = new Color(red, green, blue);

        GradientPaint gradient = new GradientPaint(100,100,startColor, 330,330, endColor);

        g2d.setPaint(gradient);
        g2d.fillOval(100,100,300,300);
    }
}

public class AdvancedGUI {

    JFrame frame;
    JLabel label;

    public static void main(String args[]) throws InterruptedException {
        AdvancedGUI gui = new AdvancedGUI();
        gui.go();
    }

    public void go() throws InterruptedException {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.setSize(700,700);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change color");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("I'm a label");

        frame.add(BorderLayout.EAST, labelButton);
        frame.add(BorderLayout.WEST, label);
        frame.add(BorderLayout.SOUTH, colorButton);
        frame.add(BorderLayout.CENTER,new AdvancedDrawPanel());
    }

    class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.repaint();
        }
    }

    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            label.setText("i'm another text");
        }
    }
}

