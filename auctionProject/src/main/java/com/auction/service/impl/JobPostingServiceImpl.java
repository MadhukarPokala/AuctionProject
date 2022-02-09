package com.auction.service.impl;

import com.auction.DAO.JobDao;
import com.auction.DAO.UserDao;
import com.auction.service.JobPostingService;
import com.auction.model.Job;
import com.auction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JobPostingServiceImpl implements JobPostingService {

    @Autowired
    private JobDao jobDAO;

    @Autowired
    private UserDao userDao;

    @Override
    public String postJob(Job job) {
        Optional<User> user = userDao.findById(1);
        job.setPostedBy(user.get());
        jobDAO.save(job);
        return "Success";
    }

    @Override
    public List<Job> getActiveJobs() {
        List<Job> jobs = jobDAO.getActiveJobs();
        return jobs;
    }


}
