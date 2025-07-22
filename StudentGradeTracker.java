import java.util.*;

public class StudentGradeTracker {
    static class Student {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter marks for " + name + ": ");
            int marks = sc.nextInt();
            sc.nextLine(); 
            students.add(new Student(name, marks));
        }

        int total = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
        String topStudent = "", lowStudent = "";

        for (Student s : students) {
            total += s.marks;
            if (s.marks > highest) {
                highest = s.marks;
                topStudent = s.name;
            }
            if (s.marks < lowest) {
                lowest = s.marks;
                lowStudent = s.name;
            }
        }

        double average = (double) total / n;
        System.out.println("\n--- Student Summary ---");
        System.out.printf("Average Marks: %.2f\n", average);
        System.out.println("Highest Marks: " + highest + " by " + topStudent);
        System.out.println("Lowest Marks: " + lowest + " by " + lowStudent);

        System.out.println("\nList of Students:");
        for (Student s : students) {
            System.out.println(s.name + " - " + s.marks);
        }

        sc.close();
    }
}
