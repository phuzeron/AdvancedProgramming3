
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player3 here.
 *
 * @author phuzeron
 * @version (a version number or a date)
 */
public class Player3 extends Actor{

    /**
     * コンストラクタに渡す引数によって動物の向きを変える
     * 度数法で表記する。0度で右向き、180度で左向きになる。
     * @param direction 動物の向き
     */
    public Player3(int direction){
        super();
        this.setRotation(direction);
    }

    /**
     * Act - do whatever the Player3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act(){
        move(1);
    }
}
