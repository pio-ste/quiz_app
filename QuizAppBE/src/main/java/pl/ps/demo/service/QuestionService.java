package pl.ps.demo.service;

import org.springframework.web.multipart.MultipartFile;
import pl.ps.demo.model.entity.Question;
import pl.ps.demo.service.dto.QuestionDTO;
import pl.ps.demo.service.dto.QuestionRelationDTO;

import java.util.List;
import java.util.Map;

public interface QuestionService {

    QuestionRelationDTO saveQuestion(Long idQuiz, QuestionDTO questionDTO);

    void deleteQuestion(Long id);

    QuestionRelationDTO updateQuestion(QuestionDTO questionDTO);

    QuestionRelationDTO getQuestion(Long id);

    List<QuestionRelationDTO> getQuestionWithAnswersByIdQuiz(Long idQuiz);

    Map<String, Object> getQuestionWithAnswersByIdQuizPaging(Integer page, Long idQuiz);

    List<QuestionRelationDTO> getQuestionWithUserAnswersIdQuiz(Long idQuiz);

    List<QuestionRelationDTO> getQuestionByQuizUserId(Long idUser);

    List<QuestionRelationDTO> getQuestionByQuizIdAndQuizUserId(Long idQuiz, Long idUser);
}
