
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Player1 here.
 *
 * @author phuzeron
 * @version (a version number or a date)
 */
public class Player2 extends Actor implements Janken{

    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int myHand;

    public Player2(int direction){
        this.setRotation(direction);
    }

    /**
     * じゃんけんを行う
     * meの変数が0でグー、1でチョキ、2でパーを出す
     * 結果は0があいこ、1が負け、2が勝ちとなる
     * @return じゃんけんの結果
     */
    @Override
    public int janken(){
        Random random = new Random();
        int me = random.nextInt(3);//0:グー, 1:チョキ, 2:パー
        Janken yourHand = (Janken) getOneIntersectingObject(null);
        return (me - yourHand.getYourHand() + 3) % 3;//0:draw, 1:lose, 2:win
    }

    @Override
    public int getYourHand(){
        return myHand;
    }

    @Override
    public void act(){
        if(isTouching(null)){
            if(getOneIntersectingObject(null) instanceof Janken){
                switch(janken()){
                    case 0://draw
                        janken();
                    case 1://lose
                        turn(60);
                        move(100);
                    case 2://win
                        break;
                    default://do nothing
                        break;
                }
            }
        }else{
            move(1);
        }
    }
}
