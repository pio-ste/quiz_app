package pl.ps.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ps.demo.entity.Answer;
import pl.ps.demo.entity.UserAnswer;
import pl.ps.demo.service.Interface.AnswerService;
import pl.ps.demo.service.Interface.UserAnswerService;

import java.util.List;

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
    public ResponseEntity<List<Answer>> getCorrectAnswers(@PathVariable("idQuestion") long idQuestion,
                                                          @PathVariable("isCorrect") boolean isCorrect){
        try{
            List<Answer> answers = answerService.getAnswers(idQuestion, isCorrect);
            return new ResponseEntity<>(answers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getQuestionAnswers/{idQuestion}")
    public ResponseEntity<List<Answer>> getQuestionAnswers(@PathVariable("idQuestion") long idQuestion){
        try{
            List<Answer> answers = answerService.getAnswers(idQuestion);
            return new ResponseEntity<>(answers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveAnswer/{idQuestion}")
    public ResponseEntity<List<Answer>> saveAnswer(@PathVariable("idQuestion") long idQuestion,
                                                 @RequestParam List<Answer> answers){
        try {
            List<Answer> newAnswers = answerService.saveAnswers(idQuestion, answers);
            return new ResponseEntity<>(newAnswers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateAnswer")
    public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answer){
        try {
            Answer newAnswer = answerService.updateAnswer(answer);
            return new ResponseEntity<>(newAnswer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAnswer/{idAnswer}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("idAnswer") long idAnswer) {
        try {
            answerService.deleteAnswer(idAnswer);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveUserAnswer/{idParticipant}/{idAnswer}/{idQuestion}")
    public ResponseEntity<UserAnswer> saveUserAnswer(@PathVariable("idParticipant") long idParticipant,
                                                       @PathVariable("idAnswer") long idAnswer,
                                                       @PathVariable("idQuestion") long idQuestion,
                                                       @RequestBody UserAnswer userAnswer){
        try {
            UserAnswer newUserAnswer = userAnswerService.saveUserAnswer(idParticipant, idAnswer, idQuestion, userAnswer);
            return new ResponseEntity<>(newUserAnswer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUserAnswers/{idQuestion}")
    public ResponseEntity<List<UserAnswer>> getCorrectAnswers(@PathVariable("idQuestion") long idQuestion){
        try{
            List<UserAnswer> userAnswers = userAnswerService.getUserAnswers(idQuestion);
            return new ResponseEntity<>(userAnswers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
