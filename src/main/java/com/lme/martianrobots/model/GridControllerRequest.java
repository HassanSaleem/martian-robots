package com.lme.martianrobots.model;

import java.util.List;

public class GridControllerRequest {
    private List<Robot> robots;
    private Coordinates coordinates;

    public List<Robot> getRobots() {
        return robots;
    }

    public void setRobots(List<Robot> robots) {
        this.robots = robots;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
