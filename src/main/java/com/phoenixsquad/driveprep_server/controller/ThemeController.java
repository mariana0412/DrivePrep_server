package com.phoenixsquad.driveprep_server.controller;

import com.phoenixsquad.driveprep_server.model.Theme;
import com.phoenixsquad.driveprep_server.service.ThemeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ThemeController {

    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping(path = "/themes")
    public ResponseEntity<List<Theme>> listThemes() {
        List<Theme> themes = themeService.getAllThemes();
        if(themes.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(themes, HttpStatus.OK);
    }

}
