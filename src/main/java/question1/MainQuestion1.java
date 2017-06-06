package question1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainQuestion1 {

  private static IPValidatorService ipValidator;
  private static FilterService filter;
  public static final String FILE_NAME = "IPList.txt";

  public static void main(String[] args) throws FileNotFoundException {
    // In case of using a framework I would use dependency Injection instead of the next.
    ipValidator = new IPValidatorServiceImpl();
    filter = new FilterServiceImpl(ipValidator);
    List<String> validIPList = filter.validIpList(readFile(FILE_NAME));
    validIPList.forEach(System.out::println);
  }

  public static List<String> readFile(String fileName) throws FileNotFoundException {
    // we are using IPValidatorTest.class instead of getClass due to static.
    ClassLoader classLoader = MainQuestion1.class.getClassLoader();
    List<String> list = new ArrayList<String>();
    Scanner s = new Scanner(new File(classLoader.getResource(fileName).getFile()));
    while (s.hasNext()){
      list.add(s.next());
    }
    s.close();
    return list;
  }
}
