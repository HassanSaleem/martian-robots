package com.lme.martianrobots.model;

public enum Orientation {
    North("N"),
    East("E"),
    South("S"),
    West("W");

    private String code;

    Orientation(String n) {
        code=n;
    }

    @Override
    public String toString() {
        return code;
    }
}
