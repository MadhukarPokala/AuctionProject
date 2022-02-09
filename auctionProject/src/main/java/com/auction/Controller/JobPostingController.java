package com.auction.Controller;


import com.auction.model.Job;
import com.auction.model.User;
import com.auction.service.JobPostingService;
import com.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/job")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;



    @PostMapping("/create")
    public String postJob(@RequestBody Job job) {
        return jobPostingService.postJob(job);
    }


    @RequestMapping("/getActiveJobs")
    public List<Job> getActiveJobs() {
        return jobPostingService.getActiveJobs();
    }

    @Autowired
    private UserService userService;

}
