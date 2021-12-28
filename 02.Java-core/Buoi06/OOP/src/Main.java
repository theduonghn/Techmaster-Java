public class Main {
    public static void main(String[] args) throws Exception {
        // Animal cat = new Animal();
        // cat.name = "Puss";
        // cat.age = 3;
        // cat.leg = 4;
        // cat.color = "pink";

        // System.out.println(cat);
        // cat.eat("fish");

        // Animal dog = new Animal("Doge", 2, 4, "yellow");
        // System.out.println(dog);

        // Person duong = new Person(1, "Duong", 24, Gender.MALE, "Ha Noi");
        // System.out.println(duong);
        // duong.job("design MEP");
        // duong.hobby("read books");
        // System.out.println(duong.school);

        // Dog john = new Dog("Pit bull", DogSize.LARGE, "black", 4);
        // System.out.println(john);
        // john.eat("bone");
        // john.run();
        // john.name("John");

        // PersonService personService = new PersonService();
        // Person[] persons = personService.addPerson(3);
        // personService.show(persons);

        StudentService studentService = new StudentService();

        Student student1 = new Student(1, "Pham The Duong", 9, 7, "NUCE");
        System.out.println(student1);
        System.out.printf("Diem trung binh: %.2f\n", studentService.getAveragePoint(student1));

        Student student2 = studentService.inputStudent();
        System.out.println(student2);
        System.out.printf("Diem trung binh: %.2f\n", studentService.getAveragePoint(student2));
    }
}
