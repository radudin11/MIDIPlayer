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

        GradientPaint gradient = new GradientPaint(100,100,startColor, 160,180, endColor);

        g2d.setPaint(gradient);
        g2d.fillOval(100,100,100,100);
    }
}

public class AdvancedGUI implements ActionListener {
    Button button;
    JFrame frame;

    public static void main(String args[]) throws InterruptedException {
        AdvancedGUI gui = new AdvancedGUI();
        gui.go();
    }

    public void go() throws InterruptedException {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(700,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button = new Button("Change color");

        button.addActionListener(this);

        frame.add(BorderLayout.SOUTH, button);
        frame.add(BorderLayout.CENTER,new AdvancedDrawPanel());
    }

    public void actionPerformed(ActionEvent event) {
        for(int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException ex) {

            }
            finally {
                frame.repaint();
            }
        }
    }
}
