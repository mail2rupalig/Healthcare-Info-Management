package org.launchcode.Healthcareinfomgt2.models.data;

import org.launchcode.Healthcareinfomgt2.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface UserDao extends CrudRepository<User, Integer> {
}
