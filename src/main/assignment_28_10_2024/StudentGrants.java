package main.assignment_28_10_2024;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class StudentGrants {
    private static void calculateGrants(List<Student> students) {
        for (Student student : students) {
            String status = "";
            double averageScore = 0;
            for (int score : student.getScores()) {
                if (!(score >= 3 && score <= 5)) {
                    throw new IllegalArgumentException("Error by "+ student.getName() + "\nScores must be between 3 and 5 inclusive");
                }
                averageScore += score;
                if (score == 3) {
                    status = "None";
                    break;
                }
            }
            averageScore /= student.getScores().length;
            if (status.isEmpty()) {
                if (averageScore <= 4.5) {
                    status = "Common";
                }
                if (averageScore >= 4.5 && averageScore < 5) {
                    status = "High";
                }
                if (averageScore == 5) {
                    status = "Named";
                }
            }
            System.out.println(student.toString() + "\nGrant status: " + status);
        }
    }

    public static void main(String[] args) {
        try (FileReader input = new FileReader("data/students_score.json")) {
            Gson gson = new Gson();
            List<Student> students = gson.fromJson(input, new TypeToken<List<Student>>(){}.getType());
            calculateGrants(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
