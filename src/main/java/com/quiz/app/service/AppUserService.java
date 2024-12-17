package com.quiz.app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.model.AppUser;
import com.quiz.app.model.Session;
import com.quiz.app.repository.AppUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser createUser(String name) {
        AppUser user = new AppUser();
        user.setName(name);
        return appUserRepository.save(user);
    }

    public Optional<AppUser> getUserById(Long id) {
        return appUserRepository.findById(id);
    }

    public AppUser getUserByName(String name) {
        return appUserRepository.findByName(name);
    }
    

  
}
