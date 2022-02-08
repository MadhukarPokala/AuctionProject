package com.example.testproject.DAO;


import com.example.testproject.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface JobDAO extends JpaRepository<Job, Integer> {

    @Query("select j from Job j where active=true order by dateCreated desc")
    List<Job> findAllJobs();


}
