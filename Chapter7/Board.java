package Chapter7;

import java.util.List;
import java.util.ArrayList;

//* Scenario: 
//I’d like to think so. I help in gathering requirements, in being sure your use cases are
//complete, but also in architecture, helping you //* reduce risk and reduce the chaos and confusion
//around what a particular module or piece of code does.
//------------------------
//scenario e.g.
//Game designer creates board with a height and width.
//Player 2 moves tanks onto (4, 5).
//Player 2 moves army onto (4, 5).
//Player 1 moves artillery onto (4, 5).
//Game requests units from (4, 5).
//Player 1 battles Player 2
//Game requests terrain at (4, 5).
//Player 2’s units win the battle.
//Player 1’s units are removed from (4, 5).
//Player 1 moves subs to (2, 2).
//Game requests terrain at (2, 2).
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