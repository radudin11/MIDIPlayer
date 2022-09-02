package com.radudin11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class actionperformclass
     extends GUITest implements ActionListener {

        // Method
        public void actionPerformed(ActionEvent event)
        {
            // settext of textfield object of Jtextfield
            button.setText("button is clicked from here!");
        }
}
