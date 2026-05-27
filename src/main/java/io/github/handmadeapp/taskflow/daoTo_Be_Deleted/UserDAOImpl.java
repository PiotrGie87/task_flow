
package io.github.handmadeapp.taskflow.daoTo_Be_Deleted;

import io.github.handmadeapp.taskflow.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO
{
  private final EntityManager entityManager;

  @Autowired
  public UserDAOImpl(EntityManager entityManager)
  {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void saveUser(User user)
  {
    entityManager.persist(user);
  }
}