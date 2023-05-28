package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.model.Theme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThemeService {
    List<Theme> getAllThemes();
}
