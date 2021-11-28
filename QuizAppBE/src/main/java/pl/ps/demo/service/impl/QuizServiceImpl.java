package pl.ps.demo.service.impl;

import org.springframework.stereotype.Service;
import pl.ps.demo.model.repository.QuizRepository;
import pl.ps.demo.model.repository.UserRepository;
import pl.ps.demo.service.QuizService;
import pl.ps.demo.service.dto.QuizDTO;
import pl.ps.demo.service.mapper.QuizMapper;
import pl.ps.demo.service.validation.QuizValidation;

import java.util.LinkedList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final UserRepository userRepository;

    public QuizServiceImpl(QuizRepository quizRepository, UserRepository userRepository) {
        this.quizRepository = quizRepository;
        this.userRepository = userRepository;
    }

    @Override
    public QuizDTO saveQuiz(Long idUser, QuizDTO quizDTO) {
        List<String> exceptionList = new LinkedList<>();
        var quizValidation = new QuizValidation(exceptionList, quizDTO);
        quizValidation.validate();
        var quiz = QuizMapper.mapFromDtoToEntity(quizDTO);
        var user = userRepository.getByIdOrThrow(idUser);
        quiz.setUser(user);
        return QuizMapper.mapFromEntityToDto(quizRepository.save(quiz));
    }

    @Override
    public void deleteQuiz(Long idQuiz) {
        quizRepository.deleteOrThrow(idQuiz);
    }

    @Override
    public QuizDTO updateQuiz(QuizDTO quizDTO) {
        List<String> exceptionList = new LinkedList<>();
        var quizValidation = new QuizValidation(exceptionList, quizDTO);
        quizValidation.validate();
        var quiz = quizRepository.findQuizById(quizDTO.getId());
        quiz.setDescription(quizDTO.getDescription());
        quiz.setEndDate(quizDTO.getEndDate());
        quiz.setMaxPoints(quizDTO.getMaxPoints());
        quiz.setStartDate(quizDTO.getStartDate());
        quiz.setTitle(quizDTO.getTitle());
        return QuizMapper.mapFromEntityToDto(quiz);
    }

    @Override
    public QuizDTO getQuiz(Long idQuiz) {
        return QuizMapper.mapFromEntityToDto(quizRepository.getByIdOrThrow(idQuiz));
    }

    @Override
    public List<QuizDTO> getAllUserQuizzes(Long idUser) {
        List<QuizDTO> quizDTOS = new LinkedList<>();
        userRepository.getByIdOrThrow(idUser);
        quizRepository.findQuizByUser_Id(idUser).forEach(quiz ->
                quizDTOS.add(QuizMapper.mapFromEntityToDto(quiz)));
        return quizDTOS;
    }
}
