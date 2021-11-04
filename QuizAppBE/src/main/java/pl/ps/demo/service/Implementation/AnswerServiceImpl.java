package pl.ps.demo.service.Implementation;

import pl.ps.demo.entity.Answer;
import pl.ps.demo.entity.Question;
import pl.ps.demo.service.Interface.AnswerService;

import java.util.List;

public class AnswerServiceImpl implements AnswerService {


    @Override
    public Answer saveAnswer(Long idQuestion, Answer answer) {
        return null;
    }

    @Override
    public void deleteAnswer(Long id) {

    }

    @Override
    public Answer getAnswer(Long id) {
        return null;
    }

    @Override
    public List<Answer> getAnswers(Long id, Boolean isCorrect) {
        return null;
    }

    @Override
    public List<Answer> getAnswers(Question question) {
        return null;
    }
}
