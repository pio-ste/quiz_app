package pl.ps.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.ps.demo.model.entity.Question;
import pl.ps.demo.service.QuestionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quizApp")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @PostMapping("/saveQuestion/{idQuiz}/image")
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question,
                                                 @PathVariable("idQuiz") long idQuiz,
                                                 @RequestParam("imagefile") MultipartFile multipartFile) {
        try {
            Question newQuestion = questionService.saveQuestion(idQuiz, question, multipartFile);
            return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getQuestionsPaging/{idQuiz}")
    public ResponseEntity<Map<String, Object>> getQuestionByIdQuizPaging(@PathVariable("idQuiz") long idQuiz,
                                                                         @RequestParam(defaultValue = "1") int page) {
        try {
            Pageable paging = PageRequest.of(page, 1);
            List<Question> questions = questionService.getQuestionWithAnswersByIdQuiz(idQuiz);
            Page<Question> questionPage = new PageImpl<>(questions, paging, questions.size());
            Map<String, Object> response = new HashMap<>();

            response.put("quizzes", questions.get(page - 1));
            response.put("currentPage", questionPage.getNumber());
            response.put("totalItems", questionPage.getTotalElements());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getQuestions/{idQuiz}")
    public ResponseEntity<List<Question>> getQuestionByIdQuiz(@PathVariable("idQuiz") long idQuiz) {
        try {
            List<Question> questions = questionService.getQuestionWithAnswersByIdQuiz(idQuiz);
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getQuestionsWithUserAns/{idQuiz}")
    public ResponseEntity<List<Question>> getQuestionsWithUserAns(@PathVariable("idQuiz") long idQuiz) {
        try {
            List<Question> questions = questionService.getQuestionWithUserAnswersIdQuiz(idQuiz);
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateQuestion")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        try {
            Question newQuestion = questionService.updateQuestion(question);
            return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteQuestion/{idQuestion}")
    public ResponseEntity<HttpStatus> deleteQuestion(@PathVariable("idQuestion") long idQuestion) {
        try {
            questionService.deleteQuestion(idQuestion);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
