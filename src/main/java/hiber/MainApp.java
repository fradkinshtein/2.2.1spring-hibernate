package hiber;

import hiber.config.AppConfig;
//import hiber.model.Car;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.jws.soap.SOAPBinding;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      Car car1 = new Car();

      car1.setId(Long.getLong("1"));
      car1.setModel("car1");
      car1.setSeries(01);
      //car1.setUser();
      User user1 = new User();
      user1.setEmail("a@a.a");
      user1.setFirstName("AAA");
      user1.setLastName("Z");
      user1.setId(Long.getLong("1"));
      user1.setCar(car1);

      Car car2 = new Car();
      car2.setId(Long.getLong("1"));
      car2.setModel("Tesla");
      car2.setSeries(2);

      User user2 = new User();
      user2.setEmail("ilonm@tesla.com");
      user2.setId(Long.getLong("2"));
      user2.setFirstName("Ilon");
      user2.setLastName("Mask");
      user2.setCar(car2);

      Car car3 = new Car();
      car3.setId(Long.getLong("3"));
      car3.setModel("Car3");
      car3.setSeries(3);

      User user3 = new User();
      user3.setEmail("c@c.c");
      user3.setId(Long.getLong("3"));
      user3.setFirstName("CCC");
      user3.setLastName("AZZ");
      user3.setCar(car3);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());

         System.out.println();
      }
      System.out.println("____________________");
      User user11 = userService.getUserByCarModelAndSerie("Tesla",2);
      System.out.printf("Printing user Tesla serie 2 owner: %s .... Done!%n", user11.toString());
      context.close();
   }
}
