/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture6;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author phuzeron
 */
public class World extends JFrame{

    private JLabel label;
    private int ImageWidth, ImageHeight;

    public World(String title){
        super();
        setTitle(title);
        setBounds(0, 0, 300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        ImageIcon turtleIcon = new ImageIcon("./src/lecture6/turtle.png");
        ImageWidth = turtleIcon.getIconWidth();
        ImageHeight = turtleIcon.getIconHeight();
        label = new JLabel(turtleIcon);

        panel.setLayout(null);
        label.setBounds(0, 0, ImageWidth, ImageHeight);
        panel.add(label);

        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);
    }
    
    public void move(int x, int y){
        label.setLocation(label.getX() + x, label.getY() + y);
    }
    
    public int getPositionX(){
        return label.getX();
    }
    
    public int getPositionY(){
        return label.getY();
    }
    
    public int getImageWidth(){
        return ImageWidth;
    }
    
    public int getImageHeight(){
        return ImageHeight;
    }
    
    public int getTitleBarHeight(){
        return getInsets().top;
    }
}
