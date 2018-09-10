package org.launchcode.Healthcareinfomgt2.models.data;

import org.launchcode.Healthcareinfomgt2.models.Disease;
import org.launchcode.Healthcareinfomgt2.models.ProblemArea;
import org.springframework.data.repository.CrudRepository;

public interface DiseaseDao extends CrudRepository<Disease, Integer> {
}
