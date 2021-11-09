package vn.com.codegym.exammodule4.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idQues;
    @NotBlank(message = "không được để trống")
    @Size(min = 5,max = 100)
    private String title;
    @NotBlank(message = "không được để trống")
    @Size(min = 10,max = 500)
    private String question2;
//    @NotBlank(message = "không được để trống")

    private String answer;
    private LocalDate date_create;
private boolean status;
    @NotNull(message = "không được để trống")
    @ManyToOne(targetEntity = QuestionType.class)
    @JoinColumn(name = "idQuestionType",referencedColumnName = "idQuestionType")
    private QuestionType questions;

    public Question() {
    }

    public int getIdQues() {
        return idQues;
    }

    public void setIdQues(int idQues) {
        this.idQues = idQues;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LocalDate getDate_create() {
        return date_create;
    }

    public void setDate_create(LocalDate date_create) {
        this.date_create = date_create;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public QuestionType getQuestions() {
        return questions;
    }

    public void setQuestions(QuestionType questions) {
        this.questions = questions;
    }
}
