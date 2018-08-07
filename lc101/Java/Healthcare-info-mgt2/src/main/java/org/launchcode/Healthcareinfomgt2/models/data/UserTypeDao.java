package org.launchcode.Healthcareinfomgt2.models.data;

import org.launchcode.Healthcareinfomgt2.models.UserType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface UserTypeDao extends CrudRepository<UserType, Integer> {
}
