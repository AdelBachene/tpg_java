package question2;

import java.util.ArrayList;
import java.util.List;

public class MainQuestion2 {

  private static SortingService sortingService;

  public static void main(String[] args) {
    sortingService = new SortingServiceImpl();

    List<Student> students = new ArrayList<>();

    students.add(new StudentRecord(33, "Tina", (float) 3.68));
    students.add(new StudentRecord(85, "Louis", (float) 3.85));
    students.add(new StudentRecord(56, "Samil", (float) 3.75));
    students.add(new StudentRecord(19, "Samar", (float) 3.75));
    students.add(new StudentRecord(22, "Lorry", (float) 3.76));

    students = sortingService.sortStudents(students);
    students.forEach(student -> System.out.println(student.getFirstName() + " | " + student.getId()));
  }


}
