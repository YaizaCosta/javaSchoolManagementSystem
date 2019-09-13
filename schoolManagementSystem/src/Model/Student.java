package Model;

import java.util.ArrayList;

/**
 * Student "is a" type of relationship to Person - extends Person
 */

public class Student  extends Person{



    /**
     * Attributes specific to a Student
     */
    private String dOB;
    private ArrayList<Module> moduleList = new ArrayList<>();

    //mention to the module grades objects

    /**
     * Constructor 1 - Default
     */
    public Student(){

    }

    /**
     * Constructor 2 - Overloaded from Person class
     */

    public Student(String dOB, String firstName, String middleName, String lastName, String email, String phoneNumber){
        super.setName(firstName, middleName,lastName);
        super.setEmail(email);
        super.setPhoneNumber(phoneNumber);
        this.dOB = dOB;

    }


    /**
     * Gets the date of birth of the student
     * @return doB
     */
    public String getdOB() {
        return dOB;
    }

    /**
     * Sets the date of birth of the student
     * @param dOB
     */

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    /**
     * Prints specific details of the Student, overloading the super class method in Person
     */
    public void print (){
        super.print(this.dOB);
}

}
