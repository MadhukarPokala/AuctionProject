package com.example.testproject.Controller;


import com.example.testproject.model.Job;
import com.example.testproject.model.User;
import com.example.testproject.service.JobPostingService;
import com.example.testproject.service.UserService;
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
    public Map<Integer, Integer> getActiveJobs() {
        return jobPostingService.getActiveJobs();
    }

    @Autowired
    private UserService userService;

    @PostMapping("/createPoster")
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
