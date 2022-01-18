public class Main {
    public static void main(String[] args) throws Exception {
        PersonModel<Student> personModel = new PersonModel<>();
        personModel.add(new Student(1, "Duong", 25));
        personModel.add(new Student(2, "Linh", 19));
        personModel.display();

        PersonModel<Employee> employeeModel = new PersonModel<>();
        employeeModel.add(new Employee(3, "Ngoc", 17));
        employeeModel.add(new Employee(24, "Trinh", 23));
        employeeModel.display();
    }
}
