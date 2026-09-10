public class Student {
    private String name;
    private String studentId;

    public Student(String name, String studentId) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        if (studentId == null || studentId.trim().equals("")) {
            throw new IllegalArgumentException("Student ID cannot be blank.");
        }

        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String toString() {
        return name + " | ID: " + studentId;
    }
}
