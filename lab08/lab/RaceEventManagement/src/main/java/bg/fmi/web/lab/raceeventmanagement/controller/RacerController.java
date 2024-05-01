package bg.fmi.web.lab.raceeventmanagement.controller;

import bg.fmi.web.lab.raceeventmanagement.dto.RacerDto;
import bg.fmi.web.lab.raceeventmanagement.mapper.RacerMapper;
import bg.fmi.web.lab.raceeventmanagement.model.Racer;
import bg.fmi.web.lab.raceeventmanagement.service.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<RacerDto> fetchRacerById(@PathVariable Integer id) {
        return new ResponseEntity<>(racerMapper.mapToDto(racerService.findById(id)),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RacerDto> updateRacer(@PathVariable Integer id, @RequestBody RacerDto racerDto) {
        Racer racer = racerMapper.mapFromDto(racerDto);
        racer.setId(id);
        return new ResponseEntity<>(racerMapper.mapToDto(racerService.updateRacer(racer)),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RacerDto> updateRacer(@PathVariable Integer id) {
        racerService.removeRacer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
