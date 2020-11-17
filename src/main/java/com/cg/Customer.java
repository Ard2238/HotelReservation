package com.cg;

public class Customer {
    String customerType;
    String customerName;

    public Customer(String customerType, String customerName) {
        this.customerType = customerType;
        this.customerName = customerName;
    }

    public String getCustomerType() { return customerType; }

    public void setCustomerType(String customerType) { this.customerType = customerType; }

    public String getCustomerName() { return customerName; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }
}
