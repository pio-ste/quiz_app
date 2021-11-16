package pl.ps.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ps.demo.ENUMS.Status;
import pl.ps.demo.entity.Answer;
import pl.ps.demo.entity.Participant;
import pl.ps.demo.service.Interface.ParticipantService;

import java.util.List;

@RestController
@RequestMapping("/quizApp")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/getParticipants/{idQuiz}")
    public ResponseEntity<List<Participant>> getParticipants(@PathVariable("idQuiz") long idQuiz){
        try{
            List<Participant> participants = participantService.getAllParticipant(idQuiz);
            return new ResponseEntity<>(participants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getParticipantGreaterThan/{status}")
    public ResponseEntity<List<Participant>> getParticipantsByStatus(@PathVariable("status") Status status){
        try{
            List<Participant> participants = participantService.getParticipantByStatus(status);
            return new ResponseEntity<>(participants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getParticipantGreaterThan/{result}")
    public ResponseEntity<List<Participant>> getParticipantGreaterThan(@PathVariable("result") Integer result){
        try{
            List<Participant> participants = participantService.getParticipantGreaterThanResult(result);
            return new ResponseEntity<>(participants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getParticipantLessThan/{result}")
    public ResponseEntity<List<Participant>> getParticipantLessThan(@PathVariable("result") Integer result){
        try{
            List<Participant> participants = participantService.getParticipantLessThanResult(result);
            return new ResponseEntity<>(participants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    @DeleteMapping("/deleteParticipant/{idParticipant}")
    public ResponseEntity<HttpStatus> deleteParticipant(@PathVariable("idParticipant") long idParticipant) {
        try {
            participantService.deleteParticipant(idParticipant);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
