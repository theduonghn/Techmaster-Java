public class EmployeeService {
    public static Employee[] createAll() {
        Waiter w1 = new Waiter(1, "Trinh Tung", 30, 7800000, 3700000);
        Waiter w2 = new Waiter(2, "Linh San", 26, 8300000, 1200000);
        Kitchen k1 = new Kitchen(3, "Thu Cuc", 18, 6300000, 2100000);
        Kitchen k2 = new Kitchen(4, "Gia Van", 21, 11500000, 6500000);
        Employee[] employees = { w1, w2, k1, k2 };
        return employees;
    }

    public static void showAll(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
