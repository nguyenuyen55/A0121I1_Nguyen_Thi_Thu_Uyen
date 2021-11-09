package vn.com.codegym.exammodule4.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idQuestionType;
    private String name;

    public QuestionType() {
    }
    @OneToMany(mappedBy = "questions")
    private Set<Question> employees;

    public int getIdQuestionType() {
        return idQuestionType;
    }

    public void setIdQuestionType(int idQuestionType) {
        this.idQuestionType = idQuestionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Question> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Question> employees) {
        this.employees = employees;
    }
}
