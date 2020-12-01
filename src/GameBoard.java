import Tiles.EmptyTile;
import Tiles.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private final int ROWS = 6;
    private final int COLUMNS = 7;

    private GameGUI gameGUI;

    public List<List<Tile>> tileList;


    public GameBoard(){
        initiateTileList();
        initiateGUI();
    }

    private void initiateGUI() {
        gameGUI = new GameGUI(tileList);
    }

    private void initiateTileList() {
        tileList = new ArrayList<List<Tile>>();

        for(int i = 0; i < ROWS; i++){
            tileList.add(new ArrayList<>());
            for(int j = 0; j < COLUMNS; j++){
                tileList.get(i).add(new EmptyTile(new Point(j,i), Color.BLACK));
            }
        }
    }

    public void placeTile(int player, Point point){}

    public void calculateVictory(){}

    public void changeTileColors(int player, Color color){}

    public static void main(String[] args) {
        GameBoard gb = new GameBoard();
    }

}
