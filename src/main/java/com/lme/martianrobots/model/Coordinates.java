package com.lme.martianrobots.model;

public class Coordinates {

    private int xPosition;
    private int yPosition;

    public Coordinates(){}

    public Coordinates(int x, int y){
        xPosition = x;
        yPosition = y;
    }

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


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinates other = (Coordinates) obj;
        return this.xPosition == other.xPosition && this.yPosition == other.yPosition;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + xPosition;
        result = prime * result + yPosition;
        return result;
    }
}
