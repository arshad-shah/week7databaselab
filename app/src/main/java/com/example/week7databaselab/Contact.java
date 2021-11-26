package com.example.week7databaselab;

public class Contact {

    /**
     * fields
     */
    private int _id;
    private String first_name;
    private String surname;
    private String city;

    /**
     * Constructor for Contact
     */
    public Contact(int _id, String first_name, String surname, String city) {
        this._id = _id;
        this.first_name = first_name;
        this.surname = surname;
        this.city = city;
    }

    public Contact() {

    }

    public Contact(String firstName, String surName, String city) {
        this.first_name = firstName;
        this.surname = surName;
        this.city = city;
    }

    /**
     * Getter for _id
     * @return _id
     */
    public int get_id() {
        return _id;
    }

    /**
     * Setter for _id
     * @param _id
     */
    public void set_id(int _id) {
        this._id = _id;
    }

    /**
     * Getter for first_name
     * @return first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Setter for first_name
     * @param first_name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Getter for surname
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Setter for surname
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Getter for city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for city
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }


    
}
