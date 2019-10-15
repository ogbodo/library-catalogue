package com.paga.librarycatalogue.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Catalogue {
    private final UUID id;
    private final String serialNumber;
    private final String title;
    private final String author;
    private final String releaseYear;
    private final String genre;

    public Catalogue(@JsonProperty("id") UUID id, @JsonProperty("serialNumber") String serialNumber,
            @JsonProperty("title") String title, @JsonProperty("author") String author,
            @JsonProperty("releaseYear") String releaseYear, @JsonProperty("genre") String genre) {

        this.id = id;
        this.serialNumber = serialNumber;
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public UUID getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public Boolean isAMatch(String criteria) {
        return (this.author.contains(criteria) || this.genre.contains(criteria) || this.releaseYear.contains(criteria)
                || this.serialNumber.contains(criteria) || this.title.contains(criteria));

    }

}