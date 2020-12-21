package com.lme.martianrobots.model;

public class GridObjectPosition {

    private Coordinates startCoordinates;
    private Coordinates endCoordinates;
    private Coordinates lastKnownCoordiantes;
    private Orientation orientation;
    private Boolean isLost = false;
    private String stringFormat = "";

    public GridObjectPosition(){
    }

    public GridObjectPosition(Coordinates coordinates, Orientation orientation) {
        this.startCoordinates = coordinates;
        this.endCoordinates = this.startCoordinates;
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
        if (endCoordinates == null){
            return startCoordinates;
        }
        return endCoordinates;
    }

    public void setEndCoordinates(Coordinates endCoordinates) {
        this.endCoordinates = endCoordinates;
    }

    public Coordinates getLastKnownCoordiantes() {
        return lastKnownCoordiantes;
    }

    public Coordinates getNextCoordinates(Coordinates coordinates){
        Coordinates nxtCoordinates = new Coordinates();

        if (this.endCoordinates == null){
            this.endCoordinates = new Coordinates(startCoordinates.getxPosition(), startCoordinates.getyPosition());
        }

        nxtCoordinates.setxPosition(this.endCoordinates.getxPosition() + coordinates.getxPosition());
        nxtCoordinates.setyPosition(this.endCoordinates.getyPosition() + coordinates.getyPosition());

        return nxtCoordinates;
    }

    public void move(Coordinates coordinates) {

        if (this.isLost && this.lastKnownCoordiantes==null){
            this.lastKnownCoordiantes = new Coordinates(endCoordinates.getxPosition(),endCoordinates.getyPosition());
        }

        this.endCoordinates.setyPosition(coordinates.getyPosition());
        this.endCoordinates.setxPosition(coordinates.getxPosition());
    }

    public String getStringFormat() {
        if (this.startCoordinates == null && this.endCoordinates == null && this.lastKnownCoordiantes == null){
            return "";
        }

        if (this.endCoordinates == null && this.lastKnownCoordiantes == null){
            return String.format("%s %s %s", this.startCoordinates.getxPosition(), this.startCoordinates.getyPosition(), this.orientation);
        }
        this.stringFormat = this.isLost ? String.format("%s %s %s LOST", this.lastKnownCoordiantes.getxPosition(), this.lastKnownCoordiantes.getyPosition(), this.orientation) :
                String.format("%s %s %s", this.getEndCoordinates().getxPosition(), this.getEndCoordinates().getyPosition(), this.orientation);
        return stringFormat;
    }


}
