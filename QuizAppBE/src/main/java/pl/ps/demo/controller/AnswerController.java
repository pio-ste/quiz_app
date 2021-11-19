package pl.ps.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ps.demo.model.entity.Answer;
import pl.ps.demo.model.entity.UserAnswer;
import pl.ps.demo.service.AnswerService;
import pl.ps.demo.service.UserAnswerService;
import pl.ps.demo.service.dto.UserAnswerDTO;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

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
    public List<Answer> getCorrectAnswers(@PathVariable long idQuestion, @PathVariable boolean isCorrect) {
        //throw new MyCustomException("my custom piotroroor");
        return answerService.getAnswers(idQuestion, isCorrect);

    }

    //TODO poprawić parametry w @PathVariable (usunąć)
    //TODO usunąć ResponseEntity - przenieść obsługę do exception handlera
    @GetMapping("/getQuestionAnswers/{idQuestion}")
    public List<Answer> getQuestionAnswers(@PathVariable("idQuestion") long idQuestion) {
        return answerService.getAnswers(idQuestion);
    }

    //TODO youtube ---> Encja na twarz i pcharz / phasz
    @ResponseStatus(CREATED)
    @PostMapping("/saveAnswer/{idQuestion}")
    public List<Answer> saveAnswer(@PathVariable long idQuestion, @RequestBody List<Answer> answers) {
        return answerService.saveAnswers(idQuestion, answers);
    }

    @PutMapping("/updateAnswer")
    @ResponseStatus(CREATED)
    public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answer) {
        try {
            Answer newAnswer = answerService.updateAnswer(answer);
            return new ResponseEntity<>(newAnswer, CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/deleteAnswer/{idAnswer}")
    public void deleteTutorial(@PathVariable long idAnswer) {
        answerService.deleteAnswer(idAnswer);
    }

    @PostMapping("/saveUserAnswer")
    public ResponseEntity<UserAnswer> saveUserAnswer(@RequestBody UserAnswerDTO userAnswerDTO) {
        try {
            UserAnswer newUserAnswer = userAnswerService.saveUserAnswer(userAnswerDTO);
            return new ResponseEntity<>(newUserAnswer, CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUserAnswers/{idQuestion}")
    public ResponseEntity<List<UserAnswer>> getCorrectAnswers(@PathVariable("idQuestion") long idQuestion) {
        try {
            List<UserAnswer> userAnswers = userAnswerService.getUserAnswers(idQuestion);
            return new ResponseEntity<>(userAnswers, OK);
        } catch (Exception e) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }
}
