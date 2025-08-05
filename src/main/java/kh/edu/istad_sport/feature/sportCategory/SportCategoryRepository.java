package kh.edu.istad_sport.feature.sportCategory;

import kh.edu.istad_sport.domain.SportCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SportCategoryRepository extends JpaRepository<SportCategory, String> {
    //get sport category by name
    Boolean existsByName(String name);
    Optional<SportCategory> findByUuid(String uuid);
    Optional<SportCategory> findByName(String name);
}
