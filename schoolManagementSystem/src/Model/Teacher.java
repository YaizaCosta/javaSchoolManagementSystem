package Model;

public class Teacher extends Person  {

    /**
     * Specific attributes to a Teacher
     */
    private String degreeName;

    /**
     * Constructor 1 - Default constructor
     */
  //  public Teacher(){

  //  }

    /**
     * Constructor 2 - Overloaded from class Person
     * @param degreeName
     *
     */

    public Teacher (String degreeName, String firstName, String middleName, String lastName){
        this.degreeName = degreeName;
        super.setName(firstName, middleName,lastName);

    }

    /**
     * Gets degree name of the Teacher
     * @return degreeName
     */

    public String getDegreeName() {
        return degreeName;
    }

    /**
     * Sets the degree name of the Teacher
     * @param degreeName
     */

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    /**
     * Prints the details of the Teacher overloading the super class Person method
     */

    public void print (){
        super.print(this.degreeName);
    }

}
