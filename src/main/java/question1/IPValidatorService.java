package question1;

public interface IPValidatorService {

  /**
   * Validate Ip Address.
   * @param ip Address.
   * @return true for valid IP and false for non valid ip.
   */
  boolean validate(final String ip);

}
