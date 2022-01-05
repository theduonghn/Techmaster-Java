public class Waiter extends Employee {
    private long compensate;

    public Waiter(int id, String name, int age, long basicSalary, long compensate) {
        super(id, name, age, basicSalary);
        this.compensate = compensate;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", compensate='" + MyFormat.formatVnd(getCompensate()) + "'"
                + ", salary='" + MyFormat.formatVnd(calculatorSalary()) + "'";
    }

    public long getCompensate() {
        return this.compensate;
    }

    public void setCompensate(long compensate) {
        this.compensate = compensate;
    }

    @Override
    public long calculatorSalary() {
        return getBasicSalary() + getCompensate();
    }
}
