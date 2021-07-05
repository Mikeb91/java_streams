package lectures;

import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture13 {
  @Test
  public void intermediateAndTerminalOperations() throws Exception {
    System.out.println(
        MockData.getCars()
            .stream()
            .filter(car -> {
              System.out.println("filter car " + car);
              return car.getPrice() < 10000; //This intermediate opertions, wont occure until the final back to concrete operation takes places.
            })
            .map(car -> {
              System.out.println("mapping car " + car);//This intermediate opertions, wont occure until the final back to concrete operation takes places.
              return car.getPrice(); //Lazy operations - Does not occure until terminal operations occure
            })
            .map(price -> {
              System.out.println("mapping price " + price);//This intermediate opertions, wont occure until the final back to concrete operation takes places.
              return price + (price * .14);
            })
            .collect(Collectors.toList()) //Terminal operations that takes all back to concrete
    );
  }
}
