package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    Predicate<Car> carPredicate = car -> car.getPrice() // This extracted predicate can be reused if needed.
        < 20000;
    List<Car> carsFiltered = cars.stream()
        .filter(carPredicate)//Receives a predicate: Predicate is just an expression that can be true or false.
        .collect(Collectors.toList());
    carsFiltered.forEach(System.out::println);
    System.out.println(carsFiltered.size());
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    List<PersonDTO> dtos = people.stream()
//        .map(person -> { //The mapping allows us to transform the information we got from the concrete element to another element we desire.
//          PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
//          return dto;
//        }) - All this can be replaced with method reference like follows:
        .map(PersonDTO::map)
        .collect(Collectors.toList());
    dtos.forEach(System.out::println);
    assertThat(dtos).hasSize(1000);

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> cars = MockData.getCars();
    OptionalDouble average = cars.stream()
        .mapToDouble(Car::getPrice)
        .average();
    System.out.println(average);

  }

  @Test
  public void test() throws Exception {
      MockData.getCars().forEach(System.out::println);
  }
}



