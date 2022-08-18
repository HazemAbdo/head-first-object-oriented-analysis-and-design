package Chapter7;

import java.util.Map;

//*MY JOURNEY FROM ALL ARE DIFFERENT TO ALL ARE THE SAME
//First:There really wasn’t anything common between the different
//units. They all have properties, but the properties are different
//for each unit. So nothing gets added to the Unit base class
//---------------------------Then:commonality analysis-------------------------------
//* Commonality analysis: the path to flexible software
//Vola:This time, we’ve made Unit a lot more generic. It supports a unit type, and a Map of name/value properties.
//------------------------------------------------------------------------------------
// Number of unit types|Number of unit classes - Solution #1|Solution #2(Map)   
// 3|*****************|4***********************************|1
// 10|****************|11**********************************|1
// 25|****************|26**********************************|1
// 50|****************|51**********************************|1
// 100|***************|101*********************************|1
public class Unit {
    String unitType;
    Map<String, Object> properties;

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public Object getProperty(String propertyName) {
        return properties.get(propertyName);
    }

    public void setProperty(STRING propertyName, Object propertyValue) {
        properties.put(propertyName, propertyValue);
    }

}
