package question3;


import java.lang.reflect.Method;

import static java.lang.System.currentTimeMillis;

public class TimeItImpl implements TimeIt {

  @Override
  public long getMethodsTiming(Class c, String method) {
    long startTime = currentTimeMillis();
    getwrapedObject(c,  method);
    System.out.println("Time passed = " + (currentTimeMillis() - startTime));
    System.out.println(startTime);
    return startTime;
  }

  public static void getwrapedObject(Class<?> clas, String method) {
    try {
      Object obj = clas.newInstance();
      Method reflectedMethod = clas.getDeclaredMethod(method);
      System.out.println(reflectedMethod.invoke(obj));
    } catch (Exception ex) {
      System.out.println("stack trace");
      ex.printStackTrace();
    }
  }
}
