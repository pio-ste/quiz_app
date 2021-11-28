package pl.ps.demo.controller;

import org.springframework.web.bind.annotation.*;
import pl.ps.demo.service.AnswerService;
import pl.ps.demo.service.UserAnswerService;
import pl.ps.demo.service.dto.AnswerDTO;
import pl.ps.demo.service.dto.UserAnswerDTO;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/quizApp")
public class AnswerController {

    private final AnswerService answerService;

    private final UserAnswerService userAnswerService;

    public AnswerController(AnswerService answerService, UserAnswerService userAnswerService) {
        this.answerService = answerService;
        this.userAnswerService = userAnswerService;
    }

    @GetMapping("/getCorrectAnswers/{idQuestion}/{isCorrect}")
    public List<AnswerDTO> getCorrectAnswers(@PathVariable long idQuestion, @PathVariable boolean isCorrect) {
        return answerService.getAnswers(idQuestion, isCorrect);

    }

    @GetMapping("/getQuestionAnswers/{idQuestion}")
    public List<AnswerDTO> getQuestionAnswers(@PathVariable long idQuestion) {
        return answerService.getAnswers(idQuestion);
    }

    //TODO youtube ---> Encja na twarz i pchasz
    @ResponseStatus(CREATED)
    @PostMapping("/saveAnswer/{idQuestion}")
    public List<AnswerDTO> saveAnswer(@PathVariable long idQuestion, @RequestBody List<AnswerDTO> answers) {
        return answerService.saveAnswers(idQuestion, answers);
    }

    @ResponseStatus(CREATED)
    @PutMapping("/updateAnswer")
    public AnswerDTO updateAnswer(@RequestBody AnswerDTO answer) {
        return answerService.updateAnswer(answer);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/deleteAnswer/{idAnswer}")
    public void deleteTutorial(@PathVariable long idAnswer) {
        answerService.deleteAnswer(idAnswer);
    }

    @ResponseStatus(CREATED)
    @PostMapping("/saveUserAnswer/{idAnswer}/{idParticipant}")
    public UserAnswerDTO saveUserAnswer(@PathVariable long idAnswer,
                                                     @PathVariable long idParticipant,
                                                     @RequestBody UserAnswerDTO userAnswerDTO) {
            return userAnswerService.saveUserAnswer(idAnswer, idParticipant, userAnswerDTO);
    }

    @GetMapping("/getUserAnswers/{idQuestion}")
    public List<UserAnswerDTO> getCorrectAnswers(@PathVariable long idQuestion) {
        return userAnswerService.getUserAnswers(idQuestion);
    }
}
