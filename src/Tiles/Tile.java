package Tiles;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-30
 * Time: 15:47
 * Project: Four-in-a-row
 * Copyright: MIT
 */
public abstract class Tile extends JPanel {
    private Point position;

    public Tile(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

}
