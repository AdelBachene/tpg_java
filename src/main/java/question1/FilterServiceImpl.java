package question1;

import java.util.List;
import java.util.stream.Collectors;

public class FilterServiceImpl implements FilterService {

  private final IPValidatorService ipValidatorService;

  public FilterServiceImpl(final IPValidatorService ipValidatorService) {
    this.ipValidatorService = ipValidatorService;
  }

  @Override
  public List<String> validIpList(List<String> list) {
    return list.stream()
      .filter(it -> ipValidatorService.validate(it))
      .sequential()
      .map(String::new)
      .collect(Collectors.toList());
  }

}
