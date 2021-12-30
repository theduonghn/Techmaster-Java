import model.Car;

public class Main {
    public static void main(String[] args) throws Exception {
        // PersonService personService = new PersonService();
        // personService.createPerson();

        Car car = new Car("Ertiga", "red", "Maruti");
        car.speed(80);
        car.size("medium");
        System.out.println(car.getColor());
        car.setColor("white");
        System.out.println(car);
    }
}
