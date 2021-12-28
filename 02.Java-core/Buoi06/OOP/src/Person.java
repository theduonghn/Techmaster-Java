public class Person {
    public int id;
    public String name;
    public int age;
    public Gender gender;
    public String address;

    

    public static String school = "Techmaster";

    public Person(int id, String name, int age, Gender gender, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person [address=" + address + ", age=" + age + ", gender=" + gender + ", id=" + id + ", name=" + name
                + ", school=" + school + "]";
    }

    public void job(String target) {
        System.out.println(name + " does " + target);
    }

    public void sleep() {
        System.out.println(name + " sleeps");
    }

    public void hobby(String target) {
        System.out.println(name + " does hobby " + target);
    }
}
