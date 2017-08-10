package inkspill.tile;

import inkspill.ColorInterface;
import java.util.Random;
import javax.swing.JPanel;

/**
 * タイルをのせるJPanel
 * @author phuzeron
 */
public class TileBoard extends JPanel implements ColorInterface{
    private final int TILE_QUANTITY = 12; //一辺のタイル数
    private Tile[][] tile; //タイルのオブジェクトを保持
    private int tileBoirdPosX, tileBoirdPosY, tileBoirdWidth, tileBoirdHeight; //パネルの配置座標
    
    /**
     * パネルの配置とタイルの初期化
     */
    public TileBoard(){
        super();
        //パネルの配置座標を代入
        this.tileBoirdPosX = 90;
        this.tileBoirdPosY = 10;
        this.tileBoirdWidth = 350;
        this.tileBoirdHeight = 350;

        //パネルを配置する
        this.setLayout(null);
        this.setBounds(tileBoirdPosX, tileBoirdPosY, tileBoirdWidth, tileBoirdHeight);

        //タイルの初期化
        initTile();
    }
    
    /**
     * タイルの初期化
     */
    public void initTile(){
        //タイルの初期配置座標
        int tilePosX = 0;
        int tilePosY = 0;
        int tileWidth = 28;
        int tileHeight = 28;
        
        //オブジェクトを格納する配列を用意
        this.tile = new Tile[TILE_QUANTITY][TILE_QUANTITY];
        
        //タイルの初期化
        for(int i = 0; i < tile.length; i++){
            for(int j = 0; j < tile[i].length; j++){
                //タイルの色はランダムに決める
                Random random = new Random();
                ColorLibrary color = ColorLibrary.values()[random.nextInt(ColorLibrary.values().length)];
                
                //タイルのオブジェクトを作る
                tile[i][j] = new Tile(tilePosX, tilePosY, tileWidth, tileHeight, color);
                tile[i][j].setLayout(null);
                
                //パネルに追加
                this.add(tile[i][j]);
                
                //次のタイルのX座標を決定
                tilePosX += tileWidth;
            }
            //次のタイルの座標を決定
            tilePosX = 0;
            tilePosY += tileHeight;
        }
        
        //0, 0のタイルを接続状態にする
        this.tile[0][0].setConectionFlag(true);
        //タイルを更新
        this.refreshTile(tile[0][0].getColorCode());
        
    }
    
    /**
     * 接続していないタイルが1つでもあればfalse、1つもなければtrueを返す
     * @return 
     */
    public boolean allTileConnectCheck(){
         for(Tile[] array : tile){
            for(Tile element : array){
                //接続していないタイルがあるか
                if(!element.getConectionFlag()) return false;
            }
        }
        return true;
    }
    
    /**
     * タイルを更新する
     * @param pushColorCode 押された色ボタンのカラーコード
     */
    public void refreshTile(String pushColorCode){
        for(int i = 0; i < tile.length; i++){
            for(int j = 0; j < tile[i].length; j++){                   
                    //タイルごとの接続フラグを取得
                    if(tile[i][j].getConectionFlag()){
                        //タイルの色を押したボタンの色に変える
                        tile[i][j].setColorCode(pushColorCode);
                        
                        //西方向のタイルをチェック
                        try{
                            //タイルの色と押した色ボタンの色が同じ場合
                            if(tile[i][j-1].getColorCode().equals(pushColorCode)){
                                //接続フラグをtrueにする
                                tile[i][j-1].setConectionFlag(true);
                                //タイルの色を押したボタンの色に変える
                                tile[i][j-1].setColorCode(pushColorCode);
                            }
                        }catch(ArrayIndexOutOfBoundsException ex){
                            //何もしない
                        }
                        
                        //東方向のタイルをチェック
                        try{
                            //タイルの色と押した色ボタンの色が同じ場合
                            if(tile[i][j+1].getColorCode().equals(pushColorCode)){
                                //接続フラグをtrueにする
                                tile[i][j+1].setConectionFlag(true);
                                //タイルの色を押したボタンの色に変える
                                tile[i][j+1].setColorCode(pushColorCode);
                            }
                        }catch(ArrayIndexOutOfBoundsException ex){
                            //何もしない
                        }
                            
                        //北方向のタイルをチェック
                        try{
                            //タイルの色と押した色ボタンの色が同じ場合
                            if(tile[i-1][j].getColorCode().equals(pushColorCode)){
                                //接続フラグをtrueにする
                                tile[i-1][j].setConectionFlag(true);
                                //タイルの色を押したボタンの色に変える
                                tile[i-1][j].setColorCode(pushColorCode);
                            }
                        }catch(ArrayIndexOutOfBoundsException ex){
                            //何もしない
                        }
                            
                        //南方向のタイルをチェック
                        try{
                            //タイルの色と押した色ボタンの色が同じ場合
                            if(tile[i+1][j].getColorCode().equals(pushColorCode)){
                                //接続フラグをtrueにする
                                tile[i+1][j].setConectionFlag(true);
                                //タイルの色を押したボタンの色に変える
                                tile[i+1][j].setColorCode(pushColorCode);
                            }
                        }catch(ArrayIndexOutOfBoundsException ex){
                            //何もしない
                        }
                    }
            }
        }
        
        //描画を更新
        this.repaint();
    }
    
}