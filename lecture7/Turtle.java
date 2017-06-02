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
public class Turtle extends Actor{

    public Turtle(){
        super();
        setIcon("./src/lecture7/turtle.png");
    }

    @Override
    public void act(){
        move(1);
    }
}
