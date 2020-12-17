package com.lme.martianrobots.services;

import com.lme.martianrobots.model.Coordinates;
import com.lme.martianrobots.model.GridObjectInstructions;
import com.lme.martianrobots.model.IGridObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GridService {

    Map<Coordinates, IGridObject> grid;

    public Map<Coordinates, IGridObject> createGridWithRobots(int upperRightCoordinate, List<GridObjectInstructions> instructions){
        return grid;
    }
}
