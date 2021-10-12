package vn.codegym.managerbook.entity;

import javax.persistence.*;

@Entity
public class Borrow {
    @Id
    private String code;
    @ManyToOne()
    @JoinColumn(name = "idBook",referencedColumnName = "idBook")
    private Book book;

    public Borrow() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
