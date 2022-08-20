package Chapter9;

import java.util.Map;
import java.util.HashMap;

public class Group {
    private Integer ID;
    private Map<Integer, Unit> units;

    public Group(Integer iD) {
        ID = iD;
    }

    public Integer getID() {
        return ID;
    }

    public Map<Integer, Unit> getUnits() {
        if (units == null) {
            throw new RuntimeException("No units in group");
        }
        return units;
    }

    public void unitExist(int unitID) {
        if (!units.containsKey(unitID)) {
            throw new RuntimeException("Unit does not exist");
        }
    }

    public void addUnit(Unit unit) {
        if (this.units == null) {
            this.units = new HashMap<Integer, Unit>();
        }
        this.units.put(unit.getId(), unit);
    }

    public void removeUnit(Unit unit) {
        if (this.units == null) {
            throw new RuntimeException("No units in group");
        }
        if (!this.units.containsKey(unit.getId())) {
            throw new RuntimeException("Unit does not exist");
        }
        this.units.remove(unit.getId());
    }

}
