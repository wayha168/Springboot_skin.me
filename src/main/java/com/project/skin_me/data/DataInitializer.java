package com.project.skin_me.data;

import com.project.skin_me.model.User;
import com.project.skin_me.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationListener<ApplicationReadyEvent> {
    private final UserRepository userRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        createDefaultUserIfNotExits();
    }

    private void createDefaultUserIfNotExits() {
        for (int i = 1; i <= 5 ; i++) {
            String defualtEmail = "user"+i+"@gmail.com";

            if (userRepository.existsByEmail(defualtEmail)) {
                continue;
            }
                User user = new User();
                user.setFirstName("The User");
                user.setLastName("The User" + i);
                user.setEmail(defualtEmail);
                user.setPassword("password"+i);
                user.setConfirmPassword("password"+i);
                userRepository.save(user);
                System.out.println("Default user created" + i + "successfully.");
        }
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
