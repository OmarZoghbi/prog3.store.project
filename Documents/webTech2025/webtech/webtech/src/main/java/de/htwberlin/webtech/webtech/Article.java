package de.htwberlin.webtech.webtech;


public class Article {

    private String name;
    private String description;
    private boolean available;

    public Article(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setTitle(String name) {
        this.name = name;
    }
}