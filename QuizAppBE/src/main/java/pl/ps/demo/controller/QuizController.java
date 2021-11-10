package pl.ps.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ps.demo.entity.Participant;
import pl.ps.demo.entity.Quiz;
import pl.ps.demo.service.Interface.QuizService;

@RestController
@RequestMapping("/quizApp")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/saveQuiz/{idUser}")
    public ResponseEntity<Quiz> saveQuiz(@PathVariable("idUser") long idUser,
                                         @RequestBody Quiz quiz){
        try {
            Quiz newQuiz = quizService.saveQuiz(idUser, quiz);
            return new ResponseEntity<>(newQuiz, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
