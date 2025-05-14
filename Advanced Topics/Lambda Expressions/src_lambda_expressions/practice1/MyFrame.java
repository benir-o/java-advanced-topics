package practice1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    JButton myButton= new JButton("MyButton");
    MyFrame(){
        myButton.setBounds(100,100,200,100);
        myButton.addActionListener((f)-> System.out.println("You clicked a button!"));

        this.add(myButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);
    }

}
