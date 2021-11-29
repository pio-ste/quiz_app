package pl.ps.demo.controller;

import org.springframework.web.bind.annotation.*;
import pl.ps.demo.service.QuizService;
import pl.ps.demo.service.dto.QuizDTO;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

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

    @ResponseStatus(CREATED)
    @PostMapping("/saveQuiz/{idUser}")
    public QuizDTO saveQuiz(@PathVariable long idUser,
                            @Valid @RequestBody QuizDTO quizDTO) {
        return quizService.saveQuiz(idUser, quizDTO);
    }

    @ResponseStatus(CREATED)
    @PutMapping("/updateQuiz")
    public QuizDTO updateQuiz(@RequestBody QuizDTO quizDTO) {

        return quizService.updateQuiz(quizDTO);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/deleteQuiz/{idQuiz}")
    public void deleteQuiz(@PathVariable long idQuiz) {
        quizService.deleteQuiz(idQuiz);
    }
}
