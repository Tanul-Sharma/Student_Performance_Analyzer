package model;

public class Student {
    private String name;
    private int rollNo;
    private double[] marks;
    private double total;
    private double average;
    private String grade;

    public Student(String name, int rollNo, double[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        calculateResult();
    }

    private void calculateResult() {
        total = 0;
        for (double m : marks) total += m;
        average = total / marks.length;

        if (average >= 90) grade = "A+";
        else if (average >= 80) grade = "A";
        else if (average >= 70) grade = "B";
        else if (average >= 60) grade = "C";
        else if (average >= 50) grade = "D";
        else grade = "Fail";
    }

    public String getName() { return name; }
    public int getRollNo() { return rollNo; }
    public double getTotal() { return total; }
    public double getAverage() { return average; }
    public String getGrade() { return grade; }

    public String toCSV() {
        return name + "," + rollNo + "," + total + "," + average + "," + grade;
    }
}
