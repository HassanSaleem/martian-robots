package com.lme.martianrobots.model;
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
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

}
