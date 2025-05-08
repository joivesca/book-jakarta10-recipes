package com.onndoo.book.jakarta10.recipes.chapter4.controller;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "ch3SubscriptionController")
@SessionScoped
public class SubscriptionController implements Serializable {
    private List<Contact> subscriptionList;

    /**
     * Creates a new instance of SubscriptionController
     */
    public SubscriptionController() {
        subscriptionList = new ArrayList();
    }

    /**
     * @return the subscriptionList
     */
    public List <Contact> getSubscriptionList() {
        return subscriptionList;
    }

    /**
     * @param subscriptionList the subscriptionList to set
     */
    public void setSubscriptionList(List <Contact> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }
}