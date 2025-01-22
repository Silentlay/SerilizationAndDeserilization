package org;

import java.io.*;

public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person person = new Person("Наталия", 42);

        // Сериализация в bin
        try (FileOutputStream fileOutputStream = new FileOutputStream("person.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(person);
            System.out.println("Объект Person сериализован.");
        }

        // Десериализация в bin
        try (FileInputStream fileInputStream = new FileInputStream("person.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            person = (Person) objectInputStream.readObject();
            System.out.println("Объект Person десериализован.");
        }

        System.out.println("Объект Person десериализован.");
        System.out.println("Имя: " + person.getName());
        System.out.println("Возраст: " + person.getAge());
    }
}
