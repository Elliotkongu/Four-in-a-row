import Tiles.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private final int ROWS = 6;
    private final int COLUMNS = 7;
    public List<List<Tile>> tileList;

    public GameBoard(){
        this.tileList = new ArrayList<List<Tile>>();
    }

    public void placeTile(int player, Point point){}
    public void calculateVictory(){}
    public void changeTileColors(int player, Color color){}
}
