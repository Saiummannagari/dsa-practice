package DesignPatterns.Singleton.serialization.withoutserializationIssue;


import java.io.*;

public class Client {

    /*
    To overcome serialization issue, we have to implement method readResolve() method in ChocolateBoiler
    The readResolve method is called when ObjectInputStream has read an object from the stream and
    is preparing to return it to the caller.
    ObjectInputStream checks whether the class of the object defines the readResolve method.
     If the method is defined, the readResolve method is called to allow the object in the stream
     to designate the object to be returned.
     The object returned should be of a type that is compatible with all uses.
     If it is not compatible, a ClassCastException will be thrown when the type mismatch is discovered.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ChocolateBoiler boiler = ChocolateBoiler.getChocolateBoiler();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
        out.writeObject(boiler);
        out.close();

        // deserialize from file to object
        ObjectInput in
                = new ObjectInputStream(new FileInputStream("file.text"));

        ChocolateBoiler boiler2 = (ChocolateBoiler) in.readObject();
        in.close();
        System.out.println("instance1 hashCode:- "
                + boiler.hashCode());
        System.out.println("instance2 hashCode:- "
                + boiler2.hashCode());
    }
}
