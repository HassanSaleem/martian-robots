package com.lme.martianrobots.controller;

import com.lme.martianrobots.model.*;
import com.lme.martianrobots.services.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/grid")
public class GridController {
    @Autowired
    GridService gridService;

    @PostMapping("/create-grid")
    @ResponseBody
    public List<Robot>  createGridWithRobots(@RequestBody GridControllerRequest request){

        return gridService.createGridWithRobots(request.getCoordinates(), request.getRobots());
    }
}
