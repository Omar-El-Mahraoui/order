package com.mygroupid.api.customers;
// copied and adapted code from funiversity example switchfully

import java.util.Objects;

public class CustomerDto {

    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address;
    private String phoneNumber;

    private CustomerDto() {
    }

    public static CustomerDto customerDto() {
        return new CustomerDto();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CustomerDto withId(String id) {
        this.id = id;
        return this;
    }

    public CustomerDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerDto withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public CustomerDto withAddress(String address) {
        this.address = address;
        return this;
    }

    public CustomerDto withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(emailAddress, that.emailAddress) &&
                Objects.equals(address, that.address) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, emailAddress, address, phoneNumber);
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
