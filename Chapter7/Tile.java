package Chapter7;

import java.util.List;

public class Tile {
    private List units;

    public Tile() {
    }

    public List getUnits() {
        return units;
    }

    public void addUnit(Unit _unit) {
        this.units.add(_unit);
    }

    public void removeUnit(Unit _unit) {
        this.units.remove(_unit);
    }

    public void removeAllUnits() {
        this.units.clear();
    }
}
