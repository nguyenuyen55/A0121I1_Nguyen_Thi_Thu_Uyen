package vn.com.codegym.manageblogajax.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nameCategory;
@JsonBackReference
    @OneToMany(mappedBy = "category", fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Blog> blogs;

    public Category() {
    }

    public Category(int id, String nameCategory, List<Blog> blogs) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.blogs = blogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
