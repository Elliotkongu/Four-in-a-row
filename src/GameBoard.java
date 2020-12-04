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


    public GameBoard() {
        initiateTileList();
        initiateGUI();
    }

    private void initiateGUI() {
        gameGUI = new GameGUI(tileList, this);
    }

    private void initiateTileList() {
        tileList = new ArrayList<List<Tile>>();

        for (int i = 0; i < ROWS; i++) {
            tileList.add(new ArrayList<>());
            for (int j = 0; j < COLUMNS; j++) {
                Tile emptyTile = new EmptyTile(new Point(j, i), Color.BLACK);
                emptyTile.addMouseListener(this);
                tileList.get(i).add(emptyTile);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() instanceof EmptyTile) {
            System.out.println(((EmptyTile) e.getSource()).getPosition());

            placeTile(currentPlayer, ((EmptyTile) e.getSource()).getPosition());

        }
    }

    public void placeTile(int player, Point point) {
        Tile tile;
        if (player == 0) {
            tile = new PlayerTile(point, player1Color, player);
        } else {
            tile = new PlayerTile(point, player2Color, player);
        }


        for (int i = ROWS - 1; i >= 0; i--) {
            if (tileList.get(i).get(point.x) instanceof EmptyTile) {
                tileList.get(i).set(point.x, tile);
                break;
            }
        }
        if (player == 0) {
            SwingUtilities.invokeLater(() -> gameGUI.refreshGameGrid(tileList, player, player1Color));
            calculateVictory(currentPlayer);
            currentPlayer = 1;
        } else {
            SwingUtilities.invokeLater(() -> gameGUI.refreshGameGrid(tileList, player, player2Color));
            calculateVictory(currentPlayer);
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
            player2Color = new Color(245, 195, 194);
        } else if (e.getSource() == gameGUI.p2Color3) {
            player2Color = new Color(134, 194, 156);
        }
    }

    public void calculateVictory(int currentPlayer) {

        //horizontal
        if (calculateHorizontal(currentPlayer) || calculateVertical(currentPlayer)
                || calculateDiagonalSE(currentPlayer) || calculateDiagonalSW(currentPlayer)) {

        }
    }

    private boolean calculateHorizontal(int player) {
        int consecutiveTiles;
        for (int x = 0; x < COLUMNS - 3; x++) {
            for (int y = 0; y < ROWS; y++) {
                consecutiveTiles = 0;
                if (tileList.get(y).get(x) instanceof PlayerTile && ((PlayerTile) tileList.get(y).get(x)).getPlayer() == player) {
                    consecutiveTiles++;
                    for (int i = 1; i < 4; i++) {
                        if (tileList.get(y).get(x + i) instanceof PlayerTile) {
                            if (((PlayerTile) tileList.get(y).get(x + i)).getPlayer() == player) {
                                consecutiveTiles++;
                            } else {
                                consecutiveTiles = 0;
                                break;
                            }
                        } else {
                            consecutiveTiles = 0;
                            break;
                        }
                    }
                    if (consecutiveTiles == 4) {
                        //win
                        System.out.println(player + " vann horisontellt!");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean calculateVertical(int player) {
        int consecutiveTiles;
        for (int x = 0; x < COLUMNS; x++) {
            for (int y = 0; y < ROWS - 3; y++) {
                consecutiveTiles = 0;
                if (tileList.get(y).get(x) instanceof PlayerTile && ((PlayerTile) tileList.get(y).get(x)).getPlayer() == player) {

                    consecutiveTiles++;
                    for (int i = 1; i < 4; i++) {
                        if (tileList.get(y + i).get(x) instanceof PlayerTile) {
                            if (((PlayerTile) tileList.get(y + i).get(x)).getPlayer() == player) {
                                consecutiveTiles++;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (consecutiveTiles == 4) {
                        //win
                        System.out.println(player + " vann vertikalt!");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean calculateDiagonalSE(int player) {
        int consecutiveTiles;
        for (int x = 0; x < COLUMNS - 3; x++) {
            for (int y = 0; y < ROWS - 3; y++) {
                consecutiveTiles = 0;
                if (tileList.get(y).get(x) instanceof PlayerTile && ((PlayerTile) tileList.get(y).get(x)).getPlayer() == player) {

                    consecutiveTiles++;
                    for (int i = 1; i < 4; i++) {
                        if (tileList.get(y + i).get(x + i) instanceof PlayerTile) {
                            if (((PlayerTile) tileList.get(y + i).get(x + i)).getPlayer() == player) {
                                consecutiveTiles++;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (consecutiveTiles == 4) {
                        //win
                        System.out.println(player + " vann SE!");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean calculateDiagonalSW(int player) {
        int consecutiveTiles;
        for (int x = 3; x < COLUMNS; x++) {
            for (int y = 0; y < ROWS - 3; y++) {
                consecutiveTiles = 0;
                if (tileList.get(y).get(x) instanceof PlayerTile && ((PlayerTile) tileList.get(y).get(x)).getPlayer() == player) {

                    consecutiveTiles++;
                    for (int i = 1; i < 4; i++) {
                        if (tileList.get(y + i).get(x - i) instanceof PlayerTile) {
                            if (((PlayerTile) tileList.get(y + i).get(x - i)).getPlayer() == player) {
                                consecutiveTiles++;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (consecutiveTiles == 4) {
                        //win
                        System.out.println(player + " vann SW!");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GameBoard gb = new GameBoard();
    }

}

