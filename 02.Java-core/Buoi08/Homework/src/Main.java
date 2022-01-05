public class Main {
    public static void main(String[] args) throws Exception {
        Employee[] employees = EmployeeService.createAll();
        EmployeeService.showAll(employees);
    }
}
