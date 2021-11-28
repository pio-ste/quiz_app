package pl.ps.demo.controller;

import org.springframework.web.bind.annotation.*;
import pl.ps.demo.model.enums.Status;
import pl.ps.demo.service.ParticipantService;
import pl.ps.demo.service.dto.ParticipantDTO;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/quizApp")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/getParticipants/{idQuiz}")
    public List<ParticipantDTO> getParticipants(@PathVariable long idQuiz) {
        return participantService.getAllParticipant(idQuiz);
    }

    @GetMapping("/getParticipantByStatus/{status}/{idQuiz}")
    public List<ParticipantDTO> getParticipantsByStatus(@PathVariable Status status,
                                                        @PathVariable Long idQuiz) {
        return participantService.getParticipantByStatus(status, idQuiz);
    }

    @GetMapping("/getParticipantGreaterThan/{result}/{idQuiz}")
    public List<ParticipantDTO> getParticipantGreaterThan(@PathVariable Integer result,
                                                          @PathVariable Long idQuiz) {
        return participantService.getParticipantGreaterThanResult(result, idQuiz);
    }

    @GetMapping("/getParticipantLessThan/{result}/{idQuiz}")
    public List<ParticipantDTO> getParticipantLessThan(@PathVariable Integer result,
                                                       @PathVariable Long idQuiz) {
        return participantService.getParticipantLessThanResult(result, idQuiz);
    }

    @ResponseStatus(CREATED)
    @PostMapping("/saveParticipant/{idUser}/{idQuiz}")
    public ParticipantDTO saveParticipant(@PathVariable Long idUser,
                                          @PathVariable Long idQuiz,
                                          @RequestBody ParticipantDTO participantDTO) {
        return participantService.saveParticipant(idUser, idQuiz, participantDTO);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/deleteParticipant/{idParticipant}")
    public void deleteParticipant(@PathVariable long idParticipant) {
        participantService.deleteParticipant(idParticipant);
    }
}
