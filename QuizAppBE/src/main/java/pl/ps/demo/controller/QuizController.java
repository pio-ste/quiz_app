package pl.ps.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ps.demo.entity.Participant;
import pl.ps.demo.entity.Question;
import pl.ps.demo.entity.Quiz;
import pl.ps.demo.service.Interface.QuizService;

import java.util.List;

@RestController
@RequestMapping("/quizApp")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/getUserQuiz/{idUser}")
    public ResponseEntity<List<Quiz>> getUserQuiz(@PathVariable("idUser") long idUser){
        try{
            List<Quiz> quizzes = quizService.getAllUserQuizzes(idUser);
            return new ResponseEntity<>(quizzes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getQuiz/{idQuiz}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable("idQuiz") long idQuiz){
        try{
            Quiz quiz = quizService.getQuiz(idQuiz);
            return new ResponseEntity<>(quiz, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    @PutMapping("/updateQuiz")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz Quiz){
        try {
            Quiz newQuiz = quizService.updateQuiz(Quiz);
            return new ResponseEntity<>(newQuiz, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteQuiz/{idQuiz}")
    public ResponseEntity<HttpStatus> deleteQuiz(@PathVariable("idQuiz") long idQuiz) {
        try {
            quizService.deleteQuiz(idQuiz);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
