package com.example.sbb.answer;

import com.example.sbb.question.Question;
import com.example.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    SiteUser author;

    private LocalDateTime createDate;

    // 기본은 fetch = FetchType.EAGER
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;
}
