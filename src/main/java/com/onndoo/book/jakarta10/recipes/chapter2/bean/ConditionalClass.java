package com.onndoo.book.jakarta10.recipes.chapter2.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ConditionalClass implements Serializable {
	
    private static final long serialVersionUID = 1L;
	
    private String typename = null;
    
    public static Set<String> javaTypes = new HashSet<>();

    public ConditionalClass() {
        javaTypes.add("byte");
        javaTypes.add("short");
        javaTypes.add("int");
        javaTypes.add("long");
        javaTypes.add("float");
        javaTypes.add("double");
        javaTypes.add("boolean");
        javaTypes.add("char");
    }

    public static boolean isPrimitive(String value){
        return javaTypes.contains(value.toLowerCase());
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}
