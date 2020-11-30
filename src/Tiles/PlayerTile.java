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
    private Color color;
    private int player;

    public PlayerTile(Point position, Color color, int player) {
        super(position);
        this.color = color;
        this.player = player;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPlayer() {
        return player;
    }
}
