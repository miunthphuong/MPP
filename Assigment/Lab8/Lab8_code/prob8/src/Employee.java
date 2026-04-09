public class Employee {
    private int empId;
    private String name;
    private double salary;
    private Integer addressId;
    private Integer deptId;

    public Employee() {}

    public Employee(int empId, String name, double salary, Integer addressId, Integer deptId) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.addressId = addressId;
        this.deptId = deptId;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public Integer getDeptId() {
        return deptId;
    }
}