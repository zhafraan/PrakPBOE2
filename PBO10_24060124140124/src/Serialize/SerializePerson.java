package Serialize;
/**
 * File: SerializePerson.java
 * Deskripsi: Program untuk serialisasi objek Person
 * @author Zhafran
 */
import java.io.*;
// class Person
class Person implements Serializable {
    private String name;
    
    public Person(String n) {
        this.name = n;
    }
    
    public String getName() {
        return this.name;
    }
}

// class SerializePerson
public class SerializePerson {
    public static void main(String[] args) {
        Person person = new Person("Aqilll");
        
        try {
            FileOutputStream f = new FileOutputStream("person.ser");
            ObjectOutputStream s = new ObjectOutputStream(f);
            s.writeObject(person);
            System.out.println("selesai menulis objek person");
            s.close();
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
