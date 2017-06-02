/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phuzeron
 */
public class Main{

    private final static long SLEEP_TIME = 50;

    public static void main(String[] args){
        MyWorld world = new MyWorld();
        world.setVisible(true);
        
        while(true){
            try{
                world.repaint();
                Thread.sleep(SLEEP_TIME);
            }catch(InterruptedException ex){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
