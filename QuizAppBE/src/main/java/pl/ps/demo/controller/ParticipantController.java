package pl.ps.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ps.demo.DTO.ParticipantDTO;
import pl.ps.demo.ENUMS.Status;
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

    @GetMapping("/getParticipantByStatus/{status}/{idQuiz}")
    public ResponseEntity<List<Participant>> getParticipantsByStatus(@PathVariable("status") Status status,
                                                                     @PathVariable("idQuiz") Long idQuiz){
        try{
            List<Participant> participants = participantService.getParticipantByStatus(status, idQuiz);
            return new ResponseEntity<>(participants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getParticipantGreaterThan/{result}/{idQuiz}")
    public ResponseEntity<List<Participant>> getParticipantGreaterThan(@PathVariable("result") Integer result,
                                                                       @PathVariable("idQuiz") Long idQuiz){
        try{
            List<Participant> participants = participantService.getParticipantGreaterThanResult(result, idQuiz);
            return new ResponseEntity<>(participants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getParticipantLessThan/{result}/{idQuiz}")
    public ResponseEntity<List<Participant>> getParticipantLessThan(@PathVariable("result") Integer result,
                                                                    @PathVariable("idQuiz") Long idQuiz){
        try{
            List<Participant> participants = participantService.getParticipantLessThanResult(result, idQuiz);
            return new ResponseEntity<>(participants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveParticipant")
    public ResponseEntity<Participant> saveParticipant(@RequestBody ParticipantDTO participantDTO){
        try {
            System.out.println(participantDTO.getStatus().toString());
            Participant newParticipant = participantService.saveParticipant(participantDTO);
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
