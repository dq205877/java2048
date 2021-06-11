import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainApp {

//    static List tileIDs = List.of(2,4,8,16);

    List<List<Tile>> board = new ArrayList<>();
    Random random = new Random();


    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        mainApp.initBoard(4);
        System.out.println(mainApp);

//        mainApp.randomOneTile();
//        mainApp.randomOneTile();

        mainApp.board.get(1).get(3).id = 2;
        mainApp.board.get(1).get(2).id = 2;
        mainApp.board.get(1).get(1).id = 2;

        System.out.println(mainApp);

        mainApp.left();

        System.out.println(mainApp);

        mainApp.left();

        System.out.println(mainApp);
    }

    void initBoard(int size) {
        board.clear();
        for (int i = 0; i < size; i++) {
            List<Tile> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Tile(0));
            }
            board.add(row);
        }
    }

    public String toString() {
        String text = "";
        for (List<Tile> row : board) {
            for (Tile tile : row) {
                text += tile.toString();
                text += "\t";
            }
            text += "\n";
        }

        return text;
    }

    public void randomOneTile() {
        List<Tile> flat = new ArrayList<>();
        for (List<Tile> row : board) {
            for (Tile tile : row) {
                if (tile.id == 0) flat.add(tile);
            }
        }

        Tile tile = flat.get(random.nextInt(flat.size()));
        tile.setId(2);
    }

    public void left() {  // ⬅
        for (List<Tile> row : board) {
            merge(row, row.size() - 1);
        }
    }

    public void merge(List<Tile> tiles, int lastIndex) {
        if (lastIndex < 1) return;

        Tile last = tiles.get(lastIndex);
        Tile beforeLast = tiles.get(lastIndex - 1);
        beforeLast.merge(last);
        merge(tiles, lastIndex - 1);
    }
}
