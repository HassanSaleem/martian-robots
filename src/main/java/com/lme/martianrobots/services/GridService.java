package com.lme.martianrobots.services;

import com.lme.martianrobots.model.Coordinates;
import com.lme.martianrobots.model.GridObjectPosition;
import com.lme.martianrobots.model.IGridObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.StrictMath.sqrt;

@Service
public class GridService {

    Map<Coordinates, IGridObject> grid = new HashMap();


    public void createGridWithRobots(Coordinates upperRightCoordinate, List<IGridObject> gridObjects){
        createGrid(upperRightCoordinate);
        addGridObjectsToGrid(upperRightCoordinate, gridObjects);
    }

    private void addGridObjectsToGrid(Coordinates upperRightCoordinate, List<IGridObject> gridObjects){
        int gridSize = (int) sqrt(grid.size());
        for (IGridObject gridObj:gridObjects
             ) {
            gridObj.executeInstruction(upperRightCoordinate.getxPosition(), upperRightCoordinate.getyPosition());
            GridObjectPosition position = gridObj.getGridObjectPosition();

            //now move to new position on grid
            Coordinates targetCoordinates = position.getIsLost() ? position.getLastKnownCoordiantes() : position.getEndCoordinates();
            IGridObject targetObject = grid.get(targetCoordinates);

            if (targetObject == null){
                grid.put(targetCoordinates, gridObj);
                continue;
            }

            if (targetObject.getGridObjectPosition().getIsLost() && position.getIsLost()){
                grid.put(position.getStartCoordinates(), gridObj);
            }

        }
    }

    private void createGrid(Coordinates upperRight){
        for (int i = 0; i < upperRight.getxPosition(); i++) {
            for (int j = 0; j < upperRight.getyPosition(); j++) {
                Coordinates coordinates = new Coordinates();
                coordinates.setxPosition(i);
                coordinates.setyPosition(j);
                grid.put(coordinates, null);
            }
        }
    }

    public Map<Coordinates, IGridObject> getGrid() {
        return grid;
    }

    public List<IGridObject> getGridObjects() {
        List<IGridObject> gridObjects = new ArrayList<>();
        for (Map.Entry<Coordinates,IGridObject> entry:grid.entrySet()
             ) {
            if (entry.getValue() != null){
                gridObjects.add(entry.getValue());
            }
        }
        return  gridObjects;
    }
}
