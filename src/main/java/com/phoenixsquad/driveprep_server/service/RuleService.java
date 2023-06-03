package com.phoenixsquad.driveprep_server.service;

import com.phoenixsquad.driveprep_server.model.info.Rule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RuleService {
    List<Rule> gettAllRules();
    List<Rule> getRulesByInfothemeId(Long infothemeId);
}
