package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


   private SessionFactory sessionFactory;
   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<User> getByCarModel(String CarModel) {
   List<User>cars=sessionFactory.openSession().createQuery("from User ").list();
   cars.stream().filter(car -> car.getCar().getModel().equals(CarModel)).forEach(System.out::println);
   return cars;

         }

   @Override
   public List<User> findUserById(int id) {
      List<User> list=sessionFactory.openSession().createQuery("from User").list();
      list.stream().filter(user -> user.getId()==id).forEach(System.out::println);
      return list;
   }


}
