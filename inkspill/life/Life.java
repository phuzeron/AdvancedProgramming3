package inkspill.life;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 * ライフゲージ用のJLabel
 * @author phuzeron
 */
public class Life extends JLabel{
    private int lifePosX, lifePosY, lifeWidth, lifeHeight; //ライフそれぞれの配置座標
    private String colorCode; //カラーコード
    private boolean survivalFlag; //生存フラグ 表示(true)・非表示(false)

    /**
     * ライフの配置と初期化をする
     * @param lifePosX X座標
     * @param lifePosY Y座標
     * @param lifeWidth 幅
     * @param lifeHeight 高さ
     * @param color カラーコード
     */
    public Life(int lifePosX, int lifePosY, int lifeWidth, int lifeHeight, String color){
        super();
        //ライフの配置座標と色指定を代入
        this.lifePosX = lifePosX;
        this.lifePosY = lifePosY;
        this.lifeWidth = lifeWidth;
        this.lifeHeight = lifeHeight;
        this.colorCode = color;

        //生存フラグをtrueに初期化
        this.survivalFlag = true;
        
        //ライフを配置
        this.setBounds(lifePosX, lifePosY, lifeWidth, lifeHeight);
    }
    
    /**
     * 生存フラグをセット
     * @param flag セットする値 trueで生存(表示)、falseで非生存(非表示)
     */
    public void setSurvivalFlag(boolean flag){
        this.survivalFlag = flag;
    }
    
    /**
     * 生存フラグを取得
     * @return 取得する値 trueで生存(表示)、falseで非生存(非表示)
     */
    public boolean getSurvivalFlag(){
        return this.survivalFlag;
    }
    
    /**
     * ライフのグラフィックスを描画する
     * @param g グラフィックス
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //生存フラグがtrue(表示)ならば
        if(this.survivalFlag){
            g.setColor(Color.decode(colorCode)); //色を決める
            g.fillRect(0, 0+3, lifeWidth, lifeHeight); //四角形を描画する
            g.dispose();
        }
    }
}
