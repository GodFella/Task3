/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task3.model;

import java.awt.Color;
import java.lang.reflect.Field;

/**
 * Class-entity Flower
 *
 * @author Gleb
 */
public class Flower {
    
    // names of xml elements
    public static final String ORANGERIE = "orangerie";
    public static final String FLOWER = "flower";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String SOIL = "soil";
    public static final String ORIGIN = "origin";
    public static final String VISUAL_PARAMETERS = "visual_parameters";
    public static final String STEM_COLOUR = "stem_colouur";
    public static final String LEAVES_COLOUR = "leaves_colour";
    public static final String AVERAGE_SIZE = "average_size";
    public static final String GROWING_TIPS = "growing_tips";
    public static final String TEMPERATURE = "temperature";
    public static final String LIGHT = "light";
    public static final String WATERING = "watering";
    public static final String MULTIPLYING = "multiplying";

    /**
     * Id of the flower
     */
    private int id;
    /**
     * Name of the flower
     */
    private String name;
    /**
     * THe origin of the flower
     */
    private String origin;

    public enum SoilType {

        PODSOL, GROUND, TORF_PODSOL
    }
    /**
     * Preferrable soil for the flower
     */
    private SoilType soil;
    /**
     * Colour of the stem
     */
    private String stemColour;
    /**
     * Colour of leaves
     */
    private String leavesColour;
    /**
     * Average size of the flower in inches
     */
    private double averageSize;
    /**
     * temperature in centigrade
     */
    private int temperature;
    /**
     * prefferable light where shade - 0, bright light - 10
     */
    private int light;
    /**
     * Water in mililiters per week
     */
    private int watering;

    public enum MyltiplyingType {

        LEAVES, CUTTING, SEEDS
    }
    /**
     * type of myltiplying
     */
    private MyltiplyingType myltiplying;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoil(String soil) {
        if (soil.equalsIgnoreCase("podsol")) {
            this.soil = SoilType.PODSOL;
        } else if (soil.equalsIgnoreCase("ground")) {
            this.soil = SoilType.GROUND;
        } else if (soil.equalsIgnoreCase("torf podsol")) {
            this.soil = SoilType.TORF_PODSOL;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setMyltiplying(String myltiplying) {
        if (myltiplying.equalsIgnoreCase("Seeds")) {
            this.myltiplying = MyltiplyingType.SEEDS;
        } else if (myltiplying.equalsIgnoreCase("Cutting")) {
            this.myltiplying = MyltiplyingType.CUTTING;
        } else if (myltiplying.equalsIgnoreCase("Leaves")) {
            this.myltiplying = MyltiplyingType.LEAVES;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setStemColour(String color) {
        this.stemColour = color;
    }

    public void setLeavesColour(String color) {
        this.leavesColour = color;
    }

    public void setAverageSize(double size) {
        this.averageSize = size;
    }

    public void setAverageSize(String size, String unit) {
        if (unit.equals("centimetr")) {
            setAverageSize(Double.parseDouble(size) * 2 / 5);
        } else if (unit.equals("inch")) {
            setAverageSize(Double.parseDouble(size));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
    }

    public void setTemperature(String temp, String unit) {
        if (unit.equals("farenheit")) {
            setTemperature((Integer.parseInt(temp) - 32) * 5 / 9);
        } else if (unit.equals("celsius")) {
            setTemperature(Integer.parseInt(temp));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setLight(int light) {
        this.light = light;
    }

    public void setWatering(int watering) {
        this.watering = watering;
    }

    public void setWatering(String watering, String unit) {
        if (unit.equals("ounce")) {
            setWatering(Integer.parseInt(watering) * 29);
        } else if (unit.equals("?")) {
            setWatering(Integer.parseInt(watering));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public SoilType getSoil() {
        return soil;
    }

    public String getStemColour() {
        return stemColour;
    }

    public String getLeavesColour() {
        return leavesColour;
    }

    public double getAverageSize() {
        return averageSize;
    }

    public int getLight() {
        return light;
    }

    public int getWatering() {
        return watering;
    }

    public int getTemperature() {
        return temperature;
    }

    public MyltiplyingType getMyltiplying() {
        return myltiplying;
    }

    public int getId() {
        return id;
    }
}
