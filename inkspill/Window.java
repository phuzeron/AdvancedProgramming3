package inkspill;

import inkspill.life.LifeBoard;
import inkspill.colorSelector.ColorSelectorBoard;
import inkspill.tile.TileBoard;
import java.awt.Container;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * JFrameを用いて画面を表示する
 * @author phuzeron
 */
public class Window extends JFrame{
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
        //アイコンを指定
        try{
            setIconImage(this.createImage((ImageProducer) this.getClass().getResource("assets/favicon.png").getContent()));
        }catch(IOException ex){
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //サイズ変更不可
        this.setResizable(false);
        
        //フレームの配置
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
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
