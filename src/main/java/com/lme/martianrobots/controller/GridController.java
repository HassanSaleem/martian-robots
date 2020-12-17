package com.lme.martianrobots.controller;

import com.lme.martianrobots.services.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GridController {
    @Autowired
    GridService gridService;

}
