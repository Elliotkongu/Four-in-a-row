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

    public PlayerTile(Point position, Color color, int player) {
        super(position,color);
        this.player = player;
    }


    public int getPlayer() {
        return player;
    }
}
