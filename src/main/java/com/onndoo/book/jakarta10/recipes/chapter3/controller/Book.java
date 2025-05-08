package com.onndoo.book.jakarta10.recipes.chapter3.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public final class Book implements Serializable {
    private final String title;
    private final String image;
    private final List<Chapter> chapters;

    public Book(String title, String image, List<Chapter> chapters) {
        this.title = title;
        this.image = image;
        this.chapters = chapters;
    }

    // Second constructor (like your shortened one)
    public Book(String title, String image) {
        this(title, image, null);
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
               Objects.equals(image, book.image) &&
               Objects.equals(chapters, book.chapters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, image, chapters);
    }

    @Override
    public String toString() {
        return "Book{" +
               "title='" + title + '\'' +
               ", image='" + image + '\'' +
               ", chapters=" + chapters +
               '}';
    }
}