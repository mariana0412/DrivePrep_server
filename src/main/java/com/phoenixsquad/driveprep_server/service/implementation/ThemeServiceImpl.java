package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.model.Theme;
import com.phoenixsquad.driveprep_server.repository.ThemeRepository;
import com.phoenixsquad.driveprep_server.service.ThemeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ThemeServiceImpl implements ThemeService {

    private final ThemeRepository themeRepository;

    public ThemeServiceImpl(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    @Override
    public List<Theme> getAllThemes() {
        Iterable<Theme> themes = themeRepository.findAll();
        return StreamSupport.stream(themes.spliterator(), false)
                .collect(Collectors.toList());
    }
}
