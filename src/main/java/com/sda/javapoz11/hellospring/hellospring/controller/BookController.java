package com.sda.javapoz11.hellospring.hellospring.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
public class BookController {

    @PostMapping("/books")
    public void addBook(@Valid @RequestBody BookDto bookDto) {
        System.out.println(bookDto);
    }

    public static class BookDto {
        private String author;
        private String country;
        private String language;
        @NotNull
        private String link;
        private String https;
        @Min(value = 1, message = "Ksiazka musi miec conajmniej 1 strone")
        private Integer pages;
        private String title;
        private String year;

        @JsonCreator
        public BookDto(
                @JsonProperty("author") @NotEmpty String author,
                @JsonProperty("country") String country,
                @JsonProperty("language") String language,
                @JsonProperty("link") String link,
                @JsonProperty("https") String https,
                @JsonProperty("pages") Integer pages,
                @JsonProperty("title") String title,
                @JsonProperty("year") String year) {
            this.author = author;
            this.country = country;
            this.language = language;
            this.link = link;
            this.https = https;
            this.pages = pages;
            this.title = title;
            this.year = year;
        }
    }
}
