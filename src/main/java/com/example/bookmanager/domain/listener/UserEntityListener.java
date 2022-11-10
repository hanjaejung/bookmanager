package com.example.bookmanager.domain.listener;

import com.example.bookmanager.domain.UserHistory;
import com.example.bookmanager.domain.Users;
import com.example.bookmanager.repository.UserHistoryRepository;
import com.example.bookmanager.support.BeenUtils;


import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UserEntityListener {
    @PrePersist
    @PreUpdate
    public void prePersistAndPreUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeenUtils.getBean(UserHistoryRepository.class);

        Users user = (Users) o;

        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());

        userHistoryRepository.save(userHistory);
    }
}
