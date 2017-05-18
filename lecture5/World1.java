/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture5;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author phuzeron
 */
public class World1 extends JFrame implements MouseMotionListener{
    
    private JLabel label;
    
    public World1(){
        setTitle("World1");
        setBounds(0, 0, 480, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        ImageIcon turtle = new ImageIcon("./src/lecture5/turtle.png");
        
        label = new JLabel(turtle);
        panel.setLayout(null);
        label.setBounds(100, 100, 25, 25);
        panel.add(label);
        
        Container containt = getContentPane();
        containt.add(panel, BorderLayout.CENTER);
        
        containt.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent event){
        label.setBounds(event.getX(), event.getY(), label.getWidth(), label.getHeight());
    }

    @Override
    public void mouseMoved(MouseEvent e){
        //do nothing
    }
    
}
