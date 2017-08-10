package inkspill;

import javax.swing.JFrame;

/**
 * メインクラス
 * 起動処理を行う
 * @author phuzeron
 */
public class Main{

    /**
     * @param args the command line arguments. Do nothing.
     */
    public static void main(String[] args){
        //JFrameを作る
        JFrame window = new Window();
        window.setVisible(true);
    }
}
