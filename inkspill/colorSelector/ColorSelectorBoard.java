package inkspill.colorSelector;

import inkspill.ColorInterface;
import inkspill.life.LifeBoard;
import inkspill.tile.TileBoard;
import javax.swing.JPanel;

/**
 * 色ボタンをのせるJPanel
 * @author phuzeron
 */
public class ColorSelectorBoard extends JPanel implements ColorInterface{
    private final int BUTTON_QUANTITY = 6; //色ボタンの数
    private final int BUTTON_PITCH = 10; //色ボタンの配置間隔
    private ColorSelectorButton[] button; //色ボタンのオブジェクトを保持
    private int ColorPickerBoirdPosX, ColorPickerBoirdPosY, ColorPickerBoirdWidth, ColorPickerBoirdHeight; //パネルの配置座標
        
    /**
     * パネルの配置とボタンの初期化
     * @param tileBoard タイルのパネル
     * @param lifeBoard ライフのパネル
     */
    public ColorSelectorBoard(TileBoard tileBoard, LifeBoard lifeBoard){
        super();
        //パネルの配置座標を代入
        this.ColorPickerBoirdPosX = 140;
        this.ColorPickerBoirdPosY = 380;
        this.ColorPickerBoirdWidth = 35;
        this.ColorPickerBoirdHeight = 200;
        
        //パネルを配置
        this.setLayout(null);
        this.setBounds(ColorPickerBoirdPosX, ColorPickerBoirdPosY, ColorPickerBoirdWidth, ColorPickerBoirdHeight);
        
        //ボタンの初期化
        initButton(tileBoard, lifeBoard);
    }
    
    /**
     * ボタンの初期化
     * @param tileBoard タイルのパネル
     * @param lifeBoard ライフのパネル
     */
    public void initButton(TileBoard tileBoard, LifeBoard lifeBoard){
        //ボタンの初期配置座標
        int buttonPosX = 140;
        int buttonPosY = 380;
        int buttonWidth = 30;
        int buttonHeight = 30;
        
        //オブジェクトを格納する配列を用意
        this.button = new ColorSelectorButton[BUTTON_QUANTITY];
        
        //色ボタンをパネルに配置
        for(int i = 0; i < button.length; i++){
            //使用する色を取得
            ColorLibrary[] color = ColorLibrary.values();
            
            //色ボタンのオブジェクトを作る それぞれの色ボタンに座標と色を割り当てる
            button[i] = new ColorSelectorButton(buttonPosX, buttonPosY, buttonWidth, buttonHeight, color[i], tileBoard, lifeBoard);
            button[i].setLayout(null);
            
            //色ボタンをパネルに追加
            this.add(button[i]);
            
            //次の色ボタンの座標を決定
            buttonPosX += buttonWidth + BUTTON_PITCH;
        }
    }
    
}
