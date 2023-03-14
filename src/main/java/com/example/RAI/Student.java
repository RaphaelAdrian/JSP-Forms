package com.example.RAI;

import java.util.function.Supplier;

public class Student {


    private String productCode, description, price,  classification, supplier, availability;



    public Student() {

        super();

    }


    public Student(String productCode, String description, String price, String classification, String supplier, String availability) {

        super();

        this.productCode = productCode;

        this.description = description;

        this.price = price;

        this.classification = classification;

        this.supplier = supplier;

        this.availability = availability;

    }


    public String getProductCode() {

        return productCode;

    }


    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public void setDescription()
    {
        this.description = description;

    }

    public String getDescription() {

        return description;

    }


    public void setPrice(String price) {

        this.price = price;

    }

    public String getPrice() {

        return price;
    }


    public String getClassification() {

        return classification;

    }


    public void setClassification(String classification) {

        this.classification = classification;

    }


    public String getSupplier() {

        return supplier;

    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;

    }

    public String getAvailability() {
        return availability;

    }

    public void setAvailability(String availability) {

        this.availability = availability;

    }


}
