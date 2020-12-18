package com.lme.martianrobotos;

import com.lme.martianrobots.model.*;
import com.lme.martianrobots.services.GridService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={GridService.class})
public class GridServiceTest {

    @Autowired
    GridService gridService;

    @Test
    public void createGridWithRobotsTest(){

        GridObjectPosition position = new GridObjectPosition(new Coordinates(1,1), Orientation.East);
        IGridObject robot1 = new Robot(position,"RFRFRFRF");

        position = new GridObjectPosition(new Coordinates(3,2), Orientation.North);
        IGridObject robot2 = new Robot(position,"FRRFLLFFRRFLL");

        position = new GridObjectPosition(new Coordinates(0,3), Orientation.West);
        IGridObject robot3 = new Robot(position,"LLFFFLFLFL");

        List<IGridObject> gridObjects = new ArrayList<>();
        //gridObjects.add(robot1);
        //gridObjects.add(robot2);
        gridObjects.add(robot3);
        gridService.createGridWithRobots(new Coordinates(5,3), gridObjects);
        gridService.getGridObjects();
        Assert.assertEquals((5*3)+2, gridService.getGrid().size());

        List<IGridObject> result = gridService.getGridObjects();

    }

    @Test
    public void updateRobotOnGridTest(){

    }

    @Test
    public void assertRobotIsLostTest(){

    }
}
