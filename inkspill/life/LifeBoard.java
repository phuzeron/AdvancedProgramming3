package inkspill.life;

import inkspill.ColorInterface;
import javax.swing.JPanel;

/**
 * ライフをのせるJPanel
 * @author phuzeron
 */
public class LifeBoard extends JPanel implements ColorInterface{
    private final int LIFE_QUANTITY = 26; //初期ライフの数
    private Life[] life; //ライフのオブジェクトを保持
    private int lifeBoirdPosX, lifeBoirdPosY, lifeBoirdWidth, lifeBoirdHeight; //パネルの配置座標
    private int lifeNum; //ライフの残数
    
    /**
     * パネルの配置とライフの初期化
     */
    public LifeBoard(){
        super();
        //パネルの配置座標を代入
        this.lifeBoirdPosX = 10;
        this.lifeBoirdPosY = 10;
        this.lifeBoirdWidth = 30;
        this.lifeBoirdHeight = 500;

        //パネルを配置する
        this.setLayout(null);
        this.setBounds(lifeBoirdPosX, lifeBoirdPosY, lifeBoirdWidth, lifeBoirdHeight);
        
        //ライフの初期化
        initLife();
    }
    
    /**
     * ライフの初期化
     */
    public void initLife(){
        //ライフの初期配置座標
        int lifePosX = 10;
        int lifePosY = 10;
        int lifeWidth = 25;
        int lifeHeight = 15;
        
        //オブジェクトを格納する配列を用意
        this.life = new Life[LIFE_QUANTITY];
        
        //ライフの初期化
        for(int i = 0; i < life.length; i++){
            //ライフのオブジェクトを作る
            life[i] = new Life(lifePosX, lifePosY, lifeWidth, lifeHeight, "#ff0000");
            life[i].setLayout(null);
            
            //パネルに追加
            this.add(life[i]);
            
            //次のタイルの座標を決定
            lifePosY += lifeHeight;
        }
        
        //ライフの残数を初期化
        this.lifeNum = LIFE_QUANTITY;
    }
    
    /**
     * ライフの残数をセット
     * @param num ライフの残数
     */
    public void setSurvivalFlagNum(int num){
        if(!(num < life.length)) num = life.length;
        this.lifeNum = num;
    }
    
    /**
     * ライフの残数を取得
     * @return ライフの残数
     */
    public int getSurvivalFlagNum(){
        int num = 0; //残数
        for(int i = 0; i < life.length; i++){
            //残数を数える
            if(life[i].getSurvivalFlag()) num++;
        }
        return num;
    }
    
    /**
     * ライフを更新
     */
    public void refreshLife(){
        try{
            //ライフの残数を元にライフゲージの一部を非表示にする
            int deathNum = LIFE_QUANTITY - lifeNum;
            for(int i = 0; i < deathNum; i++){
                life[i].setSurvivalFlag(false);
            }
            
            //再描画
            this.repaint();
        }catch(Exception ex){
            //何もしない
        }
    }
}
