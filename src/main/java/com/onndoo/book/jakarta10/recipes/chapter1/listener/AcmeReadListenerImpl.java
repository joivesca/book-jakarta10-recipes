package com.onndoo.book.jakarta10.recipes.chapter1.listener;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;

public class AcmeReadListenerImpl implements ReadListener{

	private ServletInputStream is =null;
	private AsyncContext async = null;
	
	public AcmeReadListenerImpl(ServletInputStream is, AsyncContext async) {
		this.is = is;
		this.async = async;
	}
	
	@Override
	public void onDataAvailable() throws IOException {
		System.out.println("onDataAvailable");
		
		try {
			StringBuilder sb = new StringBuilder();
			int len = -1;
			byte[] buffer = new byte[1024];
			
			while (is.isReady() && (len = is.read(buffer)) != -1) {
				String data = new String(buffer, 0, len);
                //sb.append(new String(buffer, 0, len));
				System.out.println(data);
            }
		} catch (IOException e) {
			Logger.getLogger(AcmeReadListenerImpl.class.getName())
			.log(Level.SEVERE, null,e);			
		}
		
	}

	@Override
	public void onAllDataRead() throws IOException {
		System.out.println("onAllDataRead");
		async.complete();		
	}

	@Override
	public void onError(Throwable t) {
		System.out.println("Error:" + t);
		async.complete();
	}

}
