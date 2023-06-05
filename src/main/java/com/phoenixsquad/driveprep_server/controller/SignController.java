package com.phoenixsquad.driveprep_server.controller;

import com.phoenixsquad.driveprep_server.model.Infotheme;
import com.phoenixsquad.driveprep_server.model.Sign;
import com.phoenixsquad.driveprep_server.service.InfothemeService;
import com.phoenixsquad.driveprep_server.service.SignService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SignController {

    private final SignService signService;
    private final InfothemeService infothemeService;

    public SignController(SignService signService, InfothemeService infothemeService) {
        this.signService = signService;
        this.infothemeService = infothemeService;
    }

    @GetMapping(path = "/signs-infothemes")
    public ResponseEntity<List<Infotheme>> listSignInfothemes() {
        List<Infotheme> infothemes = infothemeService.getSignInfothemes();
        if (infothemes.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(infothemes, HttpStatus.OK);
    }

    @GetMapping(path = "/signs")
    public ResponseEntity<List<Sign>> listSigns(@RequestParam(required = false) Long infothemeId) {
        List<Sign> signs;
        if(infothemeId != null)
            signs = signService.getSignsByInfothemeId(infothemeId);
        else signs = signService.gettAllSigns();

        if(signs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(signs, HttpStatus.OK);
    }
}
