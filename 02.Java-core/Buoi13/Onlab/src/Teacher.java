public class Teacher extends Person {
    long salary;

    public Teacher(int id, String name, long salary) {
        super(id, name);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                " salary='" + getSalary() + "'";
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

}
