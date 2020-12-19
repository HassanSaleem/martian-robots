package com.lme.martianrobots.model;

import com.lme.martianrobots.utility.DirectionMap;
import java.util.AbstractMap;
import java.util.List;
import java.util.UUID;

public class Robot implements IGridObject {

    GridObjectPosition gridPosition;
    String instructions;
    UUID uuid;

    public Robot(){
        uuid = UUID.randomUUID();
    }

    public Robot(GridObjectPosition position, String instructions){

        this();
        this.gridPosition = position;
        this.instructions = instructions;
    }

    @Override
    public GridObjectPosition getGridPosition() {
        return gridPosition;
    }

    @Override
    public void setGridPosition(GridObjectPosition position) {
        gridPosition = position;
    }

    @Override
    public String getInstructions() {
        return instructions;
    }

    @Override
    public void setInstrunctions(String instrunctions) {
        this.instructions = instrunctions;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

}
