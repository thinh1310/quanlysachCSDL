package nguyenhoangthinh.quanlysachCSDLlap3.controller;

import nguyenhoangthinh.quanlysachCSDLlap3.entity.Book;
import nguyenhoangthinh.quanlysachCSDLlap3.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String showAllBooks(Model model) {
        List<Book> books = bookService.GetAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }
}
