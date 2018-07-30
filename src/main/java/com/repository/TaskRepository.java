package com.repository;

import com.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ryandesmond on 7/30/18.
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {


}
