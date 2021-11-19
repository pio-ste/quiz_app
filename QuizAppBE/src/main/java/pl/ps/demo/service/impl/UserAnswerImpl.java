package pl.ps.demo.service.impl;

import org.springframework.stereotype.Service;
import pl.ps.demo.service.dto.UserAnswerDTO;
import pl.ps.demo.model.entity.Answer;
import pl.ps.demo.model.entity.Participant;
import pl.ps.demo.model.entity.Question;
import pl.ps.demo.model.entity.UserAnswer;
import pl.ps.demo.model.repository.AnswerRepository;
import pl.ps.demo.model.repository.ParticipantRepository;
import pl.ps.demo.model.repository.QuestionRepository;
import pl.ps.demo.model.repository.UserAnswerRepository;
import pl.ps.demo.service.UserAnswerService;

import java.util.List;

@Service
public class UserAnswerImpl implements UserAnswerService {

    private final UserAnswerRepository userAnswerRepository;
    private final ParticipantRepository participantRepository;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public UserAnswerImpl(UserAnswerRepository userAnswerRepository, ParticipantRepository participantRepository, AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.userAnswerRepository = userAnswerRepository;
        this.participantRepository = participantRepository;
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public UserAnswer saveUserAnswer(UserAnswerDTO userAnswerDTO) {

        Participant participant = participantRepository.findParticipantById(userAnswerDTO.getParticipantID());
        Answer answer = answerRepository.findAnswerById(userAnswerDTO.getAnswerID());
        Question question = questionRepository.findQuestionById(userAnswerDTO.getQuestionID());
        UserAnswer userAnswer = UserAnswer.builder()
                .isCorrect(userAnswerDTO.getCorrect())
                .participant(participant)
                .answer(answer)
                .question(question)
                .build();
        return userAnswerRepository.save(userAnswer);
    }

    @Override
    public List<UserAnswer> getUserAnswers(Long idQuestion) {
        return userAnswerRepository.findUserAnswerByQuestion_Id(idQuestion);
    }
}
