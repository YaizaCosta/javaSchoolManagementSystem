package Model;

import java.util.*;

/**
 * This class has a collection of classes.
 */
public class School {

    private ArrayList <Class> cl = new ArrayList<>();

     public School(){cl = new ArrayList<>();}

     public ArrayList<Class>getcl(){return cl;}

     public void setCl(ArrayList<Class> cl){
     this.cl = cl;
     }
 }

