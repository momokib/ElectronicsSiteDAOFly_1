/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
/**
 *
 * @author Gokhan
 */
public class Customer 
{
    private int customerID;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;
    private String phoneNumber;
    
    
    public Customer(int customerID, String firstName, String lastName, String streetAddress, String city, int zipCode, String state,String phoneNumber)
    {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
         this.zipCode = zipCode;
        this.state = state;
        this.phoneNumber = phoneNumber;
    }

    public int getcustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getState(){
        return state;
    }
    
    public int getZipCode(){
        return zipCode;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", streetAddress=" + streetAddress + ", city=" + city + ", zipCode=" + zipCode  + ", state=" + state + ", phoneNumber=" + phoneNumber + '}';
    }
}
