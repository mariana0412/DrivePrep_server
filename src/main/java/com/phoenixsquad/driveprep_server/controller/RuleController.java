package com.phoenixsquad.driveprep_server.controller;


import com.phoenixsquad.driveprep_server.model.info.Infotheme;
import com.phoenixsquad.driveprep_server.model.info.Rule;
import com.phoenixsquad.driveprep_server.service.InfothemeService;
import com.phoenixsquad.driveprep_server.service.RuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RuleController {

    private final RuleService ruleService;
    private final InfothemeService infothemeService;

    public RuleController(RuleService ruleService, InfothemeService infothemeService) {
        this.ruleService = ruleService;
        this.infothemeService = infothemeService;
    }

    @GetMapping(path = "/rules-infothemes")
    public ResponseEntity<List<Infotheme>> listRuleInfothemes() {
        List<Infotheme> infothemes = infothemeService.getRuleInfothemes();
        if (infothemes.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(infothemes, HttpStatus.OK);
    }

    @GetMapping(path = "/rules")
    public ResponseEntity<List<Rule>> listRules(@RequestParam(required = false) Long infothemeId) {
        List<Rule> rules;
        if(infothemeId != null)
            rules = ruleService.getRulesByInfothemeId(infothemeId);
        else
            rules = ruleService.gettAllRules();

        if(rules.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(rules, HttpStatus.OK);
    }
}
