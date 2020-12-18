package com.lme.martianrobots.model;

import java.util.Map;

public interface IGridObject {

    GridObjectPosition getGridObjectPosition();
    void setGridObjectPosition(GridObjectPosition position);
    void executeInstruction(int xBoundary, int yBoundary);
}
