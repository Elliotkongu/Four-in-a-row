import Tiles.EmptyTile;
import Tiles.Tile;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GameBoard extends MouseAdapter {

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
                Tile emptyTile = new EmptyTile(new Point(j,i), Color.BLACK);
                emptyTile.addMouseListener(this);
                tileList.get(i).add(emptyTile);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() instanceof EmptyTile){
            System.out.println(((EmptyTile) e.getSource()).getPosition());

        }
    }

    public void placeTile(int player, Point point){}

    public void calculateVictory(){}

    public void changeTileColors(int player, Color color){}

    public static void main(String[] args) {
        GameBoard gb = new GameBoard();
    }

}
