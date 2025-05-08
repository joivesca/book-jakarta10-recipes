package com.onndoo.book.jakarta10.recipes.chapter4.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Subscription implements Serializable {
    private List<Contact> subscriptionList;

    public Subscription() {
        subscriptionList = new ArrayList<>();
    }

    public List<Contact> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(List<Contact> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

}