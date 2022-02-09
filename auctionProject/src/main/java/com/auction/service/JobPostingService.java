package com.auction.service;

import com.auction.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface JobPostingService {
    String postJob(Job job);

    List<Job> getActiveJobs();
}
