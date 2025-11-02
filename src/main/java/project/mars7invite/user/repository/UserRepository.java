package project.mars7invite.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.mars7invite.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

