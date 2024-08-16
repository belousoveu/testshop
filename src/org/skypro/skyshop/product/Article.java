package org.skypro.skyshop.product;

import org.skypro.skyshop.service.Searchable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class Article implements Searchable {
    static final String PATH = "resource/articles/";
    private final String title;
    private final String content;

    public Article(String title, String content) throws IllegalArgumentException {
        if (title == null || content == null) {
            throw new IllegalArgumentException("Заголовок или содержание статьи не могут быть null");
        }
        this.title = title;
        this.content = content;
    }

    public Article(String filename) throws IOException {
        this.title = filename.substring(0, filename.lastIndexOf('.'));
        this.content = new String(Files.readAllBytes(Paths.get(PATH + filename)));
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(title).append('\n');
        sb.append(content);
        return sb.toString();
    }

    public String searchArea() {
        return this.toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getContentName() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
