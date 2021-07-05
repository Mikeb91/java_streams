package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String fullString = "";
    for(String name : names){
      fullString= fullString + name + ", ";
    }
    fullString = fullString.substring(0, fullString.lastIndexOf(","));
    System.out.println(fullString);
  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String fullString = names.stream()
        .map(String::toUpperCase)
        .collect(Collectors.joining(", "));
    System.out.println(fullString);
  }
}
