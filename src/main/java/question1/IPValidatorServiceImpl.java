package question1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPValidatorServiceImpl implements IPValidatorService {

  private Pattern pattern;
  private Matcher matcher;

  private static final String IP_PATTERN =
    "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
      "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
      "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
      "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

  public IPValidatorServiceImpl(){
    pattern = Pattern.compile(IP_PATTERN);
  }

  @Override
  public boolean validate(final String ip){
    matcher = pattern.matcher(ip);
    return matcher.matches();
  }
}
