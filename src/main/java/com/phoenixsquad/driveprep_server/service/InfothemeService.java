package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.model.Infotheme;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for managing Infothemes.
 */
@Service
public interface InfothemeService {
    List<Infotheme> getSignInfothemes();
}
