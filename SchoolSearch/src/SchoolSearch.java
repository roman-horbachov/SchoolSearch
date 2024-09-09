import java.io.*;
import java.util.*;

class Student {
    String lastName;
    String firstName;
    int grade;
    int classroom;
    int bus;
    String teacherLastName;
    String teacherFirstName;

    public Student(String lastName, String firstName, int grade, int classroom, int bus, String teacherLastName, String teacherFirstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.grade = grade;
        this.classroom = classroom;
        this.bus = bus;
        this.teacherLastName = teacherLastName;
        this.teacherFirstName = teacherFirstName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Клас: " + grade + ", Класна кімната: " + classroom + ", Автобус: " + bus + ", Викладач: " + teacherFirstName + " " + teacherLastName;
    }
}

public class SchoolSearch {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        try {
            loadStudents("students.txt");
            Scanner scanner = new Scanner(System.in);
            String command;
            while (true) {
                System.out.print("Введіть команду (S[lastname], B[bus], T[teacher], C[classroom], Q[uit]): ");
                command = scanner.nextLine();

                if (command.equalsIgnoreCase("Q")) {
                    break;
                } else if (command.startsWith("S")) {
                    handleStudentSearch(command);
                } else if (command.startsWith("B")) {
                    handleBusSearch(command);
                } else if (command.startsWith("T")) {
                    handleTeacherSearch(command);
                } else if (command.startsWith("C")) {
                    handleClassroomSearch(command);
                } else {
                    System.out.println("Невідома команда.");
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка при зчитуванні файлу.");
        }
    }

    private static void loadStudents(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 7) {
                students.add(new Student(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5], data[6]));
            }
        }
        reader.close();
    }

    // Оновлений метод для пошуку студента за прізвищем та з опцією B (автобус)
    private static void handleStudentSearch(String command) {
        String[] parts = command.split(":");
        String lastName = parts[1].split(" ")[0].trim();  // Отримуємо прізвище студента
        boolean searchBus = command.contains(" B");  // Перевіряємо, чи є опція B (автобус)

        boolean found = false;
        for (Student student : students) {
            if (student.lastName.equalsIgnoreCase(lastName)) {
                if (searchBus) {
                    // Виводимо тільки прізвище, ім'я та автобус
                    System.out.println(student.lastName + " " + student.firstName + ", Автобус: " + student.bus);
                } else {
                    // Виводимо всі дані про студента
                    System.out.println(student);
                }
                found = true;
            }
        }
        if (!found) {
            System.out.println("Студент не знайдений.");
        }
    }

    private static void handleBusSearch(String command) {
        String[] parts = command.split(":");
        int busNumber = Integer.parseInt(parts[1]);
        boolean found = false;
        for (Student student : students) {
            if (student.bus == busNumber) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Жоден студент не використовує цей автобус.");
        }
    }

    private static void handleTeacherSearch(String command) {
        String[] parts = command.split(":");
        String teacherLastName = parts[1];
        boolean found = false;
        for (Student student : students) {
            if (student.teacherLastName.equalsIgnoreCase(teacherLastName)) {
                System.out.println(student.firstName + " " + student.lastName);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Викладач не знайдений.");
        }
    }

    private static void handleClassroomSearch(String command) {
        String[] parts = command.split(":");
        int classroomNumber = Integer.parseInt(parts[1]);
        boolean found = false;
        for (Student student : students) {
            if (student.classroom == classroomNumber) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Немає студентів у цьому класі.");
        }
    }
}
