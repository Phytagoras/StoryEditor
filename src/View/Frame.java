package View;


import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private int x = 1000, y = 1000;
    public Frame (){
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-x/2, Toolkit.getDefaultToolkit().getScreenSize().height/2-y/2);
        this.setSize(x,y);
        this.setTitle("Editor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    public void setPane(JPanel panel){
        this.setContentPane(panel);
    }
}
