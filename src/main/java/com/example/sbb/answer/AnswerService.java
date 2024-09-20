package com.example.sbb.answer;

import com.example.sbb.DataNotFoundException;
import com.example.sbb.question.Question;
import com.example.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Question question, String content, SiteUser siteUser) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setQuestion(question);
        answer.setCreateDate(LocalDateTime.now());
        answer.setAuthor(siteUser);

        answerRepository.save(answer);
    }

    public Answer getAnswer(Integer id) {
        Optional<Answer> oa = this.answerRepository.findById(id);

        if (oa.isPresent()) {
            return oa.get();
        } else {
            throw new DataNotFoundException("answer not found");
        }
    }
}
