package service;

import model.Student;
import java.util.*;

public class StudentAnalyzer {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(int roll) {
        students.removeIf(s -> s.getRollNo() == roll);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getTopper() {
        return students.stream()
                .max(Comparator.comparingDouble(Student::getTotal))
                .orElse(null);
    }

    public double getClassAverage() {
        if (students.isEmpty()) return 0;
        double sum = 0;
        for (Student s : students) sum += s.getAverage();
        return sum / students.size();
    }

    public Map<String, Long> getGradeSummary() {
        Map<String, Long> map = new HashMap<>();
        for (Student s : students) {
            map.put(s.getGrade(), map.getOrDefault(s.getGrade(), 0L) + 1);
        }
        return map;
    }

    public void clearAll() {
        students.clear();
    }
}
