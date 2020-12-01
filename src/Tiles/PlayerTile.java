package Tiles;

import java.awt.*;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-30
 * Time: 15:50
 * Project: Four-in-a-row
 * Copyright: MIT
 */
public class PlayerTile extends Tile{

    private int player;
    private Color color;

    public PlayerTile(Point position, Color color, int player) {
        super(position);
        this.player = player;
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillOval(0,0,g.getClipBounds().width,g.getClipBounds().height);
    }


    public int getPlayer() {
        return player;
    }
}
