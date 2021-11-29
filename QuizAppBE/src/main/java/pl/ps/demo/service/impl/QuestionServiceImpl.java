package pl.ps.demo.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.ps.demo.exception.MyCustomException;
import pl.ps.demo.model.entity.Question;
import pl.ps.demo.model.entity.Quiz;
import pl.ps.demo.model.repository.QuestionRepository;
import pl.ps.demo.model.repository.QuizRepository;
import pl.ps.demo.model.repository.UserRepository;
import pl.ps.demo.service.QuestionService;
import pl.ps.demo.service.dto.QuestionDTO;
import pl.ps.demo.service.dto.QuestionRelationDTO;
import pl.ps.demo.service.mapper.QuestionMapper;
import pl.ps.demo.service.validation.ParticipantValidation;
import pl.ps.demo.service.validation.QuestionValidation;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    private final QuizRepository quizRepository;

    private final UserRepository userRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, QuizRepository quizRepository, UserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
        this.userRepository = userRepository;
    }

    @Override
    public QuestionRelationDTO saveQuestion(Long idQuiz, QuestionDTO questionDTO) {
        List<String> exceptionList = new LinkedList<>();
        var questionValidation = new QuestionValidation(exceptionList, questionDTO);
        questionValidation.validate();
        var question =  QuestionMapper.mapFromDtoToEntity(questionDTO);
        var quiz = quizRepository.getByIdOrThrow(idQuiz);
        /*if (!multipartFile.isEmpty()) {
            try {
                Byte[] byteImg = new Byte[multipartFile.getBytes().length];

                int i = 0;
                for (byte b : multipartFile.getBytes()) {
                    byteImg[i++] = b;
                }
                question.setImg(byteImg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        question.setQuiz(quiz);
        return QuestionMapper.mapFromEntityToDtoRelation(questionRepository.save(question));
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteOrThrow(id);
    }

    @Override
    public QuestionRelationDTO updateQuestion(QuestionDTO questionDTO) {
        List<String> exceptionList = new LinkedList<>();
        var questionValidation = new QuestionValidation(exceptionList, questionDTO);
        questionValidation.validate();
        var question = questionRepository.getByIdOrThrow(questionDTO.getId());
        question.setContent(questionDTO.getContent());
        question.setPoints(questionDTO.getPoints());
        question.setTime(questionDTO.getTime());
        return QuestionMapper.mapFromEntityToDtoRelation(question);
    }

    @Override
    public QuestionRelationDTO getQuestion(Long id) {
        return QuestionMapper.mapFromEntityToDtoRelation(questionRepository.getByIdOrThrow(id));
    }

    @Override
    public List<QuestionRelationDTO> getQuestionWithUserAnswersIdQuiz(Long idQuiz) {
        quizRepository.getByIdOrThrow(idQuiz);
        List<QuestionRelationDTO> questionRelationDTOS = new LinkedList<>();
        questionRepository.findQuestionByQuiz_Id(idQuiz).forEach(question ->
                questionRelationDTOS.add(QuestionMapper.mapFromEntityToDtoRelation(question)));
        return questionRelationDTOS;
    }

    @Override
    public List<QuestionRelationDTO> getQuestionByQuizUserId(Long idUser) {
        userRepository.getByIdOrThrow(idUser);
        List<QuestionRelationDTO> questionRelationDTOS = new LinkedList<>();
        questionRepository.findQuestionByQuiz_User_Id(idUser).forEach(question ->
                questionRelationDTOS.add(QuestionMapper.mapFromEntityToDtoRelation(question)));
        return questionRelationDTOS;
    }

    @Override
    public List<QuestionRelationDTO> getQuestionByQuizIdAndQuizUserId(Long idQuiz, Long idUser) {
        quizRepository.getByIdOrThrow(idQuiz);
        userRepository.getByIdOrThrow(idUser);
        List<QuestionRelationDTO> questionRelationDTOS = new LinkedList<>();
        questionRepository.findQuestionByQuiz_IdAndQuiz_User_Id(idQuiz, idUser).forEach(question ->
                questionRelationDTOS.add(QuestionMapper.mapFromEntityToDtoRelation(question)));
        return questionRelationDTOS;
    }

    @Override
    public List<QuestionRelationDTO> getQuestionWithAnswersByIdQuiz(Long idQuiz) {
        quizRepository.getByIdOrThrow(idQuiz);
        List<QuestionRelationDTO> questionRelationDTOS = new LinkedList<>();
        questionRepository.findQuestionByQuiz_Id(idQuiz).forEach(question ->
                questionRelationDTOS.add(QuestionMapper.mapFromEntityToDtoRelation(question)));
        return questionRelationDTOS;
    }

    @Override
    public Map<String, Object> getQuestionWithAnswersByIdQuizPaging(Integer page, Long idQuiz) {
        if (page <= 0) throw new MyCustomException("Page can not be lower or equal 0!!");
        quizRepository.getByIdOrThrow(idQuiz);
        List<QuestionRelationDTO> questionRelationDTOS = new LinkedList<>();
        Pageable paging = PageRequest.of(page, 1);
        questionRepository.findQuestionByQuiz_Id(idQuiz).forEach(question ->
                questionRelationDTOS.add(QuestionMapper.mapFromEntityToDtoRelation(question)));
        Page<QuestionRelationDTO> questionPage = new PageImpl<>(questionRelationDTOS, paging, questionRelationDTOS.size());
        Map<String, Object> response = new HashMap<>();
        response.put("quizzes", questionRelationDTOS.get(page - 1));
        response.put("currentPage", questionPage.getNumber());
        response.put("totalItems", questionPage.getTotalElements());
        return response;
    }
}
