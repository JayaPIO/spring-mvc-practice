package com.jaya.springMVC_learning.models;

import com.jaya.springMVC_learning.constants.MessageConstant;
import com.jaya.springMVC_learning.validation.OfferCode;
import jakarta.validation.constraints.*;

public class Customer {
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;
    private String lastName;
    @NotNull(message = "is required")
    @Min(value = 0, message = MessageConstant.MIN_VALUE)
    @Max(value = 10, message = MessageConstant.MAX_VALUE)
    private Integer orders;
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "should be 5 characters/digits")
    private String postalCode;
    @OfferCode(value = "AB", message = "must start with AB")
    private String code;

    public Customer() {
    }

    public Customer(String firstName, String lastName, Integer orders, String postalCode, String code) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
        this.postalCode = postalCode;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", orders=" + orders +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
