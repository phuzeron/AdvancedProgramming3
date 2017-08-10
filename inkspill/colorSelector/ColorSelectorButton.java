package inkspill.colorSelector;

import inkspill.ColorInterface;
import inkspill.life.LifeBoard;
import inkspill.tile.TileBoard;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * 操作用の色ボタン
 * @author phuzeron
 */
public class ColorSelectorButton extends JButton implements ColorInterface, ActionListener{
    private int buttonPosX, buttonPosY, buttonWidth, buttonHeight;//色ボタンのX座標、Y座標、幅、高さ
    private String colorCode;//16進数表記のカラーコード
    private boolean connectFlag;//隣のタイルと同じ色の場合true

    private TileBoard tileBoard;//タイルのJPanel
    private LifeBoard lifeBoard;//ライフゲージのJPanel
    
    /**
     * ボタンの配置と初期化をする
     * @param buttonPosX ボタンのX座標
     * @param buttonPosY ボタンのX座標
     * @param buttonWidth ボタンの幅
     * @param buttonHeight ボタンの高さ
     * @param colorLib ボタンの色
     * @param tileBoard タイルのJPanel
     * @param lifeBoard ライフゲージのJPanel
     */
    public ColorSelectorButton(int buttonPosX, int buttonPosY, int buttonWidth, int buttonHeight, ColorLibrary colorLib, TileBoard tileBoard, LifeBoard lifeBoard){
        super();
        //ボタンの配置座標と色指定を代入
        this.buttonPosX = buttonPosX;
        this.buttonPosY = buttonPosY;
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
        this.colorCode = colorLib.getLabel();
        
        //接続判定を初期化
        this.connectFlag = false;
        
        //オブジェクトのポインタを保持
        this.tileBoard = tileBoard;
        this.lifeBoard = lifeBoard;

        //色選択のボタンを配置
        this.setBounds(buttonPosX, buttonPosY, buttonWidth, buttonHeight);
        
        //アクションイベントを受け取る
        this.addActionListener(this);
    }
    
    /**
     * ボタンが押された時の処理
     * @param event 
     */
    @Override
    public void actionPerformed(ActionEvent event){
        //ライフが1以上かつ1つでも繋がっていないタイルがある場合
        if(this.lifeBoard.getSurvivalFlagNum() >= 1 && !this.tileBoard.allTileConnectCheck()){
            this.tileBoard.refreshTile(colorCode); //タイルを更新
            this.lifeBoard.setSurvivalFlagNum(this.lifeBoard.getSurvivalFlagNum() -1); //ライフを1減らす
            this.lifeBoard.refreshLife(); //ライフを更新
        }
        
    }
    
    /**
     * ボタンのグラフィックスを描画する
     * @param g グラフィックス
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.decode(colorCode)); //色を決める
        g.fillRect(0, 0, buttonWidth, buttonHeight); //四角形を描画する
        g.dispose();
    }
}
