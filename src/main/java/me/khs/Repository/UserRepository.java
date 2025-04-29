package me.khs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.khs.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
