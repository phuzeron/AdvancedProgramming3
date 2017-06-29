/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenfoot;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Greenfootの世界に存在するオブジェクト
 * 世界に出現されるオブジェクトはActorを拡張する
 * @author phuzeron
 */
public class Actor{
    
    private JLabel label; //Actor画像
    private World world; //Worldのオブジェクト
    private double posX, posY, degrees; //X座標, Y座標, 角度
    private boolean edged = false; //壁にぶつかっているか

    /**
     * コンストラクタ
     */
    public Actor(){
        super();
    }
    
    /**
     * Actorの動き
     * サブクラスでオーバーライドする
     */
    public void act(){
        //do nothing
    }

    /**
     * ActorのX座標を取得する
     * @return X座標
     */
    public double getX(){
        return this.posX;
    }

    /**
     * ActorのY座標を取得する
     * @return Y座標
     */
    public double getY(){
        return this.posY;
    }

    /**
     * 壁にぶつかっているかを返す
     * @return 壁に壁にぶつかっている場合true
     */
    public boolean isAtEdge(){
        return edged;
    }

    /**
     * JLabelを指定した座標に移動する
     * @param x X座標
     * @param y Y座標
     */
    public void setLocation(double x, double y){
        label.setLocation((int)x, (int)y);
    }

    /**
     * Actorを移動させる
     * @param distance 移動量
     */
    public void move(double distance){
        int WORLD_WIDTH = world.getWorldWidth();
        int WORLD_HEIGHT = world.getWorldHeight();
        
        //移動先の座標を求める
        this.posX += (distance * (Math.cos(Math.toRadians(degrees))));
        this.posY += (distance * (Math.sin(Math.toRadians(degrees))));
        
        //画面外に移動した時は引き戻す
        if(this.posX >= WORLD_WIDTH - (label.getWidth())){
            this.posX = WORLD_WIDTH - (label.getWidth());
            edged = true;
        }
        if(this.posY >= WORLD_HEIGHT - label.getHeight()){
            this.posY = WORLD_HEIGHT - label.getHeight();
            edged = true;
        }
        if(this.posX <= 0){
            this.posX = 0;
            edged = true;
        }
        if(this.posY <= 0){
            this.posY = 0;
            edged = true;
        }
    }

    /**
     * Actorの進行方向を変える
     * @param amount 進行方向
     */
    public void turn(int amount){
        this.degrees += amount;
    }

    /**
     * 衝突したActorのオブジェクトをリストで取得する
     * @param cls 衝突を検査するActor nullを渡すことで全てのActorで衝突を検査する
     * @return 衝突したActorのオブジェクトのリスト
     */
    public <Actor> java.util.List<Actor> getIntersectingObjects(java.lang.Class<Actor> cls){
        List<Actor> collisionList = this.world.collisionChecker(this);
        if(cls == null){
            //全体検索
            for(Actor actor : collisionList){
                if(actor.equals(this)) return collisionList;
            }
        }else{
            //個別検索
            List<Actor> individualCollisionList = new ArrayList<>();
            for(Actor actor : collisionList){
                if(actor.equals(cls)) individualCollisionList.add(actor);
            }
            return individualCollisionList;
        }
        return null;
    }
    
    /**
     * 衝突したActorのオブジェクトを取得する
     * @param cls 衝突を検査するActor nullを渡すことで全てのActorで衝突を検査する
     * @return 衝突したActorのオブジェクト
     */
    public Actor getOneIntersectingObject(java.lang.Class<?> cls){
        List<Actor> collisionList = this.world.collisionChecker(this);
        if(cls == null){
            //全体検索
            if(!collisionList.isEmpty()) return collisionList.get(0);
        }else{
            //個別検索
            for(Actor actor : collisionList){
                if(actor.equals(cls)) return actor;
            }
        }
        return null;
    }
    
    /**
     * 指定したActorと衝突しているかを返す
     * @param cls 衝突を検査するActor nullを渡すことで全てのActorで衝突を検査する
     * @return 衝突した場合trueを返す
     */
    public boolean isTouching(java.lang.Class<?> cls){
        List<Actor> collisionList = this.world.collisionChecker(this);
        if(cls == null){
            //全体検索
            return !collisionList.isEmpty();
        }else{
            //個別検索
            for(Actor actor : collisionList){
                if(actor.equals(this)) return true;
            }
        }
        return false;
    }
    
    /**
     * JLabelを取得する
     * @return JLabel
     */
    public JLabel getLabel(){
        return label;
    }
    
    /**
     * JLabelをセットする
     * @param path 画像のパス
     */
    public void setLabel(String path){
        ImageIcon icon = new ImageIcon(path);
        label = new JLabel(icon);
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
    }
    
    /**
     * Actorの幅を返す
     * @return Actorの幅
     */
    public int getWidth(){
        return label.getWidth();
    }
    
    /**
     * Actorの高さを返す
     * @return Actorの高さ
     */
    public int getHeight(){
        return label.getHeight();
    }
    
    /**
     * Actorの座標をセットする
     * @param x X座標
     * @param y Y座標
     */
    public void setPosition(int x, int y){
        this.posX = x;
        this.posY = y;
    }
    
    /**
     * Actorの進行方向をセットする
     * @param direction 進行方向
     */
    public void setRotation(int direction){
        turn(direction);
    }
    
    /**
     * Wordのオブジェクトを保持する
     * @param world Actorが属するWorldのオブジェクト
     */
    public void setWorldObject(World world){
        this.world = world;
    }
    
}
