package src.main.java.ru.gb.oseminar.data;

import java.time.LocalDate;
import java.util.Comparator;

public class Teacher extends User {
    private Long teacherId;

    public Teacher(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        super(firstName, secondName, patronymic, dateOfBirth);
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public static class TeacherComparator implements Comparator<Teacher> {
        @Override
        public int compare(Teacher o1, Teacher o2) {
            int resultOfComparing = o1.getSecondName().compareTo(o2.getSecondName());
            if (resultOfComparing == 0) {
                resultOfComparing = o1.getFirstName().compareTo(o2.getFirstName());
                if (resultOfComparing == 0) {
                    return o1.getPatronymic().compareTo(o2.getPatronymic());
                } else {
                    return resultOfComparing;
                }
            } else {
                return resultOfComparing;
            }
        }
    }
}
