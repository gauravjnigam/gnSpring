package com.gn.springbasics.mrs.service;

import com.gn.springbasics.mrs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilteringTechnique2 {

    @Autowired
    private User user;

    public String collaborativeFiltering() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String userDetails =  user.getUserDetails();
        return userDetails;
    }

    public int collaborativeValue(String logString) {
        String userDetails =  user.getUserDetails();
        return userDetails.length();
    }

    public int collaborativeValue(String logString, int defaultValue) {
        String userDetails =  user.getUserDetails();
        return userDetails.length();
    }
}