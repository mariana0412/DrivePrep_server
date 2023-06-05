package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.model.Sign;
import com.phoenixsquad.driveprep_server.repository.SignRepository;
import com.phoenixsquad.driveprep_server.service.SignService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SignServiceImpl implements SignService {

    private final SignRepository signRepository;

    public SignServiceImpl(SignRepository signRepository) {
        this.signRepository = signRepository;
    }

    @Override
    public List<Sign> gettAllSigns() {
        Iterable<Sign> signs = signRepository.findAll();
        return StreamSupport.stream(signs.spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public List<Sign> getSignsByInfothemeId(Long infothemeId) {
        return signRepository.getSignsByInfothemeId(infothemeId);
    }
}
