package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class Lecture4 {

  @Test
  public void distinct() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
    List<Integer> distinctNumbers = numbers.stream()
        .distinct() //Get the distinct numbers in the collection.
        .collect(Collectors.toList()); //The result can be stored in a new collection like a lsit.
    assertThat(distinctNumbers).hasSize(9);
    System.out.println(distinctNumbers);

  }

  @Test
  public void distinctWithSet() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
    //Another way to remove duplicates from collection
    Set<Integer> distinctNumbers = numbers.stream()
        .collect(Collectors.toSet()); //The list allows duplicates but the set does not. Use this is the result can be a set, otherwise use the distinct.
    assertThat(distinctNumbers).hasSize(9);
    System.out.println(distinctNumbers);
  }
}
