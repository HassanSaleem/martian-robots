package com.lme.martianrobots.services;

import com.lme.martianrobots.model.*;
import com.lme.martianrobots.utility.DirectionMap;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.StrictMath.sqrt;

@Service
public class GridService {

    Map<Coordinates, Robot> grid = new HashMap();


    public List<Robot> createGridWithRobots(Coordinates upperRightCoordinate, List<Robot> gridObjects){
        createGrid(upperRightCoordinate);
        addGridObjectsToGrid(upperRightCoordinate, gridObjects);
        return getGridObjects();
    }

    private void addGridObjectsToGrid(Coordinates upperRightCoordinate, List<Robot> gridObjects){
        int gridSize = (int) sqrt(grid.size());
        for (Robot gridObj:gridObjects
             ) {

            List<Coordinates> lostObjects = grid.entrySet().stream().map(Map.Entry::getValue)
                                                .filter(obj -> obj != null)
                                                .filter(obj -> obj.getGridPosition().getIsLost())
                                                .map(Robot::getGridPosition)
                                                .map(GridObjectPosition::getLastKnownCoordiantes)
                                                .collect(Collectors.toList());

            executeInstruction(gridObj, lostObjects, upperRightCoordinate.getxPosition(), upperRightCoordinate.getyPosition());
            GridObjectPosition position = gridObj.getGridPosition();

            //now move to new position on grid
            Coordinates targetCoordinates = position.getIsLost() ? position.getLastKnownCoordiantes() : position.getEndCoordinates();
            Robot targetObject = grid.get(targetCoordinates);

            if (targetObject == null){
                grid.put(targetCoordinates, gridObj);
                continue;
            }

            if (targetObject.getGridPosition().getIsLost() && position.getIsLost()){
                grid.put(position.getStartCoordinates(), gridObj);
            }

        }
    }

    public void executeInstruction(Robot gridObject, List<Coordinates> lostObjects, int xBoundary, int yBoundary) {
        char[] steps = gridObject.getInstructions().toCharArray();
        for (char step:steps
        ) {
            if (gridObject.getGridPosition().getIsLost()) continue;
            Orientation orientation =  gridObject.getGridPosition().getOrientation();
            AbstractMap.SimpleEntry<Coordinates,Orientation> translatedStep = DirectionMap.getDirectionMap().get(String.format("%s%s", orientation.toString(),Character.toUpperCase(step)));
            if (translatedStep == null){continue;}
            Coordinates nxtCoordinates = gridObject.getGridPosition().getNextCoordinates(translatedStep.getKey());
            if ((nxtCoordinates.getxPosition() > xBoundary
                    || nxtCoordinates.getyPosition()> yBoundary)
                    || nxtCoordinates.getyPosition() < 0
                    || nxtCoordinates.getxPosition() < 0){

                if (lostObjects.contains(gridObject.getGridPosition().getEndCoordinates())){
                    continue;
                }
                //mark grid object lost
                gridObject.getGridPosition().setIsLost(true);
            }
            gridObject.getGridPosition().move(nxtCoordinates);
            gridObject.getGridPosition().setOrientation(translatedStep.getValue());
        }
    }

    private void createGrid(Coordinates upperRight){
        for (int i = 0; i <= upperRight.getxPosition(); i++) {
            for (int j = 0; j <= upperRight.getyPosition(); j++) {
                Coordinates coordinates = new Coordinates();
                coordinates.setxPosition(i);
                coordinates.setyPosition(j);
                grid.put(coordinates, null);
            }
        }
    }

    public Map<Coordinates, Robot> getGrid() {
        return grid;
    }

    public List<Robot> getGridObjects() {
        List<Robot> gridObjects = grid.entrySet().stream().map(Map.Entry::getValue)
                .filter(obj -> obj != null)
                .collect(Collectors.toList());
        return  gridObjects;
    }
}
