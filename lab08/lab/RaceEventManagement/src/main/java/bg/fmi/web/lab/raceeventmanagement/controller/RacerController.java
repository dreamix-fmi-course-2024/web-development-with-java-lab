package bg.fmi.web.lab.raceeventmanagement.controller;

import bg.fmi.web.lab.raceeventmanagement.dto.RacerDto;
import bg.fmi.web.lab.raceeventmanagement.mapper.RacerMapper;
import bg.fmi.web.lab.raceeventmanagement.model.Racer;
import bg.fmi.web.lab.raceeventmanagement.service.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/racer")

public class RacerController {

    @Autowired
    private RacerService racerService;

    @Autowired
    private RacerMapper racerMapper;


    @PostMapping
    public ResponseEntity<RacerDto> createRacer(@RequestBody RacerDto racerDto) {
        Racer racer = racerMapper.mapFromDto(racerDto);
        return new ResponseEntity<>(racerMapper.mapToDto(racerService.createRacer(racer)),HttpStatus.CREATED);
    }
}
