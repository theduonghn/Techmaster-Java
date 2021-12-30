package service;

import model.Person;

public class PersonService {
    public void createPerson() {
        Person person = new Person("Duong", 24, "HN");

        System.out.println(person);

        person.setName("Pham The Duong");

        System.out.println(person);
        System.out.println(person.getName());
    }
}
