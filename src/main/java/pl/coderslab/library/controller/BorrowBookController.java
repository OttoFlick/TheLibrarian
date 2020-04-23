package pl.coderslab.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.library.entity.*;
import pl.coderslab.library.model.Register;
import pl.coderslab.library.repository.BookRepository;
import pl.coderslab.library.repository.BorrowRepository;
import pl.coderslab.library.repository.UserRepository;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("user")
public class BorrowBookController {
    @Autowired
    private User user;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/borrow/{bookId}")
    public String borrow(@PathVariable int bookId, Model model){
        Optional<Book> book = bookRepository.findById(bookId);
        Borrowing b = new Borrowing();
        b.setBook(book.get());
        b.setCustomer(user.getCustomer());
        model.addAttribute("borrowing", b);

        return "borrow";
    }

    @PostMapping("/borrow/{bookId}")
    public String borrow(@Valid Borrowing borrowing, @PathVariable int bookId, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "borrow";
        } else {
            Optional<Book> book = bookRepository.findById(bookId);
            borrowing.setBook(book.get());
            borrowing.setCustomer(user.getCustomer());
            borrowRepository.save(borrowing);
        }

        return "redirect:/myBooks";
    }

    @RequestMapping("/myBooks")
    public String myBooks(Model model){
        model.addAttribute("borrowings", this.borrowRepository.findByCustomerId(user.getCustomer().getId()));

        return "mybooks";
    }

    @RequestMapping("/borrowings")
    public String borrowings(Model model){
        Collection<Borrowing> borrowings = borrowRepository.findAllActive();
        model.addAttribute("borrowings", borrowings);

        return "borrowings";
    }

    @RequestMapping("/return/{borrowingId}")
    public String returnBook(@PathVariable int borrowingId, Model model){
        borrowRepository.returnBook(borrowingId, LocalDate.now());

        return "redirect:/borrowings";
    }
}