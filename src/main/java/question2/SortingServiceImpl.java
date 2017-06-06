package question2;

import java.util.List;
import java.util.stream.Collectors;

public class SortingServiceImpl implements SortingService {
  @Override
  public List<Student> sortStudents(List<Student> students) {
    return students
      .stream()
      .sorted((student1, student2) -> {
      if(student1.getGPA() == student2.getGPA()) {
        if(student1.getFirstName().equals(student2.getFirstName())) {
          return student1.getId() - student2.getId();
        }
        else {
          return student1.getFirstName().compareTo(student2.getFirstName());
        }
      }
      else {
        return Float.compare(student2.getGPA(), student1.getGPA());
      }
    })
      .collect(Collectors.toList());
  }

}
