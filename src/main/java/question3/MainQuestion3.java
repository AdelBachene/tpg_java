package question3;

public class MainQuestion3 {
  private static TimeIt timeIt;

  public static void main(String[] args) {
    timeIt = new TimeItImpl();
    timeIt.getMethodsTiming(String.class, "hashCode");
  }
}
