package com.lme.martianrobots.model;

public class Coordinates {

    int xPosition;
    int yPosition;
    Boolean isIgnored;

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public Boolean getIgnored() {
        return isIgnored;
    }

    public void setIgnored(Boolean ignored) {
        isIgnored = ignored;
    }
}
