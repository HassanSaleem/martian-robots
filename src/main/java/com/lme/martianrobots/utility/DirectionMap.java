package com.lme.martianrobots.utility;

import com.lme.martianrobots.model.Coordinates;
import com.lme.martianrobots.model.Orientation;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class DirectionMap {

    static Map<String, AbstractMap.SimpleEntry<Coordinates, Orientation>> directionMap = new HashMap();

    static {
        directionMap.put("NR", new AbstractMap.SimpleEntry<>(new Coordinates(0,0), Orientation.East));
        directionMap.put("NL", new AbstractMap.SimpleEntry<>(new Coordinates(0,0), Orientation.West));
        directionMap.put("NF", new AbstractMap.SimpleEntry<>(new Coordinates(0,1), Orientation.North));

        directionMap.put("SR", new AbstractMap.SimpleEntry<>(new Coordinates(0,0), Orientation.West));
        directionMap.put("SL", new AbstractMap.SimpleEntry<>(new Coordinates(0,0), Orientation.East));
        directionMap.put("SF", new AbstractMap.SimpleEntry<>(new Coordinates(0,-1), Orientation.South));

        directionMap.put("WR", new AbstractMap.SimpleEntry<>(new Coordinates(0,0), Orientation.North));
        directionMap.put("WL", new AbstractMap.SimpleEntry<>(new Coordinates(0,0), Orientation.South));
        directionMap.put("WF", new AbstractMap.SimpleEntry<>(new Coordinates(-1,0), Orientation.West));

        directionMap.put("ER", new AbstractMap.SimpleEntry<>(new Coordinates(0,0), Orientation.South));
        directionMap.put("EL", new AbstractMap.SimpleEntry<>(new Coordinates(0,0), Orientation.North));
        directionMap.put("EF", new AbstractMap.SimpleEntry<>(new Coordinates(1,0), Orientation.East));
    }

    public static Map<String, AbstractMap.SimpleEntry<Coordinates, Orientation>> getDirectionMap(){
        return directionMap;
    }
}
