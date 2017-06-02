/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture7;

/**
 *
 * @author phuzeron
 */
public class MyWorld extends World{
    public MyWorld(){
        super("MyWorld");
        addObject(new Turtle(), 0, 100);
    }
}
