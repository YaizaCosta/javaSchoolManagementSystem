package Model;

import java.util.*;

/**
 * This class is a collection of students
 */
public class Class {
    private ArrayList <Student> studentList = new ArrayList<>();



    public Class(){studentList = new ArrayList ();}

    /**
     * Gets studentlist
     * @return
     */
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    /**
     * Sets student list
     * @param studentList
     */
    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }



}
