package mvc_hibernate.repository;

import mvc_hibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Все базовые CRUD методы предоставляются JpaRepository
}