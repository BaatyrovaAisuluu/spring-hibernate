package hiber;

import hiber.MyException.MyException;
import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws MyException {


        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        Car car = new Car("plastic", 23);
        Car carOne = new Car("toy", 67);
        Car carTwo = new Car("mustang", 43);
        Car carTree = new Car("ferrari", 54);

        userService.add(new User("Aisuluu", "Baatyrova", "Aisuluu@mail.ru", car));
        userService.add(new User("Rahim", "Kurbanov", "Rahim@mail.ru", carOne));
        userService.add(new User("Nurisa", "Mamarayim", "Nurisa@mail.ru", carTwo));
        userService.add(new User("Muhammed", "Batyrov", "Muha@mail.ru", carTree));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id          " + user.getId());
            System.out.println("First Name  " + user.getFirstName());
            System.out.println("Last Name   " + user.getLastName());
            System.out.println("Email       " + user.getEmail());
            System.out.println("       Car  " + "\n" + user.getCar());
            System.out.println();
        }
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("san jaz");
            System.out.println();
            System.err.println("1 get All User");
            System.err.println("2 find By Car Model");
            System.err.println("3 find By User id");
            int number = scanner.nextInt();
            if (number <= 0 || number > 4) {
                throw new MyException("not found");
            } else if (number == 1) {
                System.out.println();
                System.out.println(userService.listUsers());
            } else if (number == 2) {
                System.out.println();
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("write Car Model");
                String model = scanner1.nextLine();
                userService.getByCarModel(model);
            }
            else if(number==3){
                System.out.println("write User by id");
                int id=scanner.nextInt();
                userService.findUserById(id);
            }else {
                System.out.println();
            }

        }
    }
}
