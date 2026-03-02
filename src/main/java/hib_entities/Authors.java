package hib_entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Authors {

    @Id
    private int author_id;
    private String name;

    @OneToMany (mappedBy = "author", fetch = FetchType.EAGER)
    List<Books> books;

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "author_id=" + author_id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
