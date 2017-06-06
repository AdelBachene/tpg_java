package question1;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RunWith(DataProviderRunner.class)
public class IPValidatorTest {

  private static IPValidatorService ipValidator;

  @BeforeClass
  public static void initData() throws Exception {
    ipValidator = new IPValidatorServiceImpl();
  }

  @DataProvider
  public static String[] validIPProvider() throws FileNotFoundException {
    return readFile("ValidIPProvider.txt");
  }

  @DataProvider
  public static String[] invalidIPProvider() throws FileNotFoundException {
    return readFile("InvalidIPProvider.txt");
  }

  @Test
  @UseDataProvider("validIPProvider")
  public void validIPAddressTest(String ip) {
    boolean valid = ipValidator.validate(ip);
    System.out.println("IP validation : " + ip + " , " + valid);
    Assert.assertEquals(true, valid);
  }

  @Test
  @UseDataProvider("invalidIPProvider")
  public void inValidIPAddressTest(String ip) {
    boolean valid = ipValidator.validate(ip);
    System.out.println("IP Validation : " + ip + " , " + valid);
    Assert.assertEquals(false, valid);
  }

  public static String[] readFile(String fileName) throws FileNotFoundException {
    // we are using question1.IPValidatorTest.class instead of getClass due to static.
    ClassLoader classLoader = IPValidatorTest.class.getClassLoader();
    List<String> list = new ArrayList<String>();
    Scanner s = new Scanner(new File(classLoader.getResource(fileName).getFile()));
    while (s.hasNext()){
      list.add(s.next());
    }
    s.close();
    String[] str = list.toArray(new String[list.size()]);
    return str;
  }

}