import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private static ArrayList<Student> students = new ArrayList<>();
    private static int totalStudents = 0;

    public static void addStudent(String name, int id, int age, String grade) {
        Student student = new Student(name, id, age, grade);
        students.add(student);
        totalStudents++;
    }

    public static void updateStudent(int id, String name, int age, String grade) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setAge(age);
                student.setGrade(grade);
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    public static void viewStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();
                    addStudent(name, id, age, grade);
                    break;
                case 2:
                    System.out.print("Enter ID of student to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int updateAge = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Grade: ");
                    String updateGrade = scanner.nextLine();
                    updateStudent(updateId, updateName, updateAge, updateGrade);
                    break;
                case 3:
                    viewStudents();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

