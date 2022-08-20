package Chapter9;

//Each test case should have an ID and a name.
//Each test case should have one specific thing that it tests.
//Each test case should have an input you supply.
//Each test case should have an output that you expect.
//Most test cases have a starting state.
public class UnitTester {
    public void settingGettingCommonProperty(Unit testedUnit, String propertyName, Object propertyValue) {

        if (propertyName == "unitType") {
            testedUnit.setUnitType((String) propertyValue);
            if (testedUnit.getUnitType().equals(propertyValue)) {
                System.out.println("Test passed");
                System.out.println("Property name: " + propertyName + "  Property value: " + propertyValue);
            } else {
                System.out.println("Test failed");
            }
        }
        if (propertyName == "name") {
            testedUnit.setName((String) propertyValue);
            if (testedUnit.getName().equals(propertyValue)) {
                System.out.println("Test passed");
                System.out.println("Property name: " + propertyName + "  Property value: " + propertyValue);
            } else {
                System.out.println("Test failed");
            }
        }
        if (propertyName == "weapons") {
            testedUnit.addWeapon((Weapon) propertyValue);
            if (testedUnit.getWeapons().size() == 1) {
                System.out.println("Test passed");
                System.out.println("Property name: " + propertyName + "  Property value: " + propertyValue);
            } else {
                System.out.println("Test failed");
            }
        }
        if (propertyName == "ID") {
            if (testedUnit.getId().equals((Integer) propertyValue)) {
                System.out.println("Test passed");
                System.out.println("Property name: " + propertyName + "  Property value: " + propertyValue);
            } else {
                System.out.println("Test failed");
            }
        }
    }

    public void settingGettingUnitSpecificProperty(Unit testedUnit, String propertyName, Object propertyValue) {
        testedUnit.setProperty(propertyName, propertyValue);
        if (testedUnit.getProperty(propertyName) == propertyValue) {
            System.out.println("Test passed");
            System.out.println("Property name: " + propertyName + "  Property value: " + propertyValue);
        } else {
            System.out.println("Test failed");
        }
    }

    public void changingExistingPropertyValue(Unit testedUnit, String propertyName, Object newPropertyValue) {
        testedUnit.setProperty(propertyName, newPropertyValue);
        if (testedUnit.getProperty(propertyName) == newPropertyValue) {
            System.out.println("Test passed");
            System.out.println("Property name: " + propertyName + "  new Property value: " + newPropertyValue);
        } else {
            System.out.println("Test failed");
        }
    }

    public void gettingNonExistentProperty(Unit testedUnit, String propertyName) {
        try {
            testedUnit.getProperty(propertyName);
        } catch (RuntimeException e) {
            System.out.println("Test passed");
        }
    }

    public void addUnit(Group testedGroup, Unit testedUnit) {
        testedGroup.addUnit(testedUnit);
        try {
            testedGroup.unitExist(testedUnit.getId());
            System.out.println("Test passed");
        } catch (RuntimeException e) {
            System.out.println("Test failed");
        }
    }

    public void removeUnit(Group testedGroup, Unit testedUnit) {
        // to handle case of removing unit that is not in the group
        try {
            testedGroup.removeUnit(testedUnit);
        } catch (RuntimeException e) {
            System.out.println("Test passed");
            System.out.println(e);
            return;
        }
        // to check if the unit is removed from the group
        try {
            testedGroup.unitExist(testedUnit.getId());
            System.out.println("Test failed");
        } catch (RuntimeException e) {
            System.out.println("Test passed");
        }
    }

    public static void main(String[] args) {
        UnitTester tester = new UnitTester();
        Unit testedUnit = new Unit(1);
        tester.settingGettingCommonProperty(testedUnit, "unitType", "infantry");
        tester.settingGettingCommonProperty(testedUnit, "name", "John");
        tester.settingGettingCommonProperty(testedUnit, "weapons", new Weapon());
        tester.settingGettingCommonProperty(testedUnit, "ID", 1);
        tester.settingGettingUnitSpecificProperty(testedUnit, "hitPoints", "100");
        tester.changingExistingPropertyValue(testedUnit, "hitPoints", "200");
        tester.gettingNonExistentProperty(testedUnit, "strength");
        // ------------------------------------------------------------------------------
        System.out.println("-------------------------------");
        Unit unit1 = new Unit(1);
        Unit unit2 = new Unit(2);
        Unit unit3 = new Unit(3);
        Group group1 = new Group(1);
        tester.addUnit(group1, unit1);// add to empty group
        tester.addUnit(group1, unit2);// add to non-empty group
        tester.removeUnit(group1, unit3);// remove non existing unit from non-empty group-->throw exception
        tester.removeUnit(group1, unit1);// remove existing unit from non-empty group
        tester.removeUnit(group1, unit2);// remove existing unit from empty group
        tester.removeUnit(group1, unit1);// remove non existing unit from empty group-->throw exception
    }
}
