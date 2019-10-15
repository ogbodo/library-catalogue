package com.paga.librarycatalogue.model;

import java.util.UUID;

public class Catalogue {
    private final UUID id;
    private final String serialNumber;
    private final String title;
    private final String author;
    private final String releaseYear;
    private final String genre;

    public Catalogue(UUID id, String serialNumber, String title, String author, String releaseYear, String genre) {
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

}