package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.model.info.Infotheme;
import com.phoenixsquad.driveprep_server.repository.info.InfothemeRepository;
import com.phoenixsquad.driveprep_server.service.InfothemeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfothemeServiceImpl implements InfothemeService {

    private final InfothemeRepository infothemeRepository;

    public InfothemeServiceImpl(InfothemeRepository infothemeRepository) {
        this.infothemeRepository = infothemeRepository;
    }

    @Override
    public List<Infotheme> getSignInfothemes() {
        return infothemeRepository.getSignInfoThemes();
    }

    @Override
    public List<Infotheme> getRuleInfothemes() {
        return infothemeRepository.getRuleInfoThemes();
    }
}
