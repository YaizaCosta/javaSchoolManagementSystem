package Model;

public class Person {
    /**
     * Attributes of a person
     */

    private String email;
    private String phoneNumber;
    //From Name class
    private Name name;
    private int personID = 1;
    public static int countPKPerson = 0;

    /**
     * Default constructor
     */

    public Person(){}

    /**
     * Constructor 2 passing firstname, middlename and last name
     * @param firstName
     * @param middleName
     * @param lastName
     */
    public Person(String firstName, String middleName, String lastName) {
        personID = ++countPKPerson;
     this.setName(firstName, middleName, lastName);
    }


    /**
     * Sets the name
     * @param firstName
     * @param middleName
     * @param lastName
     */
    public void setName(String firstName, String middleName, String lastName){
        this.name.setFirstName(firstName);
        this.name.setMiddleName(middleName);
        this.name.setLastName(lastName);
    }



    /**
     * Gets the name - firstname, middlename and lastname
     * @return fullname
     */
    public String getName() {
        String fullname = this.name.getFirstName() + " " + this.name.getMiddleName() +  " " + this.name.getLastName();
        return fullname;
    }


    /**
     * Gets email of the person
     * @return email
     */


    public String getEmail() {
        return email;
    }

    /**
     * Sets email of the person
     * @param email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets phone number of the person
     * @return phoneNumber
     */

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set phone number of the person
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Prints Name of Person
     */

    public void print() {
        System.out.println("ID : " + this.personID + "\n" +
                "Name: " + this.getName());

    }

    /**
     * Prints specific details to a student - Overloaded print method
     * @param dateOfB
     * @param email
     * @param phoneNumber
     */
    public void print(String dateOfB, String email, String phoneNumber) {
        System.out.println("ID : " + this.personID + "\n" +
                "Date of birth: " + dateOfB + "\n" +
                "Email:" + this.email +
                "Phone number: " + this.phoneNumber);
    }

    /**
     * Prints specific details to a teacher - Overloaded print method
     * @param degreeName
     */

    public void print(String degreeName) {
        System.out.println("ID : " + this.personID + "\n" +
                "Degree Name: " + degreeName);
    }
}



