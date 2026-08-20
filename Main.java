import model.Student;
import service.StudentAnalyzer;
import service.FileManager;

import java.io.IOException;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentAnalyzer analyzer = new StudentAnalyzer();
    static FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===========================================");
            System.out.println("   🎓 STUDENT PERFORMANCE ANALYZER");
            System.out.println("===========================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Show Top Performer");
            System.out.println("5. Class Summary");
            System.out.println("6. Save Records");
            System.out.println("7. Load Records");
            System.out.println("8. Exit");
            System.out.println("-------------------------------------------");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> deleteStudent();
                case 4 -> showTopper();
                case 5 -> classSummary();
                case 6 -> saveData();
                case 7 -> loadData();
                case 8 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll: ");
        int roll = sc.nextInt();

        double[] marks = new double[5];
        System.out.println("Enter marks of 5 subjects:");
        for (int i = 0; i < 5; i++) marks[i] = sc.nextDouble();

        Student s = new Student(name, roll, marks);
        analyzer.addStudent(s);

        System.out.println("✔ Student Added Successfully!");
    }

    static void viewStudents() {
        List<Student> list = analyzer.getStudents();

        if (list.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        System.out.println("--------------------------------------------------------");
        System.out.println("Name\tRoll\tTotal\tAverage\tGrade");
        System.out.println("--------------------------------------------------------");

        for (Student s : list) {
            System.out.println(s.getName() + "\t" + s.getRollNo() + "\t" +
                    s.getTotal() + "\t" + s.getAverage() + "\t" + s.getGrade());
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Roll to Delete: ");
        int roll = sc.nextInt();

        analyzer.removeStudent(roll);
        System.out.println("✔ Student Deleted (if existed)");
    }

    static void showTopper() {
        Student top = analyzer.getTopper();

        if (top == null) {
            System.out.println("No students available!");
            return;
        }

        System.out.println("\n🏆 Top Performer:");
        System.out.println("Name: " + top.getName());
        System.out.println("Roll: " + top.getRollNo());
        System.out.println("Total: " + top.getTotal());
        System.out.println("Average: " + top.getAverage());
        System.out.println("Grade: " + top.getGrade());
    }

    static void classSummary() {
        System.out.println("\n📊 Class Summary:");

        double avg = analyzer.getClassAverage();
        System.out.println("Class Average: " + avg);

        Map<String, Long> map = analyzer.getGradeSummary();
        System.out.println("\nGrade Count:");
        for (String g : map.keySet()) {
            System.out.println(g + ": " + map.get(g));
        }
    }

    static void saveData() {
        try {
            fileManager.save(analyzer.getStudents());
            System.out.println("✔ Records Saved!");
        } catch (IOException e) {
            System.out.println("Error saving!");
        }
    }

    static void loadData() {
        try {
            analyzer.clearAll();
            analyzer.getStudents().addAll(fileManager.load());
            System.out.println("✔ Records Loaded!");
        } catch (IOException e) {
            System.out.println("Error loading!");
        }
    }
}
