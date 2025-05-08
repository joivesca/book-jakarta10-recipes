package com.onndoo.book.jakarta10.recipes.chapter4.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("com.onndoo.book.jakarta10.recipes.chapter4.converter.LowerConverter")
public class LowerConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return s.toLowerCase();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return o.toString().toLowerCase();
    }
}