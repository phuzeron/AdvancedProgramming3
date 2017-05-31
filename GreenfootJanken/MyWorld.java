
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 *
 * @author phuzeron
 * @version (a version number or a date)
 */
public class MyWorld extends World{

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public MyWorld(){
        super(600, 400, 1);
        addObject(new Player1(0), 10, 200);
        addObject(new Player2(180), 580, 200);
        //addObject(new Player3(180), 580, 200); //じゃんけんインターフェイスを持たない動物
    }
}
