package com.example.proyectoahorromovil.Fragments.Awards;

public class CardAward {
    private String title;
    private String description;
    private int thumbail;

    public CardAward(String title, String description, int thumbail) {
        this.title = title;
        this.description = description;
        this.thumbail = thumbail;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getThumbail() { return thumbail; }
    public void setThumbail(int thumbail) { this.thumbail = thumbail; }
}
