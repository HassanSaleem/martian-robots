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


@RunWith(SpringRunner.class)
@SpringBootTest(classes={GridService.class})
public class GridServiceTest {

    @Autowired
    GridService gridService;

    @Test
    public void createGridWithRobotsTest(){

        GridObjectPosition position = new GridObjectPosition(new Coordinates(1,1), Orientation.East);
        Robot robot1 = new Robot(1, position,"RFRFRFRF");

        position = new GridObjectPosition(new Coordinates(3,2), Orientation.North);
        Robot robot2 = new Robot(2, position,"FRRFLLFFRRFLL");

        position = new GridObjectPosition(new Coordinates(0,3), Orientation.West);
        Robot robot3 = new Robot(3, position,"LLFFFLFLFL");

        List<Robot> gridObjects = new ArrayList<>();
        gridObjects.add(robot1);
        gridObjects.add(robot2);
        gridObjects.add(robot3);
        gridService.createGridWithRobots(new Coordinates(5,3), gridObjects);
        gridService.getGridObjects();
        Assert.assertEquals((6*4), gridService.getGrid().size());

        List<Robot> result = gridService.getGridObjects();

        Assert.assertEquals("1 1 E", result.stream().filter(obj -> obj.getUuid() == robot1.getUuid()).findAny().get().getGridPosition().getStringFormat());
        Assert.assertEquals("3 3 N LOST", result.stream().filter(obj -> obj.getUuid() == robot2.getUuid()).findAny().get().getGridPosition().getStringFormat());
        Assert.assertEquals("2 3 S", result.stream().filter(obj -> obj.getUuid() == robot3.getUuid()).findAny().get().getGridPosition().getStringFormat());

    }

    @Test
    public void invalidInstructionTest(){
        GridObjectPosition position = new GridObjectPosition(new Coordinates(1,1), Orientation.East);
        Robot robot1 = new Robot(1, position,"I");

        List<Robot> gridObjects = new ArrayList<>();
        gridObjects.add(robot1);
        gridService.createGridWithRobots(new Coordinates(5,3), gridObjects);
        gridService.getGridObjects();

        List<Robot> result = gridService.getGridObjects();

        Assert.assertEquals("1 1 E", result.stream().filter(obj -> obj.getUuid() == robot1.getUuid()).findAny().get().getGridPosition().getStringFormat());
    }

    @Test
    public void assertRobotIsLostTest(){

    }
}
