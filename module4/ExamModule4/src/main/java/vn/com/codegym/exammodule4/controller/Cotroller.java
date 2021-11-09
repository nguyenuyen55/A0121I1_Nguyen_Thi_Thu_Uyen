package vn.com.codegym.exammodule4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.com.codegym.exammodule4.entity.Question;
import vn.com.codegym.exammodule4.repository.RepositoryQuestion;
import vn.com.codegym.exammodule4.repository.RepositoryQuestionType;
import vn.com.codegym.exammodule4.service.QuestionService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class Cotroller {
    @Autowired
    QuestionService questionService;
    @Autowired
    RepositoryQuestionType questionType;
    @Autowired
    RepositoryQuestion repositoryQuestion;
    @GetMapping("/index")
    public String index(){
        return "welcome";
    }
@GetMapping("/")
    public String getList(Model model, Pageable pac, @RequestParam("keyword") Optional<String> key){

    if (key.isPresent()) {
        model.addAttribute("questiontypes",questionType.findAll());
        model.addAttribute("search",key.get());
        model.addAttribute("questions",questionService.findAllByTitleContaining(pac,key.get()));
    } else {
        model.addAttribute("questiontypes",questionType.findAll());
        model.addAttribute("questions",questionService.findAll(pac));
    }
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("questiontypes",questionType.findAll());
        model.addAttribute("question",new Question());
        return "create";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,Model model){
        Optional<Question> question=  repositoryQuestion.findById(id);
        model.addAttribute("question",question);
        model.addAttribute("questiontypes",questionType.findAll());
        model.addAttribute("queId",question.get().getQuestions().getIdQuestionType());
        return "update";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id,Model model){
        Optional<Question> question=  repositoryQuestion.findById(id);
        model.addAttribute("question",question);
        model.addAttribute("questiontypes",questionType.findAll());
        model.addAttribute("queId",question.get().getQuestions().getIdQuestionType());
        return "update";
    }
    @PostMapping("/create")
    public String postcreate(@Validated @ModelAttribute Question question, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("questiontypes",questionType.findAll());
            model.addAttribute("question",question);
            return "/create";
        }
        question.setDate_create(LocalDate.now());
        question.setStatus(false);
       repositoryQuestion.save(question);
        return "redirect:/";
    }
    @PostMapping("/update")
    public String postcdir(@Validated @ModelAttribute Question question, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("question",question);
            model.addAttribute("questiontypes",questionType.findAll());
            model.addAttribute("queId",question.getQuestions().getIdQuestionType());
            return "/update";
        }

        question.setDate_create(LocalDate.now());
        repositoryQuestion.save(question);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String del(@PathVariable("id") int id){
        Optional<Question> question=  repositoryQuestion.findById(id);
        repositoryQuestion.delete(question.get());
        return "redirect:/";
    }
    @GetMapping("/error")
    public String erroe(){

        return "/message";
    }
    @ExceptionHandler(Exception.class)
    public String loi(Exception e){
        return "message";
    }

}
