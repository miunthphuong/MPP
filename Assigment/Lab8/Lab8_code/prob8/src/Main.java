public class Main {
    public static void main(String[] args) {
        EmployeeRepository repo = new EmployeeRepository();

        // 1. Create
        Employee newEmp = new Employee(116, "Phuong Nguyen", 120000, 1, 1);
        repo.create(newEmp);

        // 2. Find All
        System.out.println("All employees: " + repo.findAll().size());

        // 3. Find By Id
        Employee found = repo.findById(116);
        System.out.println("Found: " + (found != null ? found.getName() : "Not found"));

        // 4. Update
        if (found != null) {
            found.setName("Phuong Updated");
            repo.update(found);
        }

        // 5. Delete
        repo.delete(116);

        // 6. Confirm Deletion
        System.out.println("Final count: " + repo.findAll().size());
    }
}
