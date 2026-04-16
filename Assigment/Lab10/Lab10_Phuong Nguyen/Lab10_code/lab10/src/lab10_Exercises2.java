import lab10_2a.Employee;

public class lab10_Exercises2 {
    void evaluator() {
        // A. (Employee e) -> e.getName()
        Employee emp = new Employee("Phuong");
        System.out.println("A. Name: " + getName2.apply(emp));

        // B. (Employee e, String s) -> e.setName(s)
        setName2.accept(emp, "Nguyen");
        System.out.println("B. New Name: " + emp.getName());

        // C. (String s1, String s2) -> s1.compareTo(s2)
        System.out.println("C. Comparison: " + compare2.apply("apple", "banana"));

        // D. (Integer x, Integer y) -> Math.pow(x, y)
        System.out.println("D. Power: " + pow2.apply(2, 10));

        // E. (Apple a) -> a.getWeight()
        Apple apple = new Apple(150);
        System.out.println("E. Apple Weight: " + getWeight2.apply(apple));

        // F. (String x) -> Integer.parseInt(x)
        System.out.println("F. Parsed Integer: " + parse2.apply("123"));

        // G. (Employee e1, Employee e2) -> comp.compare(e1, e2)
        Employee e1 = new Employee("Alice");
        Employee e2 = new Employee("Bob");
        System.out.println("G. Comparator Result: " + compareEmps2.compare(e1, e2));
    }
}
