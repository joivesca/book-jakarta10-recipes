package com.onndoo.book.jakarta10.recipes.chapter4.listener;

import jakarta.faces.application.Application;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.PostConstructApplicationEvent;
import jakarta.faces.event.PreDestroyApplicationEvent;
import jakarta.faces.event.SystemEvent;
import jakarta.faces.event.SystemEventListener;

public class BookstoreAppListener implements SystemEventListener {

	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {
		if (event instanceof PostConstructApplicationEvent){
            System.out.println("The application has been constructed...");
        }
        if (event instanceof PreDestroyApplicationEvent){
            System.out.println("The application is being destroyed...");
        }		
	}

	@Override
	public boolean isListenerForSource(Object source) {
		return (source instanceof Application);
	}

}
