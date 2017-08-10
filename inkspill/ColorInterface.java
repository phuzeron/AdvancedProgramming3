package inkspill;

/**
 * 色を実装するインターフェース
 * @author phuzeron
 */
public interface ColorInterface{
    /**
     * ゲームに使用する色を定義
     */
    public static enum ColorLibrary{
        //列挙定数の定義
        PINK("#ff4783"),
        ORANGE("#ff8701"),
        YELLOW("#ffff46"),
        GREEN("#50f93c"),
        BLUE("#301be2"),
        PURPLE("#e104ff");

        /**
         * フィールド変数
         */
        private String label;

        /**
         * コンストラクタ
         * @param label 定数の値
         */
        ColorLibrary(String label) {
                this.label = label;
        }

        /**
         * 値取得メソッド
         * @return 定数の値
         */
        public String getLabel() {
                return this.label;
        }
        
        /**
         * インデックス取得メソッド
         * @return 定数のインデックス
         */
        public int getOrdinal(){
            return this.ordinal();
        }
    }
    
}
