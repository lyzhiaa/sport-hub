package kh.edu.istad_sport.feature.category;

import kh.edu.istad_sport.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {
    //get sport category by name
    Boolean existsByName(String name);
    Optional<Category> findByUuid(String uuid);
    Optional<Category> findByName(String name);
}
