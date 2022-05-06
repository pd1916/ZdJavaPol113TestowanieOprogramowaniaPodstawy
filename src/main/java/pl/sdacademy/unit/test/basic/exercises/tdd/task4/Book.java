package pl.sdacademy.unit.test.basic.exercises.tdd.task4;

import java.util.Objects;

public class Book {
    private final String title;
    private final Author author;
    private final float price;

    public Book(String title, Author author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Float.compare(book.price, price) == 0 && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price);
    }
}