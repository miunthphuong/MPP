import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Address add1 = new Address("500 E Broadway Ave", "Fairfield", "IA", 52556);
        Address add2 = new Address("103 W Adams Ave", "Fairfield", "IA", 52556);

        Section cs545_1 = new Section(900, "CS545");
        Section cs545_2 = new Section(901, "CS545");
        Section cs401 = new Section(902, "CS401");
        Section cs221 = new Section(903, "CS221");

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(111, "Yasmeen", new ArrayList<>(Arrays.asList(3.9, 4.0, 3.7)), add1,
                        new ArrayList<>(Arrays.asList(cs545_1, cs401))),
                new Student(112, "Mira", new ArrayList<>(Arrays.asList(4.0, 4.0, 3.9)), add1,
                        new ArrayList<>(Arrays.asList(cs545_2, cs401, cs221))),
                new Student(113, "Zaina", new ArrayList<>(Arrays.asList(3.6, 3.3, 3.7)), add1,
                        new ArrayList<>(Arrays.asList(cs221, cs401))),
                new Student(114, "Khaled", new ArrayList<>(Arrays.asList(3.0, 2.8, 3.1)), add2)
        ));

        // Find all the students that are taking a given course
        System.out.println("1. --- Students in CS401 ---");
        students.stream()
                .filter(s -> s.sections != null && s.sections.stream()
                        .anyMatch(sec -> sec.getCourseCode().equals("CS401")))
                .forEach(System.out::println);

        // Get the address of any student that is taking a given course (e.g., "CS401")
        System.out.println("\n2. --- Addresses of CS401 students ---");
        students.stream()
                .filter(s -> s.sections != null && s.sections.stream()
                        .anyMatch(sec -> sec.getCourseCode().equals("CS401")))
                .map(s -> s.address.getStreet() + ", " + s.address.getCity())
                .distinct()
                .forEach(System.out::println);

        // Calculate the GPA for a given student
        System.out.print("\n3. GPA of student 111: ");
        students.stream()
                .filter(s -> s.id == 111)
                .flatMap(s -> s.grades.stream())
                .mapToDouble(Double::doubleValue)
                .average()
                .ifPresent(System.out::println);

        // Find the student with the highest GPA
        System.out.print("\n4. Top GPA Student: ");
        students.stream()
                .max((s1, s2) -> {
                    double gpa1 = s1.grades.stream().mapToDouble(d -> d).average().orElse(0.0);
                    double gpa2 = s2.grades.stream().mapToDouble(d -> d).average().orElse(0.0);
                    return Double.compare(gpa1, gpa2);
                })
                .ifPresent(System.out::println);

        // Get a list of all unique courses taken by students
        System.out.println("\n5. --- Unique Courses ---");
        students.stream()
                .filter(s -> s.sections != null)
                .flatMap(s -> s.sections.stream())
                .map(Section::getCourseCode)
                .distinct()
                .forEach(System.out::println);

        // Find all students who live in a given city (e.g., "Fairfield") sorted in alphabetical order
        System.out.println("\n6. --- Students in Fairfield (Sorted) ---");
        students.stream()
                .filter(s -> s.address.getCity().equals("Fairfield"))
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .forEach(System.out::println);

        // Count the number of students enrolled in a specific course (e.g., "CS401")
        long countCS401 = students.stream()
                .filter(s -> s.sections != null && s.sections.stream()
                        .anyMatch(sec -> sec.getCourseCode().equals("CS401")))
                .count();
        System.out.println("7. Number of students in CS401: " + countCS401);

        // Get a list of students in a specific section
        System.out.println("\n8. --- Students in Section 902 ---");
        students.stream()
                .filter(s -> s.sections != null && s.sections.stream()
                        .anyMatch(sec -> sec.getId() == 902))
                .forEach(System.out::println);

        //  Get the names of students who have enrolled in more than a given number of courses (e.g., more than 2 courses)
        System.out.println("\n9. --- Students taking more than 2 courses ---");
        students.stream()
                .filter(s -> s.sections != null && s.sections.size() > 2)
                .map(Student::getName)
                .forEach(System.out::println);

        // Get a list of unique course names taken by students who live in a given city (e.g., "Fairfield")
        System.out.println("\n10. --- Unique courses in Fairfield ---");
        students.stream()
                .filter(s -> s.address.getCity().equals("Fairfield") && s.sections != null)
                .flatMap(s -> s.sections.stream())
                .map(Section::getCourseCode)
                .distinct()
                .forEach(System.out::println);

        // Get a list of distinct addresses of students who are taking a specific course (e.g., "CS401")
        System.out.println("\n11. --- Distinct addresses for CS401 ---");
        students.stream()
                .filter(s -> s.sections != null && s.sections.stream()
                        .anyMatch(sec -> sec.getCourseCode().equals("CS401")))
                .map(s -> s.address.getStreet() + ", " + s.address.getCity())
                .distinct()
                .forEach(System.out::println);

        // Get a mapping of students' names to the list of courses they are taking
        System.out.println("\n12. --- Student Name to Courses Map ---");
        Map<String, List<String>> studentCourseMap = students.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        s -> s.sections == null ? new ArrayList<>() :
                                s.sections.stream().map(Section::getCourseCode).collect(Collectors.toList())
                ));
        studentCourseMap.forEach((name, courses) ->
                System.out.println(name + ": " + courses));

    }
}
