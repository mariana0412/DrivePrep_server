package com.phoenixsquad.driveprep_server.controller;

import com.phoenixsquad.driveprep_server.model.Theme;
import com.phoenixsquad.driveprep_server.service.ThemeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ThemeController {

    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    /**
     * Retrieves the themes associated with a specific category.
     *
     * @param categoryId The ID of the category.
     * @return ResponseEntity containing the list of themes if found, or NO_CONTENT if no themes are available
     *         for the specified category.
     */
    @GetMapping(path = "/themes")
    public ResponseEntity<List<Theme>> listThemes(@RequestParam Integer categoryId) {
        List<Theme> themes = themeService.getThemesByCategory(categoryId);
        if (themes.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(themes, HttpStatus.OK);
    }
}
