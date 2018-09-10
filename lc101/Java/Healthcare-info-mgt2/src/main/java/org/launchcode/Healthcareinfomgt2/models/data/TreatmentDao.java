package org.launchcode.Healthcareinfomgt2.models.data;

import org.launchcode.Healthcareinfomgt2.models.Symptons;
import org.launchcode.Healthcareinfomgt2.models.Treatment;
import org.springframework.data.repository.CrudRepository;

public interface TreatmentDao extends CrudRepository<Treatment, Integer> {
}
