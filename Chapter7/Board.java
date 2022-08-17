package Chapter7;

import java.util.List;
import java.util.ArrayList;

public class Board {
    private int width, height;
    private List tiles;

    public Board() {
    }

    public Board(int _width, int _height) {
        this.width = _width;
        this.height = _height;
        tiles = new ArrayList(width);
        for (int i = 0; i < width; i++) {
            tiles.add(i, new ArrayList(height));
            for (int j = 0; j < height; j++) {
                ((ArrayList) tiles.get(i)).add(j, new Tile());
            }
        }
    }

    public Tile getTile(int _x, int _y) {
        return (Tile) ((ArrayList) tiles.get(_x)).get(_y);
    }

    public void AddUnit(Unit _unit, int X, int Y) {
        Tile targetTile = getTile(X, Y);
        targetTile.addUnit(_unit);
    }

    public void RemoveUnit(Unit _unit, int X, int Y) {
        Tile targetTile = getTile(X, Y);
        targetTile.removeUnit(_unit);
    }

    public void RemoveUnits(int X, int Y) {
        Tile targetTile = getTile(X, Y);
        targetTile.removeAllUnits();
    }

    public List getUnits(int X, int Y) {
        Tile targetTile = getTile(X, Y);
        return targetTile.getUnits();
    }

}