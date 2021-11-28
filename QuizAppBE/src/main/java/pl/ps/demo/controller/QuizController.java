package pl.ps.demo.controller;

import org.springframework.web.bind.annotation.*;
import pl.ps.demo.service.QuizService;
import pl.ps.demo.service.dto.QuizDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/quizApp")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/getUserQuiz/{idUser}")
    public List<QuizDTO> getUserQuiz(@PathVariable long idUser) {
        return quizService.getAllUserQuizzes(idUser);
    }

    @GetMapping("/getQuiz/{idQuiz}")
    public QuizDTO getQuiz(@PathVariable long idQuiz) {
        return quizService.getQuiz(idQuiz);
    }

    @PostMapping("/saveQuiz/{idUser}")
    public QuizDTO saveQuiz(@PathVariable long idUser,
                            @Valid @RequestBody QuizDTO quizDTO) {
        return quizService.saveQuiz(idUser, quizDTO);
    }

    @PutMapping("/updateQuiz")
    public QuizDTO updateQuiz(@RequestBody QuizDTO quizDTO) {

        return quizService.updateQuiz(quizDTO);
    }

    @DeleteMapping("/deleteQuiz/{idQuiz}")
    public void deleteQuiz(@PathVariable long idQuiz) {
        quizService.deleteQuiz(idQuiz);
    }
}
