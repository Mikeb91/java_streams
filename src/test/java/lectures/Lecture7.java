package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    long amountOfFemales = MockData.getPeople()
        .stream()
        .filter(person -> person.getGender().equalsIgnoreCase("female"))
        .count();
    System.out.println(amountOfFemales);
  }

  @Test
  public void min() throws Exception { //This is how we can use min without comparators. The only difference is that before we invoke min(), there is a
                                      //mapToDouble() or mapToInt() in order to get a numeric stream.
    double min = MockData.getCars()
        .stream()
        .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(Car::getPrice)
        .min()
        .getAsDouble();
    System.out.println(min);
  }

  @Test
  public void max() throws Exception {//This is how we can use max without comparators. The only difference is that before we invoke min(), there is a
                                      //mapToDouble() or mapToInt() in order to get a numeric stream.
    double max = MockData.getCars()
        .stream()
        .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(Car::getPrice)
        .max()
        .getAsDouble(); //This is how we tell the app we are sure it can get the results directly as a double. But if we are not sure we can use .orElse(0).
                        //or leave it as optional.
    System.out.println(max);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    double average = cars.stream()
        .mapToDouble(Car::getPrice)
        .average()
        .orElse(0);
    System.out.println(average);
  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
        .mapToDouble(Car::getPrice)
        .sum();
    System.out.println(sum);
  }

  @Test
  public void statistics() throws Exception { //Gives us all the previous methods in just one useful single method.
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();
    System.out.println(statistics);
    System.out.println(statistics.getAverage());
    System.out.println(statistics.getCount());
    System.out.println(statistics.getMax());
    System.out.println(statistics.getMin());
    System.out.println(statistics.getSum());
  }

}