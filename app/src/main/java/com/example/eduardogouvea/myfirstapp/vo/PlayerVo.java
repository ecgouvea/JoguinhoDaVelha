package com.example.eduardogouvea.myfirstapp.vo;

/**
 * Created by eduardo.gouvea on 16/01/2016.
 */
public class PlayerVo {
    private String name;
    private String imagePath;

    public PlayerVo(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
