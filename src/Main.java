package src;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import src.main.java.ru.gb.oseminar.data.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<Student> students = Arrays.asList(
                    new Student(3L, "Иван", "Иванович", "Иванов", LocalDate.of(2000, 1, 1)),
                    new Student(2L, "Алексей", "Алексеевич", "Алексеев", LocalDate.of(2000, 2, 2)),
                    new Student(1L, "Петр", "Петрович", "Петров", LocalDate.of(2000, 3, 3))
            );

            StudentGroup studentGroup = new StudentGroup(students, new Teacher("Иван", "Иванович", "Иванов", LocalDate.of(1980, 5, 10)));

            Iterator<Student> studentIterator = studentGroup.iterator();
            while (studentIterator.hasNext()) {
                System.out.println(studentIterator.next().toString());
            }

            System.out.println("////////////////////////////////////");

            List<Student> sortedStudents = studentGroup.getStudents().stream()
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(sortedStudents.toString());

            List<Teacher> teachers = Arrays.asList(
                    new Teacher("Роберт", "Робертович", "Хачатурян", LocalDate.of(1975, 8, 15)),
                    new Teacher("Екатерина", "Сергеевна", "Семенова", LocalDate.of(1982, 9, 20)),
                    new Teacher("Михаил", "Михайлович", "Михайлов", LocalDate.of(1978, 6, 5))
            );

            TeacherGroup teacherGroup = new TeacherGroup(teachers);

            Iterator<Teacher> teacherIterator = teacherGroup.iterator();
            while (teacherIterator.hasNext()) {
                System.out.println(teacherIterator.next().toString());
            }

            System.out.println("////////////////////////////////////");

            List<Teacher> sortedTeachers = teacherGroup.getTeachers().stream()
                    .sorted(new Teacher.TeacherComparator())
                    .collect(Collectors.toList());
            System.out.println(sortedTeachers.toString());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}