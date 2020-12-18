package com.lme.martianrobots.model;

import com.lme.martianrobots.utility.DirectionMap;
import java.util.AbstractMap;

public class Robot implements IGridObject {

    GridObjectPosition gridPosition;
    String instructions;

    public Robot(GridObjectPosition position, String instructions){
        this.gridPosition = position;
        this.instructions = instructions;
    }

    @Override
    public GridObjectPosition getGridObjectPosition() {
        return gridPosition;
    }

    @Override
    public void setGridObjectPosition(GridObjectPosition position) {
        gridPosition = position;
    }

    @Override
    public void executeInstruction(int xBoundary, int yBoundary) {
        char[] steps = instructions.toCharArray();
        for (char step:steps
        ) {
            if (gridPosition.getIsLost()) continue;
            Orientation orientation =  gridPosition.getOrientation();
            AbstractMap.SimpleEntry<Coordinates,Orientation> translatedStep = DirectionMap.getDirectionMap().get(String.format("%s%s", orientation.toString(),step));
            gridPosition.move(translatedStep.getKey());
            gridPosition.setOrientation(translatedStep.getValue());

            if ((gridPosition.getEndCoordinates().getxPosition() > xBoundary
                    || gridPosition.getEndCoordinates().getyPosition()> yBoundary)
                    || gridPosition.getEndCoordinates().getyPosition() < 0
                    || gridPosition.getEndCoordinates().getxPosition() < 0){

                //mark grid object lost
                gridPosition.setIsLost(true);
            }
        }
    }


}
