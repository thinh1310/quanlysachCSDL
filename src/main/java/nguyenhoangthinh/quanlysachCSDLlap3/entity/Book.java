package nguyenhoangthinh.quanlysachCSDLlap3.entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import nguyenhoangthinh.quanlysachCSDLlap3.validator.annotation.ValidUsernameValidator;
import nguyenhoangthinh.quanlysachCSDLlap3.validator.annotation.ValidUserId;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",length = 50)
    @Size(max = 50, message = "Title must be less than 50 characters")
    @NotNull(message = "Title must be not null")
    private String title;

    @Column(name = "author", length = 50)
    @Size(max = 50, message = "Title must be less than 50 characters")
    private String author;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Column(name = "price")
    @NotNull(message = "Price must be greater than 0")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName ="id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ValidUserId
    private User user;

    public Book(long id, String title, String author, Double price, String Category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
       this.category= category;
    }

    public Book(){};

}