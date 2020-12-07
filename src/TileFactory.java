import Tiles.EmptyTile;
import Tiles.PlayerTile;
import Tiles.Tile;

import java.awt.*;
import java.awt.event.MouseAdapter;

/**
 * Created by Henrik Elofsson
 * Date: 2020-12-07
 * Time: 15:32
 * Project: Four-in-a-row
 * Copyright: MIT
 */

public class TileFactory {
    private MouseAdapter mouseAdapter;

    public TileFactory(MouseAdapter ma){
        this.mouseAdapter = ma;
    }

    public Tile createEmptyTile(Point point){
        Tile emptyTile = new EmptyTile(point);
        emptyTile.addMouseListener(mouseAdapter);
        return emptyTile;
    }

    public Tile createPlayerTile(Point point, Color color, int player){
        return new PlayerTile(point, color, player);
    }


}
