package org.launchcode.Healthcareinfomgt2.models.data;

import org.launchcode.Healthcareinfomgt2.models.Disease;
import org.launchcode.Healthcareinfomgt2.models.Symptons;
import org.springframework.data.repository.CrudRepository;

public interface SymptonsDao extends CrudRepository<Symptons, Integer> {
}
