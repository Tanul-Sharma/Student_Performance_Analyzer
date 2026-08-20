# 🎓 Student Performance Analyzer

A simple console-based Java application for managing and analyzing student academic records. Add students, calculate their grades automatically, identify top performers, view class-wide statistics, and save/load records to a CSV file.

## Features

- **Add Student** — Enter a student's name, roll number, and marks for 5 subjects. Total, average, and grade are calculated automatically.
- **View All Students** — Display a table of all recorded students with their total, average, and grade.
- **Delete Student** — Remove a student record by roll number.
- **Show Top Performer** — Instantly find the student with the highest total marks.
- **Class Summary** — View the overall class average and a breakdown of how many students received each grade.
- **Save Records** — Persist all student data to `students.csv`.
- **Load Records** — Load previously saved student data from `students.csv`.

## Grading Scale

| Average Marks | Grade |
|---------------|-------|
| 90 and above  | A+    |
| 80 – 89       | A     |
| 70 – 79       | B     |
| 60 – 69       | C     |
| 50 – 59       | D     |
| Below 50      | Fail  |

## Project Structure

```
.
├── Main.java                    # Entry point — console menu & user interaction
├── model/
│   └── Student.java              # Student data model (name, roll, marks, total, average, grade)
└── service/
    ├── StudentAnalyzer.java      # Core logic — add/remove students, topper, class average, grade summary
    └── FileManager.java          # Handles saving/loading student records to/from CSV
```

## How to Run

1. **Organize the files** into the package structure shown above:
   ```
   project/
   ├── Main.java
   ├── model/Student.java
   └── service/StudentAnalyzer.java
   └── service/FileManager.java
   ```

2. **Compile** the project from the root folder:
   ```bash
   javac Main.java model/Student.java service/StudentAnalyzer.java service/FileManager.java
   ```

3. **Run** the application:
   ```bash
   java Main
   ```

4. Use the on-screen menu to add students, view records, and more.

## Sample Menu

```
===========================================
   🎓 STUDENT PERFORMANCE ANALYZER
===========================================
1. Add Student
2. View All Students
3. Delete Student
4. Show Top Performer
5. Class Summary
6. Save Records
7. Load Records
8. Exit
-------------------------------------------
Enter choice:
```

## Data Persistence

Student records are saved to a file named `students.csv` in the project's working directory, in the format:

```
Name,Roll,Total,Average,Grade
```

## License

This is a personal/learning project — feel free to use or modify it as needed.
