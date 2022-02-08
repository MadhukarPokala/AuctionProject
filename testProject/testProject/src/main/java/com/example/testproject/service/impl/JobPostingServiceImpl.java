package com.example.testproject.service.impl;

import com.example.testproject.DAO.JobDAO;
import com.example.testproject.DAO.UserDao;
import com.example.testproject.model.Job;
import com.example.testproject.model.User;
import com.example.testproject.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class JobPostingServiceImpl implements JobPostingService {

    @Autowired
    private JobDAO jobDAO;

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
    public List<Job> getAllJobs() {
        List<Job> jobs = jobDAO.findAllJobs();
        return jobs;
    }

    @Override
    public Map<Integer, Integer> getActiveJobs() {
        return null;
    }


}
