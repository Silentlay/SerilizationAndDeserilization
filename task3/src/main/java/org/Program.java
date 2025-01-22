package org;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Создаю объект
        Student student = new Student("Максим", 18, 4.5);

        // Сериализация в bin
        try (FileOutputStream fileOutputStream = new FileOutputStream("students.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(student);
            System.out.println("Объект Student сериализован в bin.");
        }

        // Десериализация из bin
        try (FileInputStream fileInputStream = new FileInputStream("students.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            student = (Student) objectInputStream.readObject();
            System.out.println("Объект Student десериализован из bin.");
        }

        System.out.println("Объект Student десериализован.");
        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний бал: (double GPA должен быть 0.0, так как transient): " + student.getGPA());

        // Сериализация в XML
        XmlMapper xmlMapper = new XmlMapper();
        File xmlFile = new File("student.xml");
        xmlMapper.writeValue(xmlFile, student);
        System.out.println("Объект Student сериализован в XML.");

        // Десериализация из XML
        Student deserializedFromXml;
        deserializedFromXml = xmlMapper.readValue(xmlFile, Student.class);
        System.out.println("Объект Student десериализован из XML.");
        System.out.println("Имя: " + deserializedFromXml.getName());
        System.out.println("Возраст: " + deserializedFromXml.getAge());
        System.out.println("Средний бал: (должен быть 0.0, так как transient): " + deserializedFromXml.getGPA());

        // Сериализация в JSON
        ObjectMapper jsonMapper = new ObjectMapper();
        File jsonFile = new File("student.json");
        jsonMapper.writeValue(jsonFile, student);
        System.out.println("Объект Student сериализован в JSON.");

        // Десериализация из JSON
        Student deserializedFromJson = jsonMapper.readValue(jsonFile, Student.class);
        System.out.println("Объект Student десериализован из JSON.");
        System.out.println("Имя: " + deserializedFromJson.getName());
        System.out.println("Возраст: " + deserializedFromJson.getAge());
        System.out.println("Средний бал: (должен быть 0.0, так как transient): " + deserializedFromJson.getGPA());
    }
}