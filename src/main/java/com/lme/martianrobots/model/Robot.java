package com.lme.martianrobots.model;

public class Robot {

    GridObjectPosition gridPosition;
    String instructions;
    int uuid;

    public Robot(){
    }

    public Robot(int id, GridObjectPosition position, String instructions){
        this.uuid = id;
        this.gridPosition = position;
        this.instructions = instructions;
    }

    public GridObjectPosition getGridPosition() {
        return gridPosition;
    }

    public void setGridPosition(GridObjectPosition position) {
        gridPosition = position;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }
}
