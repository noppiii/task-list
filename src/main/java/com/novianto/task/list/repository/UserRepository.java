package com.novianto.task.list.repository;

import com.novianto.task.list.domain.user.Role;
import com.novianto.task.list.domain.user.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findUserById(Long id);
    Optional<User> findByUsername(String username);
    void update(User user);
    void create(User user);
    void insertUserRole(Long userId, Role role);
    boolean isTaskOwner(Long userId, Long taskId);
    void delete(Long id);
}
