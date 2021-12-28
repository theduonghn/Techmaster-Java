public class Animal {
    public String name;
    public int age;
    public int leg;
    public String color;

    public Animal() {
        System.out.println("Goi toi constructor");
    }

    public void eat(String food) {
        System.out.println(name + " eat " + food);
    }

    public Animal(String name, int age, int leg, String color) {
        this.name = name;
        this.age = age;
        this.leg = leg;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Animal [age=" + age + ", color=" + color + ", leg=" + leg + ", name=" + name + "]";
    }

}
