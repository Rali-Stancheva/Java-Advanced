package ADVANCED.EXAMS.EXAM_14April_2021_Retake.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    //!!!
    public String registerStudent(Student student) {
        StringBuilder builder = new StringBuilder();

        if (this.getStudentCount() < this.getCapacity()) {
            if (this.students.contains(student)) {
                builder.append("Student is already in the university");
            } else {
                this.students.add(student);
                builder.append("Added student")
                        .append(" ")
                        .append(student.getFirstName())
                        .append(" ")
                        .append(student.getLastName());
            }
        } else {
            builder.append("No seats in the university");
        }
        return builder.toString();
    }

    //remove
    public String dismissStudent(Student student) {
        for (Student student1 : students) {
            if (students.contains(student)) {
                students.remove(student);
                return "Removed student " + student.getFirstName() + " " + student.getLastName();
            }
        }
        return "Student not found";
    }

    public String getStudent(String firstName, String lastName) {
        StringBuilder out = new StringBuilder();
        for (Student st : students) {
            if (st.getFirstName().equals(firstName) && st.getLastName().equals(lastName)) {
                out.append(st.toString());
            }
        }
        return out.toString().trim();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        for (Student s : students) {
            builder.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s\n",
                    s.getFirstName(), s.getLastName(), s.getBestSubject()));
        }
        return builder.toString().trim();
    }

}
