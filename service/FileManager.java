package service;

import model.Student;
import java.io.*;
import java.util.*;

public class FileManager {
    private final String filePath = "students.csv";

    public void save(List<Student> students) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        bw.write("Name,Roll,Total,Average,Grade\n");
        for (Student s : students) {
            bw.write(s.toCSV() + "\n");
        }
        bw.close();
    }

    public List<Student> load() throws IOException {
        List<Student> list = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return list;

        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine(); // skip header
        String line;

        while ((line = br.readLine()) != null) {
            String[] p = line.split(",");
            if (p.length != 5) continue;

            String name = p[0];
            int roll = Integer.parseInt(p[1]);
            double avg = Double.parseDouble(p[3]);

            // reconstruct marks (approx.)
            double[] marks = {avg, avg, avg, avg, avg};

            list.add(new Student(name, roll, marks));
        }
        br.close();
        return list;
    }
}
