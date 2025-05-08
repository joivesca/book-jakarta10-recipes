package com.onndoo.book.jakarta10.recipes.chapter3.controller;

import java.io.Serializable;
import java.util.Objects;

public final class Chapter implements Serializable {
    private final int chapterNumber;
    private final String title;
    private final String description;

    public Chapter(int chapterNumber, String title, String description) {
        this.chapterNumber = chapterNumber;
        this.title = title;
        this.description = description;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chapter)) return false;
        Chapter chapter = (Chapter) o;
        return chapterNumber == chapter.chapterNumber &&
               Objects.equals(title, chapter.title) &&
               Objects.equals(description, chapter.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chapterNumber, title, description);
    }

    @Override
    public String toString() {
        return "Chapter{" +
               "chapterNumber=" + chapterNumber +
               ", title='" + title + '\'' +
               ", description='" + description + '\'' +
               '}';
    }
}