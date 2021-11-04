package pl.ps.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ps.demo.DTO.QuestionAnswerDTO;
import pl.ps.demo.entity.Question;
import pl.ps.demo.entity.User;
import pl.ps.demo.service.Interface.QuestionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.toIntExact;

@RestController
@RequestMapping("/quizApp")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping("/getQuestions/{idQuiz}")
    public ResponseEntity<Map<String, Object>> getQuestionByIdQuiz(@PathVariable("idQuiz") long idQuiz,
                                                                   @RequestParam(defaultValue = "1") int page){
        try{
            Pageable paging = PageRequest.of(page, 1);
            List<Question> questions = questionService.getQuestionWithAnswers(idQuiz);
            Page<Question> questionPage = new PageImpl<>(questions, paging, questions.size());
            Map<String, Object> response = new HashMap<>();

            response.put("quizzes", questions.get(page-1));
            response.put("currentPage", questionPage.getNumber());
            response.put("totalItems", questionPage.getTotalElements());
            response.put("totalPages", questions.size());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
