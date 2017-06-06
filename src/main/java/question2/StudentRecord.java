package question2;

public class StudentRecord implements Student {

  private final int id;
  private final String firstName;
  private final float GPA;


  public StudentRecord(final int id, final String firstName, final float gpa) {
    this.id = id;
    this.firstName = firstName;
    this.GPA = gpa;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  @Override
  public float getGPA() {
    return GPA;
  }
}
