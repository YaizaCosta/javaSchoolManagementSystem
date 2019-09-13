package Model;
import java.util.*;


/**
 * Class that has firstname, middle name and last name
 */
public class Name  {
    private String firstName, middleName, lastName;

    /**
     * Constructor
     * @param firstName
     * @param middleName
     * @param lastName
     */
    public Name(String firstName, String middleName, String lastName){
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
        }
/*
    /**
     * Method to compare firstName and order it to be displayed in the pane
     * of the application
     * @return
     */
        /*
       private class firstName implements Comparable <Name> {
           private final String firstName;

           public firstName(String firstName) {
               this.firstName = firstName;
           }


           @Override
           public int compareTo(Name firstName) {
               return this.firstName.compareToIgnoreCase(firstName.getFirstName());
           }
       }

       */

    /**
     * Gets first name
     * @return
     */

    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name
     * @param firstName
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Gets  middle name
     */

    public String getMiddleName() {
        return middleName;
    }
    /**
     * Sets middle name
     */

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * gets last name
     * @return
     */

    public String getLastName() {
        return lastName;
    }

    /**
     * sets last name
     * @param lastName
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
