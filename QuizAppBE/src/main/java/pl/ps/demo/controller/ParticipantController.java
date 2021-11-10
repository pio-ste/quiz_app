package pl.ps.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ps.demo.entity.Answer;
import pl.ps.demo.entity.Participant;
import pl.ps.demo.entity.Question;
import pl.ps.demo.service.Interface.ParticipantService;

import java.util.List;

@RestController
@RequestMapping("/quizApp")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping("/saveParticipant/{idUser}/{idQuiz}")
    public ResponseEntity<Participant> saveParticipant(@PathVariable("idUser") long idUser,
                                                   @PathVariable("idQuiz") long idQuiz,
                                                   @RequestBody Participant participant){
        try {
            Participant newParticipant = participantService.saveParticipant(idUser, idQuiz, participant);
            return new ResponseEntity<>(newParticipant, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
