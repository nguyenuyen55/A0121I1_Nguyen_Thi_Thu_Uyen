package vn.codegym.managerbook.controller;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.managerbook.entity.Book;
import vn.codegym.managerbook.entity.Borrow;
import vn.codegym.managerbook.exception.ErrorCodeBook;
import vn.codegym.managerbook.exception.ValueLessThanZero;
import vn.codegym.managerbook.repository.BookRepository;
import vn.codegym.managerbook.repository.BorrowRepository;

import java.util.Random;

@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BorrowRepository borrowRepository;

    @GetMapping("listBook")
    public String getList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book/list";
    }

    @GetMapping("borrow/{id}")
    public String getIdBook(Model model, @PathVariable(name = "id") int id) {
        model.addAttribute("book", bookRepository.findById(id).get());
        String random = createRandomWord(5);
        model.addAttribute("wordRandom", random);
        Borrow borrow = new Borrow();
        borrow.setCode(random);
        borrow.setBook(bookRepository.findById(id).get());
        model.addAttribute("borrow", borrow);
        return "book/borrow";
    }

    public static String createRandomWord(int len) {
        String name = "";
        for (int i = 0; i < len; i++) {
            int v = 1 + (int) (Math.random() * 26);
            char c = (char) (v + (i == 0 ? 'A' : 'a') - 1);
            name += c;
        }
        return name;
    }

    @PostMapping("borrow/{id}")
    public String getIdBorrow(@ModelAttribute("borrow") Borrow borrow, Model model, @PathVariable(name = "id") int id) throws ValueLessThanZero {
        borrowRepository.save(borrow);
        Book book = bookRepository.findById(id).get();
        book.setQuantity(book.getQuantity() - 1);
        int flag = book.getQuantity();
        if (flag < 0) {
            throw new ValueLessThanZero();
        }
        bookRepository.save(book);
        return "redirect:/listBook";
    }

    @GetMapping("return/{id}")
    public String returnIdBook(Model model, @PathVariable(name = "id") int id) {
        model.addAttribute("book", bookRepository.findById(id).get());
        return "book/return";
    }

    @PostMapping("return/{id}")
    public String returnIdBookpost(Model model, @PathVariable(name = "id") int id, @RequestParam("code") String code) throws ErrorCodeBook {
        Borrow borrow;
        try {
            borrow = borrowRepository.findById(code).get();
        } catch (Exception e) {
            throw new ErrorCodeBook();
        }
        ;
        borrowRepository.delete(borrow);
        Book book = bookRepository.findById(id).get();
        book.setQuantity(book.getQuantity() + 1);

        bookRepository.save(book);
        return "redirect:/listBook";
    }

    @GetMapping("listCode")
    public String getListCode(Model model) {
        model.addAttribute("codes", borrowRepository.findAll());
        return "borrow/listCode";
    }

    @ExceptionHandler(ValueLessThanZero.class)
    public String show() {
        return "error/Zero";
    }

    @ExceptionHandler(ErrorCodeBook.class)
    public String showInputNotAcceptable() {
        return "error/ErrorCode";
    }
}
