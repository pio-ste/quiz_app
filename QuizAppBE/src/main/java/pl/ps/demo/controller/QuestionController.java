package pl.ps.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.ps.demo.model.entity.Question;
import pl.ps.demo.service.QuestionService;
import pl.ps.demo.service.dto.QuestionDTO;
import pl.ps.demo.service.dto.QuestionRelationDTO;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/quizApp")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @ResponseStatus(CREATED)
    @PostMapping("/saveQuestion/{idQuiz}")
    public QuestionRelationDTO saveQuestion(@RequestBody QuestionDTO questionDTO,
                                            @PathVariable long idQuiz) {
        return questionService.saveQuestion(idQuiz, questionDTO);
    }

    @GetMapping("/getQuestionsPaging/{idQuiz}")
    public Map<String, Object> getQuestionByIdQuizPaging(@PathVariable long idQuiz,
                                                         @RequestParam(defaultValue = "1") int page) {
        return questionService.getQuestionWithAnswersByIdQuizPaging(page, idQuiz);
    }

    @GetMapping("/getQuestions/{idQuiz}")
    public List<QuestionRelationDTO> getQuestionByIdQuiz(@PathVariable long idQuiz) {
        return questionService.getQuestionWithAnswersByIdQuiz(idQuiz);
    }

    @GetMapping("/getQuestionsWithUserAns/{idQuiz}")
    public List<QuestionRelationDTO> getQuestionsWithUserAns(@PathVariable long idQuiz) {
        return questionService.getQuestionWithUserAnswersIdQuiz(idQuiz);
    }

    @GetMapping("/getAllUserQuestionsFromAllQuizzes/{idUser}")
    public List<QuestionRelationDTO> getAllUserQuestions(@PathVariable long idUser) {
        return questionService.getQuestionByQuizUserId(idUser);
    }

    @GetMapping("/getAllUserQuestions/{idQuiz}/{idQuiz}")
    public List<QuestionRelationDTO> getAllUserQuestions(@PathVariable long idQuiz,
                                                         @PathVariable long idUser) {
        return questionService.getQuestionByQuizIdAndQuizUserId(idQuiz, idUser);
    }

    @ResponseStatus(CREATED)
    @PutMapping("/updateQuestion")
    public QuestionRelationDTO updateQuestion(@RequestBody QuestionDTO questionDTO) {
        return questionService.updateQuestion(questionDTO);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/deleteQuestion/{idQuestion}")
    public void deleteQuestion(@PathVariable long idQuestion) {
        questionService.deleteQuestion(idQuestion);
    }
}
