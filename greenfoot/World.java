/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenfoot;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Greenfootの画面とActorのオブジェクトを管理する
 * @author phuzeron
 */
public class World extends JFrame{

    private JPanel panel;
    private List<Actor> actorList;

    /**
     * JFrameでWorld画面を構成する
     * @param worldName 世界の名前
     * @param worldWidth 世界の幅
     * @param worldHeight 世界の高さ
     * @param cellSize セルサイズ
     */
    public World(String worldName, int worldWidth, int worldHeight, int cellSize){
        super();
        //表示する画面を作る
        setTitle(worldName);

        addNotify();
        setBounds(0, 0, worldWidth, worldHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);

        //フィールドの初期化
        actorList = new ArrayList<>();
    }

    /**
     * Actorのサブクラスを画面に追加する
     * @param object 追加するActorのサブクラス
     * @param x X座標
     * @param y Y座標
     */
    public void addObject(Actor object, int x, int y){
        panel.add(object.getLabel());
        object.setPosition(x, y);
        object.setWorldObject(this);
        actorList.add(object);
    }

    /**
     * 画面を一斉に再描画する
     */
    public void repaint(){
        for(Actor actor : actorList){
            actor.setLocation(actor.getX(), actor.getY());
        }
    }

    /**
     * Actorの座標を更新する
     */
    public void act(){
        for(Actor actor : actorList){
            actor.act();
        }
    }

    /**
     * 世界の幅を返す
     * @return 世界の幅
     */
    public int getWorldWidth(){
        return panel.getWidth();
    }

    /**
     * 世界の高さを返す
     * @return 世界の高さ
     */
    public int getWorldHeight(){
        return panel.getHeight();
    }

    /**
     * タイトルバーの高さを返す
     * @return タイトルバーの高さ
     */
    public int getTitleBarHeight(){
        return getInsets().top;
    }

    /**
     * 衝突判定を行う
     * @param actor 衝突判定を行うActorのオブジェクト
     * @return 衝突したActorのリスト
     */
    public List collisionChecker(Actor actor){
        List<Actor> collisionList = new ArrayList<>();
        //引数のactorとactorListのオブジェクトからそれぞれの座標を拾う
        for(Actor actors : actorList){
            if(!actors.equals(actor) && (Math.abs(actor.getX() - actors.getX()) < (actor.getWidth() + actors.getWidth())/2) && (Math.abs(actor.getY() - actors.getY()) < (actor.getHeight() + actors.getHeight())/2)) collisionList.add(actors);
        }
        return collisionList;
    }
    
}
