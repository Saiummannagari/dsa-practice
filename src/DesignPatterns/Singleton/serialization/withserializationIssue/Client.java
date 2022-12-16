package DesignPatterns.Singleton.serialization.withserializationIssue;


import java.io.*;

public class Client {

    /*
     Serialization can also cause breakage of singleton property of singleton classes.
     Serialization is used to convert an object of byte stream and save in a file or send
     over a network. Suppose you serialize an object of a singleton class.
     Then if you de-serialize that object it will create a new instance and hence
     break the singleton pattern.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ChocolateBoiler boiler = ChocolateBoiler.getChocolateBoiler();
        //serializing
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
