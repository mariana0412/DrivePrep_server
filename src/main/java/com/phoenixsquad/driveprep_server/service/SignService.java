package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.model.info.Sign;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SignService {
    List<Sign> gettAllSigns();
    List<Sign> getSignsByInfothemeId(Long infothemeId);
}
