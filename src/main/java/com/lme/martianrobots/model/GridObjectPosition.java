package com.lme.martianrobots.model;

public class GridObjectPosition {

    private Coordinates startCoordinates;
    private Coordinates endCoordinates;
    private Coordinates lastKnownCoordiantes;
    private Orientation orientation;
    private Boolean isLost = false;

    public GridObjectPosition(){

    }
    public GridObjectPosition(Coordinates coordinates, Orientation orientation) {
        this.startCoordinates = coordinates;
        this.orientation = orientation;
    }
    public Coordinates getStartCoordinates() {
        return startCoordinates;
    }

    public void setStartCoordinates(Coordinates startCoordinates) {
        this.startCoordinates = startCoordinates;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Boolean getIsLost() {
        return isLost;
    }

    public void setIsLost(Boolean lost) {
        isLost = lost;
    }

    public Coordinates getEndCoordinates() {
        return endCoordinates;
    }

    public void setEndCoordinates(Coordinates endCoordinates) {
        this.endCoordinates = endCoordinates;
    }

    public Coordinates getLastKnownCoordiantes() {
        return lastKnownCoordiantes;
    }

    public void move(Coordinates coordinates) {

        if (this.isLost){
            return;
        }

        if (this.endCoordinates == null){
            this.endCoordinates = new Coordinates(startCoordinates.getxPosition(), startCoordinates.getyPosition());
        }

        this.lastKnownCoordiantes = new Coordinates(endCoordinates.getxPosition(),endCoordinates.getyPosition());
        this.endCoordinates.setyPosition(this.endCoordinates.getyPosition() + coordinates.getyPosition());
        this.endCoordinates.setxPosition(this.endCoordinates.getxPosition() + coordinates.getxPosition());
    }
}
