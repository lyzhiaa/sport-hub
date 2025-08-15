package kh.edu.istad_sport.feature.sport;

import jdk.jfr.Category;
import kh.edu.istad_sport.domain.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SportRepository extends JpaRepository<Sport, String> {
//    boolean existsByUuid(String uuid);
    boolean existsByName(String name);
    Optional<Sport> findByUuid(String uuid);
//    Optional<Sport> findByName(String name);
    List<Sport> findBySportCategoryUuid(String sportCategoryUuid);

}
