package com.onndoo.book.jakarta10.recipes.chapter3.controller;

public class Employee {
	private final String getEmployeeFirst;
    private final String getEmployeeLast;
    private final String getEmployeeTitle;

    public Employee(String getEmployeeFirst, String getEmployeeLast, String getEmployeeTitle) {
        this.getEmployeeFirst = getEmployeeFirst;
        this.getEmployeeLast = getEmployeeLast;
        this.getEmployeeTitle = getEmployeeTitle;
    }

    public String getEmployeeFirst() {
        return getEmployeeFirst;
    }

    public String getEmployeeLast() {
        return getEmployeeLast;
    }

    public String getEmployeeTitle() {
        return getEmployeeTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee that = (Employee) o;
        return getEmployeeFirst.equals(that.getEmployeeFirst)
            && getEmployeeLast.equals(that.getEmployeeLast)
            && getEmployeeTitle.equals(that.getEmployeeTitle);
    }

    @Override
    public int hashCode() {
        int result = getEmployeeFirst.hashCode();
        result = 31 * result + getEmployeeLast.hashCode();
        result = 31 * result + getEmployeeTitle.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "getEmployeeFirst='" + getEmployeeFirst + '\'' +
                ", getEmployeeLast='" + getEmployeeLast + '\'' +
                ", getEmployeeTitle='" + getEmployeeTitle + '\'' +
                '}';
    }
}
