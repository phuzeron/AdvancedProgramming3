/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenfoot;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author phuzeron
 */
public class Main{
    private final static long SLEEP_TIME = 1L; //画面を更新する間隔

    public static void main(String[] args){
        MyWorld world = new MyWorld();
        world.setVisible(true);
        Timer timer = new Timer();

        TimerTask timertask = new TimerTask(){
            @Override
            public void run(){
                world.act(); //Actorのactメソッドを順に呼び出す
                world.repaint(); //Acotrを再描画する
            }
        };

        //Timerを使用してSLEEP_TIMEの間隔で呼び出す
        timer.schedule(timertask, 0, SLEEP_TIME);
    }
}
