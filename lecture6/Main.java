/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phuzeron
 */
public class Main{
    
    private final static long SLEEP_TIME = 4;
    
    public static void main(String[] args){
        World world = new World("Step 3");
        world.setVisible(true);
        
        int x= 1, y = 1;
        while(true){
            try{
                world.move(x,y);
                if(world.getPositionX() >= 300 - world.getImageHeight() || world.getPositionX() <= 0){
                    x = x * -1;
                }
                if(world.getPositionY() >= 250 - world.getTitleBarHeight() - world.getImageWidth() || world.getPositionY() <= 0){;
                    y = y * -1;
                }
                
                //world.move(1,1);
                Thread.sleep(SLEEP_TIME);
            }catch(InterruptedException ex){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
