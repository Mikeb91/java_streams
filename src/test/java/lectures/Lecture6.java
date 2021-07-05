package lectures;


import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.Test;

public class Lecture6 {

  final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;
  final Predicate<Integer> numbersLessThanTen = n ->n > 5 && n < 10;
  @Test
  public void findAny() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Integer any = Arrays.stream(numbers)
        .filter(numbersLessThanTen)
        .findAny()
        .get();
    System.out.println(any); //It´s non detarministic - If we run this thousand times, maybe some results will throw another results
  }

  @Test
  public void findFirst() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Integer first = Arrays.stream(numbers)
        .filter(numbersLessThanTen)
        .findFirst()
        .get();
    System.out.println(first); //Ir´sdeterministic - Always the same result
  }
}

