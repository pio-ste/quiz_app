package pl.ps.demo.service.impl;

import org.springframework.stereotype.Service;
import pl.ps.demo.model.entity.Quiz;
import pl.ps.demo.model.entity.User;
import pl.ps.demo.model.repository.QuizRepository;
import pl.ps.demo.model.repository.UserRepository;
import pl.ps.demo.service.QuizService;

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
    public Quiz saveQuiz(Long idUser, Quiz quiz) {
        User user = userRepository.findUserById(idUser);
        quiz.setUser(user);
        return quizRepository.save(quiz);
    }

    @Override
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        Quiz newQuiz = quizRepository.findQuizById(quiz.getId());
        newQuiz.setDescription(quiz.getDescription());
        newQuiz.setEndDate(quiz.getEndDate());
        newQuiz.setMaxPoints(quiz.getMaxPoints());
        newQuiz.setStartDate(quiz.getStartDate());
        newQuiz.setTitle(quiz.getTitle());
        return quizRepository.save(newQuiz);
    }

    @Override
    public Quiz getQuiz(Long id) {
        return quizRepository.findQuizById(id);
    }

    @Override
    public List<Quiz> getAllUserQuizzes(Long id) {
        return quizRepository.findQuizByUser_Id(id);
    }
}
