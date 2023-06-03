package nguyenhoangthinh.quanlysachCSDLlap3.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
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
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Book(long id, String title, String author, Double price, String Category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
       this.category= category;
    }

    public Book(){};

}