package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.model.info.Rule;
import com.phoenixsquad.driveprep_server.repository.info.RuleRepository;
import com.phoenixsquad.driveprep_server.service.RuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RuleServiceImpl implements RuleService {

    private final RuleRepository ruleRepository;

    public RuleServiceImpl(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public List<Rule> gettAllRules() {
        Iterable<Rule> rules = ruleRepository.findAll();
        return StreamSupport.stream(rules.spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public List<Rule> getRulesByInfothemeId(Long infothemeId) {
        return ruleRepository.getRulesByInfothemeId(infothemeId);
    }
}
