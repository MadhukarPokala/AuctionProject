package com.example.testproject.service;

import com.example.testproject.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface JobPostingService {
    String postJob(Job job);

    List<Job> getAllJobs();

    Map<Integer, Integer> getActiveJobs();
}
