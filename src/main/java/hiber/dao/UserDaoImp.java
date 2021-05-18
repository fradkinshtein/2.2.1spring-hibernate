package hiber.dao;

import hiber.model.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getUserByCarModelAndSerie(String model, int serie) {
      String HQL = "from User where car.series = :serie and car.model = :model";

      TypedQuery<User> query = sessionFactory.getCurrentSession()
              .createQuery(HQL);
      query.setParameter("serie", serie);
      query.setParameter("model", model);
      return query.getResultList().get(0);
   }
}
