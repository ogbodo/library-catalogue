package com.paga.librarycatalogue.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Catalogue {
    private UUID id;
    private String serialNumber;
    @NotBlank
    private final String title;
    @NotBlank
    private final String author;
    @NotBlank
    private final String releaseYear;
    @NotBlank
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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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
        criteria = criteria.toLowerCase();
        return (this.author.toLowerCase().contains(criteria) || this.genre.toLowerCase().contains(criteria)
                || this.releaseYear.toLowerCase().contains(criteria)
                || this.serialNumber.toLowerCase().contains(criteria) || this.title.toLowerCase().contains(criteria));

    }

}