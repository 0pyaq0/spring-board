package com.example.board.infrastructure.persistence;

import com.example.board.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    /* user GET */
    User findByNickname(String nickname);
}
