package com.ssheld.todotoday.dao;

import com.ssheld.todotoday.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDao extends CrudRepository<Task, Long> {
  // t is our task object. User is the user of our task object.
  @Query("select t from Task t where t.user.id=:#{principal.id}")
  List<Task> findAll();
}
