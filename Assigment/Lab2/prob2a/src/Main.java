public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Phuong Nguyen");
        student1.setGradeReport(3.5);

        Student student2 = new Student("Johnny");
        GradeReport gradeReport = new GradeReport(student2);
        gradeReport.setGrade(4.0);

        System.out.println("Student 1: " + student1.toString());
        System.out.println("Student 2: " + gradeReport.toString());
    }
}
