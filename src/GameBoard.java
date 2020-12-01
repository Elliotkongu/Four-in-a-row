import Tiles.EmptyTile;
import Tiles.PlayerTile;
import Tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GameBoard extends MouseAdapter {

    private final int ROWS = 6;
    private final int COLUMNS = 7;

    private GameGUI gameGUI;
    private int currentPlayer = 0;

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

            placeTile(currentPlayer,((EmptyTile) e.getSource()).getPosition());

        }
    }

    public void placeTile(int player, Point point){

        Color color = Color.WHITE;

        if(player == 0){
            if(gameGUI.p1Color1.isSelected()){
                color = Color.red;
            }else if(gameGUI.p1Color2.isSelected()){
                color = Color.blue;
            }else if(gameGUI.p1Color3.isSelected()){
                color = Color.magenta;
            }
        }else{
            if(gameGUI.p2Color1.isSelected()){
                color = Color.yellow;
            }else if(gameGUI.p2Color2.isSelected()){
                color = Color.pink;
            }else if(gameGUI.p2Color3.isSelected()){
                color = Color.green;
            }
        }

        Tile tile = new PlayerTile(point,color,player);

        for(int i = COLUMNS - 1; i >= 0; i--) {
            if(tileList.get(i).get(point.y) instanceof EmptyTile){
                tileList.get(i).set(point.y,tile);
                break;
            }
        }
        SwingUtilities.invokeLater(() -> gameGUI.refreshGameGrid(tileList));
    }

    public void calculateVictory(){}

    public void changeTileColors(int player, Color color){}

    public static void main(String[] args) {
        GameBoard gb = new GameBoard();
    }

}
