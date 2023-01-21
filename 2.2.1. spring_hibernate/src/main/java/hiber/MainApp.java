package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      Car car1 = new Car();
      Car car2 = new Car();
      Car car3 = new Car();
      Car car4 = new Car();

      car1.setModel("Volvo");
      car1.setSeries(2022);
      car2.setModel("BMW");
      car2.setSeries(1985);
      car3.setModel("PEGO");
      car3.setSeries(1999);
      car4.setModel("VAZ");
      car4.setSeries(1966);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);

      }

      List<User> userByCars = userService.getUserByCar("BMW", 1985);
      System.out.println("______________________");

      for (User user : userByCars) {
         System.out.println(user);
      }

      context.close();
   }
}
