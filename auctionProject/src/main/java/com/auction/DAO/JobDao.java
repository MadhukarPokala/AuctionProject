package com.auction.DAO;


import com.auction.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobDao extends JpaRepository<Job, Integer> {

    @Query("select j from Job j where active=true order by dateCreated desc")
    List<Job> getActiveJobs();


}
