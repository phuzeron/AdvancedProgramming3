package inkspill.tile;

import inkspill.ColorInterface;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 * タイル用のJLabel
 * @author phuzeron
 */
public class Tile extends JLabel implements ColorInterface{
    private int tilePosX, tilePosY, tileWidth, tileHeight; //タイルの配置座標
    private String colorCode; //タイルのカラーコード
    private boolean conectionFlag; //タイルの接続フラグ
    
    /**
     * タイルの配置と初期化をする
     * @param tilePosX タイルのX座標
     * @param tilePosY タイルのY座標
     * @param tileWidth タイルの幅
     * @param tileHeight タイルの高さ
     * @param colorLib  タイルの色
     */
    public Tile(int tilePosX, int tilePosY, int tileWidth, int tileHeight, ColorLibrary colorLib){
        super();
        //タイルの配置座標と色指定を代入
        this.tilePosX = tilePosX;
        this.tilePosY = tilePosY;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.colorCode = colorLib.getLabel();
        
        //接続フラグをfalseに初期化
        this.conectionFlag = false;

        //タイルを配置
        this.setBounds(tilePosX, tilePosY, tileWidth, tileHeight);
    }
    
    /**
     * 接続フラグをセットする
     * @param flag セットする値 trueで接続 falseで非接続
     */
    public void setConectionFlag(boolean flag){
        this.conectionFlag = flag;
    }
    
    /**
     * 接続フラグを取得する
     * @return 取得した値 trueで接続 falseで非接続
     */
    public boolean getConectionFlag(){
        return this.conectionFlag;
    }

    /**
     * カラーコードをセットする
     * @param code 文字列型の16進数カラーコード
     */
    public void setColorCode(String code){
        this.colorCode = code;
    }
    
    /**
     * カラーコードを取得する
     * @return 文字列型の16進数カラーコード
     */
    public String getColorCode(){
        return colorCode;
    }
    
    /**
     * タイルのグラフィックスを描画する
     * @param g グラフィックス
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.decode(colorCode)); //色を決める
        g.fillRect(0+1, 0+1, tileWidth, tileHeight); //四角形を描画する
        g.dispose();
    }
}
