package inkspill;

import inkspill.life.LifeBoard;
import inkspill.colorSelector.ColorSelectorBoard;
import inkspill.tile.TileBoard;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * JFrameを用いて画面を表示する
 * @author phuzeron
 */
public class Window extends JFrame{
    private final int WINDOW_POS_X = 0;//ウィンドウのX座標
    private final int WINDOW_POS_Y = 0;//ウィンドウのY座標
    private final int WINDOW_WIDTH = 500;//ウィンドウの横幅
    private final int WINDOW_HEIGHT = 500;//ウィンドウの高さ
    private Container containt;//GUIのコンテナ
    
    /**
     * コンストラクタ
     * Containerに各要素のパネルを追加
     */
    public Window(){
        super();
        //タイトルを指定
        this.setTitle("Ink Spill");
        //フレームの配置
        this.setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.containt = getContentPane();
        
        //タイルのパネル
        JPanel tileBoard = new TileBoard();
        this.containt.add(tileBoard);
        
        //ライフゲージのパネル
        JPanel lifeBoard = new LifeBoard();
        this.containt.add(lifeBoard);
        
        //色ボタンのパネル
        JPanel colorPickerBoard = new ColorSelectorBoard((TileBoard) tileBoard, (LifeBoard) lifeBoard);
        this.containt.add(colorPickerBoard);
    }

}
