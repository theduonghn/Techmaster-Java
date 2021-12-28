public class Dog {
    public String breed;
    public DogSize size;
    public String color;
    public int age;

    public Dog(String breed, DogSize size, String color, int age) {
        this.breed = breed;
        this.size = size;
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog [age=" + age + ", breed=" + breed + ", color=" + color + ", size=" + size.getValue() + "]";
    }

    public void eat(String food) {
        System.out.println("Dog eats " + food);
    }

    public void run() {
        System.out.println("Dog runs");
    }

    public void name(String name) {
        System.out.println("The dog's name is now " + name);
    }
}
