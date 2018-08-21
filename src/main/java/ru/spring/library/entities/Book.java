package ru.spring.library.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    private int bookId;
    private String name;
    private String content;
    private int pageCount;
    private String isbn;
    private int pubisherYear;
    private String image;
    private String desor;
    private Integer raiting;
    private Integer voteCount;
    private Author authorId;
    private Genre genreId;
    private Publisher publisherId;

    public Book(){

    }
    public Book(int id, Author author, Genre genre, Publisher publisher, String name, String content, Integer pageCount, String isbn, int publishYear, String image, String desor, Integer raiting, Integer voteCount) {
        this.bookId = id;
        this.authorId = author;
        this.genreId = genre;
        this.publisherId = publisher;
        this.name = name;
        this.content = content;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.pubisherYear = publishYear;
        this.image = image;
        this.desor = desor;
        this.raiting = raiting;
        this.voteCount = voteCount;
    }
    @Id
    @Column(name = "book_id", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 150)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "pageCount", nullable = false)
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Basic
    @Column(name = "isbn", nullable = false, length = 50)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "pubisherYear", nullable = false)
    public int getPubisherYear() {
        return pubisherYear;
    }

    public void setPubisherYear(int pubisherYear) {
        this.pubisherYear = pubisherYear;
    }

    @Basic
    @Column(name = "image", nullable = false, length = 150)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "desor", nullable = false, length = 50)
    public String getDesor() {
        return desor;
    }

    public void setDesor(String desor) {
        this.desor = desor;
    }

    @Basic
    @Column(name = "raiting", nullable = true)
    public Integer getRaiting() {
        return raiting;
    }

    public void setRaiting(Integer raiting) {
        this.raiting = raiting;
    }

    @Basic
    @Column(name = "voteCount", nullable = true)
    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (bookId != book.bookId) return false;
        if (pageCount != book.pageCount) return false;
        if (pubisherYear != book.pubisherYear) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (content != null ? !content.equals(book.content) : book.content != null) return false;
        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if (image != null ? !image.equals(book.image) : book.image != null) return false;
        if (desor != null ? !desor.equals(book.desor) : book.desor != null) return false;
        if (raiting != null ? !raiting.equals(book.raiting) : book.raiting != null) return false;
        if (voteCount != null ? !voteCount.equals(book.voteCount) : book.voteCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + pageCount;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + pubisherYear;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (desor != null ? desor.hashCode() : 0);
        result = 31 * result + (raiting != null ? raiting.hashCode() : 0);
        result = 31 * result + (voteCount != null ? voteCount.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "author_id", nullable = false)
    public Author getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Author author) {
        this.authorId = author;
    }

    @Basic
    @Column(name = "genre_id", nullable = false)
    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(Genre genreId) {
        this.genreId = genreId;
    }

    @Basic
    @Column(name = "publisher_id", nullable = false)
    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }
}
