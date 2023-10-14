package edu.application.general.controllers;

import edu.application.general.links.LinksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinksController {

    private final LinksService linksService;

    public LinksController(LinksService linksService) {
        this.linksService = linksService;
    }

    @GetMapping
    public int status(){
        linksService.randomPull();
        return Thread.activeCount();
    }
}
