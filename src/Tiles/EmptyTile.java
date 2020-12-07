package Tiles;

import java.awt.*;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-30
 * Time: 15:49
 * Project: Four-in-a-row
 * Copyright: MIT
 */
public class EmptyTile extends Tile {
    public EmptyTile(Point position) {
        super(position);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(0,0,g.getClipBounds().width,g.getClipBounds().height);
    }


}
