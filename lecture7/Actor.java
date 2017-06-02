/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture7;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author phuzeron
 */
public abstract class Actor{

    private JLabel label;    
    
    public Actor(){
        
    }

    public abstract void act();
    
    public void move(int distance){
        label.setLocation(label.getX() + distance, label.getY());
    }
    
    public void turn(){
        
    }
    
    public void isTouching(){
        
    }
    
    public void getIntersectingObjects(){
        
    }
    
    public void setIcon(String path){
        ImageIcon icon = new ImageIcon(path);
        label = new JLabel(icon);
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
    }
    
    public JLabel getIcon(){
        return label;
    }
    
    public void setLocation(int posX, int posY){
        label.setLocation(posX, posY);
    }
    
}
