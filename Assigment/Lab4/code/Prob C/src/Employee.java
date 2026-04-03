public abstract class Employee {
    protected int empId;

    public Employee(int empId) {
        this.empId = empId;
    }

    public void print() {
        System.out.println("Employee ID: " + empId);
    }

    // Template Method
    public Paycheck calcCompensation(int month, int year) {
        double grossPay = calcGrossPay(month, year);
        return new Paycheck(grossPay);
    }

    protected abstract double calcGrossPay(int month, int year);
}