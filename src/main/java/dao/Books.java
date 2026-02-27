package dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Books {

    @Id
    private int book_id;
    private String book_name;

    @ManyToOne
    private Authors author;

    private int book_qty;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public int getBook_qty() {
        return book_qty;
    }

    public void setBook_qty(int book_qty) {
        this.book_qty = book_qty;
    }

    @Override
    public String toString() {
        return "Books{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", author=" + author +
                ", book_qty=" + book_qty +
                '}';
    }
}
