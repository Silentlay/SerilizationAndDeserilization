package org;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true) // Игнорирую неизвестные свойства
public class Student implements Serializable {

    private String name;
    private int age;

    @JsonIgnore // Исключаю поле из сериализации и десериализации
    private transient double GPA;

    public Student() {}

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }
}
