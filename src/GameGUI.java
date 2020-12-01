import Tiles.EmptyTile;
import Tiles.Tile;

import javax.swing.*;
import java.util.List;
import java.awt.*;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-30
 * Time: 15:49
 * Project: Four-in-a-row
 * Copyright: MIT
 */
public class GameGUI extends JFrame {

    JPanel southPanel = new JPanel();
    JPanel gridPanel = new JPanel();
    JPanel southWestPanel = new JPanel();
    JPanel southEastPanel = new JPanel();
    JPanel southCenterPanel = new JPanel();

    public JLabel scoreLabel = new JLabel();
    public JLabel infoLabel = new JLabel();
    public JLabel p1ScoreCounter = new JLabel();
    public JLabel p2ScoreCounter = new JLabel();

    public JButton showRulesButton = new JButton("Spelregler");
    public JButton undoButton = new JButton("Ångra");

    public ButtonGroup p1ColorButtongroup = new ButtonGroup();
    public ButtonGroup p2ColorButtongroup = new ButtonGroup();

    public JRadioButton p1Color1 = new JRadioButton("Rött");
    public JRadioButton p1Color2 = new JRadioButton("Blå");
    public JRadioButton p1Color3 = new JRadioButton("Lila");
    public JRadioButton p2Color1 = new JRadioButton("Gult");
    public JRadioButton p2Color2 = new JRadioButton("Rosa");
    public JRadioButton p2Color3 = new JRadioButton("Grönt");

    private Color gridColor = new Color(137,207,240);

    public GameGUI(List<List<Tile>> tileList){

        setLayout(new BorderLayout());
        southPanel.setLayout(new BorderLayout());
        gridPanel.setLayout(new GridLayout(6,7,2,2));



        gridPanel.setBackground(gridColor);
        southEastPanel.setBackground(gridColor);
        southWestPanel.setBackground(gridColor);
        southCenterPanel.setBackground(gridColor);

        add(southPanel, BorderLayout.SOUTH);
        add(gridPanel, BorderLayout.CENTER);

        p1ColorButtongroup.add(p1Color1);
        p1ColorButtongroup.add(p1Color2);
        p1ColorButtongroup.add(p1Color3);
        p2ColorButtongroup.add(p2Color1);
        p2ColorButtongroup.add(p2Color2);
        p2ColorButtongroup.add(p2Color3);



        southPanel.add(southWestPanel, BorderLayout.WEST);
        southPanel.add(southEastPanel, BorderLayout.EAST);
        southPanel.add(southCenterPanel, BorderLayout.CENTER);

        southWestPanel.add(p1Color1);
        southWestPanel.add(p1Color2);
        southWestPanel.add(p1Color3);
        southEastPanel.add(p2Color1);
        southEastPanel.add(p2Color2);
        southEastPanel.add(p2Color3);

        southCenterPanel.add(showRulesButton);
        southCenterPanel.add(undoButton);

        initiateGameGrid(tileList);

        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initiateGameGrid(List<List<Tile>> tileList) {
        for (List<Tile> tileColumn :tileList) {
            for (Tile tile:tileColumn) {
                gridPanel.add(tile);
            }
        }

    }

    public void refreshGameGrid (){

    }

}
