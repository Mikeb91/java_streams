package lectures;

import beans.Person;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  @Test
  public void range() throws Exception {

    System.out.println("for i");
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
    }
    System.out.println("Exclusive");
    IntStream.range(0, 10).forEach(System.out::println); //Receives the index
    System.out.println("Inclusive");
    IntStream.rangeClosed(0, 10).forEach(System.out::println);

  }

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();
   IntStream.range(0, people.size()) //Many cases we´ll need to know and manage the index. We use IntStream to do that.
       .forEach(index -> {
         Person person = people.get(index); //Receives the index
         System.out.println(person);
       });

  }

  @Test
  public void intStreamIterate() throws Exception {
      IntStream.iterate(0, operand -> operand + 1) //We an manipulate the operand in case it is not one by one, nut depends on a function
          .filter(number -> number % 2 == 0)
          .limit(20)
          .forEach(System.out::println);
  }
}
