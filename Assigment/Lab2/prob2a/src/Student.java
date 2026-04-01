public class Student {
    private String name;
    private GradeReport gradeReport;

    public Student(String name) {
        this.name = name;
        this.gradeReport = new GradeReport(this);
    }

    public String getName() {
        return name;
    }

    public double getGradeReport() {
        return gradeReport.getGrade();
    }

    public void setGradeReport(double grade) {
        this.gradeReport.setGrade(grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ", gradeReport=" + this.getGradeReport() +
                '}';
    }
}
