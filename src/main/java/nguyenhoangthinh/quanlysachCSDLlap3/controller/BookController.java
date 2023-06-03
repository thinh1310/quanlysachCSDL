package nguyenhoangthinh.quanlysachCSDLlap3.controller;

import nguyenhoangthinh.quanlysachCSDLlap3.entity.Book;
import nguyenhoangthinh.quanlysachCSDLlap3.services.BookService;
import  nguyenhoangthinh.quanlysachCSDLlap3.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllBooks(Model model) {
        List<Book> books = bookService.GetAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model)
    {
        model.addAttribute("book" ,new Book());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "book/add";

    }
    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors())
        {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/add";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }
  //  @GetMapping("/books/{id}")
   // public String showDeleteBookForm(@PathVariable("id") Long id, Model model) {
   //     Book book = bookService.getBookById(id);
  //      model.addAttribute("book", book);
  //      return "delete-books";
  //  }
 //   @PostMapping("/books/{id}")
 //   public String deleteBook(@PathVariable("id") Long id) {
  //      bookService.deleteBook(id);
  //      return "redirect:/books";
 //   }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id,Model model)
    {
        Book book = bookService.getBookById(id);
        bookService.deleteBook(id);
        model.addAttribute("book",book);
        return "redirect:/books";


    }
    @GetMapping("/edit/{id}")
    public String showEditPage(@PathVariable("id") Long id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book",book);
        model.addAttribute("selectedCategoryId",book.getCategory().getId());
        model.addAttribute("categories",categoryService.getAllCategories());

        return "book/edit";
    }
    @PostMapping("/edit")
    public String editBook(@ModelAttribute("book") Book book){
        bookService.updateBook(book);
        return "redirect:/books";

    }


}
