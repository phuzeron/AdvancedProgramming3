
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Player2 here.
 *
 * @author phuzeron
 * @version (a version number or a date)
 */
public class Player2 extends Actor implements Janken{

    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int myHand;
    private boolean refreshHand;

    public Player2(int direction){
        this.setRotation(direction);
    }

    /**
     * じゃんけんを行う
     * myHandの変数が0でグー、1でチョキ、2でパーを出す
     * 結果は0があいこ、1が負け、2が勝ちとなる
     * @return じゃんけんの結果
     */
    @Override
    public int janken(){
        Random random = new Random();
        this.myHand = random.nextInt(3);//0:グー, 1:チョキ, 2:パー
        this.refreshHand = true;
        Janken yourHand = (Janken) getOneIntersectingObject(null);
        return (myHand - yourHand.getYourHand() + 3) % 3;//0:draw, 1:lose, 2:win
    }

    @Override
    public int getYourHand(){
        if(!this.refreshHand){
            Random random = new Random();
            this.myHand = random.nextInt(3);//0:グー, 1:チョキ, 2:パー
        }
        this.refreshHand =  false;
        return this.myHand;
    }

    @Override
    public void act(){
        if(isTouching(null)){
            if(getOneIntersectingObject(null) instanceof Janken){
                switch(janken()){
                    case 0://draw
                        janken();
                    case 1://lose
                        move(-10);
                        turn(60);
                        move(100);
                    default://do nothing
                        break;
                }
            }
            if (this.refreshHand) this.refreshHand = false;
        }else{
            move(1);
        }
    }
}
