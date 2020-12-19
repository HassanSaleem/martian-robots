package com.lme.martianrobots.model;

import java.util.UUID;

public interface IGridObject {

    GridObjectPosition getGridPosition();
    void setGridPosition(GridObjectPosition position);

    String getInstructions();
    void setInstrunctions(String instrunctions);

    UUID getUuid();
}
