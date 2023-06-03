package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.model.info.Infotheme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InfothemeService {
    List<Infotheme> getSignInfothemes();
    List<Infotheme> getRuleInfothemes();
}
