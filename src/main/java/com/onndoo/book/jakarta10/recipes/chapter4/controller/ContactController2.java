package com.onndoo.book.jakarta10.recipes.chapter4.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;


@RequestScoped
@Named(value= "contactController2")
public class ContactController2 {
    private Contact current;
    private Subscription subscription;
    private String newsletterDescription;

    public String getNewsletterDescription() {
        return newsletterDescription;
    }
    public void setNewsletterDescription(String newsletterDescription) {
        this.newsletterDescription = newsletterDescription;
    }

    public Subscription getSubscription() {
        if (subscription == null) {
            subscription = new Subscription();
        }
        return subscription;
    }

    public Contact getCurrent() {
        if (current == null) {
            current = new Contact();
        }
        return current;
    }

    public ContactController2() {
        current = null;
        newsletterDescription = "Enter your information below in order to be " +
                "added to the Acme Bookstore newsletter.";
        subscription = new Subscription();
    }

    public String subscribe(){
        // Using a list implementation for now,
        // but will add to a database table in Chapter 7
        // Add the current contact to the subscription list
        subscription.getSubscriptionList().add(current);
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Successfully Subscribed to Newsletter for " + getCurrent().getEmail(), null);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        return "SUBSCRIBE";
    }

    /**
     * This method will allow a user to navigate to the manageAccount view.
     * This method will be moved into another managed bean that focuses on
     * authentication later on.
     * @return
     */
    public String manage(){
        return "./manageAccount.xhtml";
    }


    /**
     * Navigational method
     * @return String
     */
    public String add(){
        return "ADD_SUBSCRIBER";
    }
}
