package com.william.model;

public class CategoryModel {
    private int categoryID;
    private String nameCategory;
    private String Img_Category;

    public CategoryModel() {
    }

    public CategoryModel(int categoryID, String nameCategory, String img_Category) {
        this.categoryID = categoryID;
        this.nameCategory = nameCategory;
        Img_Category = img_Category;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public String getImg_Category() {
        return Img_Category;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public void setImg_Category(String img_Category) {
        Img_Category = img_Category;
    }
}
