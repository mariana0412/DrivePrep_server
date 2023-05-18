package com.phoenixsquad.driveprep_server.controller;

import com.phoenixsquad.driveprep_server.model.TrafficRule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrafficRuleController {

    @GetMapping("/traffic-rules")
    public ResponseEntity<List<TrafficRule>> getAllTrafficRules() {
        return null;
    }
}
