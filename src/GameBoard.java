import Tiles.EmptyTile;
import Tiles.PlayerTile;
import Tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GameBoard extends MouseAdapter implements ActionListener {

    private final int ROWS = 6;
    private final int COLUMNS = 7;

    private GameGUI gameGUI;
    private int currentPlayer = 0;
    private Color player1Color = Color.WHITE;
    private Color player2Color = Color.WHITE;

    public List<List<Tile>> tileList;


    public GameBoard(){
        initiateTileList();
        initiateGUI();
    }

    private void initiateGUI() {
        gameGUI = new GameGUI(tileList, this);
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
        Tile tile;
        if (player == 0) {
            tile = new PlayerTile(point,player1Color,player);
        } else {
            tile = new PlayerTile(point,player2Color,player);
        }


        for(int i = ROWS - 1; i >= 0; i--) {
            if(tileList.get(i).get(point.x) instanceof EmptyTile){
                tileList.get(i).set(point.x,tile);
                break;
            }
        }
        if (player == 0) {
            SwingUtilities.invokeLater(() -> gameGUI.refreshGameGrid(tileList, player, player1Color));
            currentPlayer = 1;
        } else {
            SwingUtilities.invokeLater(() -> gameGUI.refreshGameGrid(tileList, player, player2Color));
            currentPlayer = 0;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gameGUI.showRulesButton) {
            System.out.println("Rules have been shown");
        } else if (e.getSource() == gameGUI.undoButton) {
            System.out.println("Undo");
        } else if (e.getSource() == gameGUI.p1Color1) {
            player1Color = new Color(204, 6, 5);
        } else if (e.getSource() == gameGUI.p1Color2) {
            player1Color = new Color(0, 128, 255);
        } else if (e.getSource() == gameGUI.p1Color3) {
            player1Color = new Color(152, 68, 158);
        } else if (e.getSource() == gameGUI.p2Color1) {
            player2Color = new Color(255, 255, 77);
        } else if (e.getSource() == gameGUI.p2Color2) {
            player2Color = new Color(245,195,194);
        } else if (e.getSource() == gameGUI.p2Color3) {
            player2Color = new Color(134,194,156);
        }
    }

    public void calculateVictory(){}

    public void changeTileColors(int player, Color color){}

    public static void main(String[] args) {
        GameBoard gb = new GameBoard();
    }

}

