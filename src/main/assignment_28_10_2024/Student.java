package main.assignment_28_10_2024;

import java.util.Arrays;

public class Student {
    private String name;
    private int[] scores;

    public Student(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + "\nscores=" + Arrays.toString(scores)
                + '}';
    }
}
