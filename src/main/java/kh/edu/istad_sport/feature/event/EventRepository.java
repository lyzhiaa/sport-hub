package kh.edu.istad_sport.feature.event;

import kh.edu.istad_sport.domain.Event;
import kh.edu.istad_sport.domain.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, String> {
    boolean existsByName(String name);
    Optional<Event> findByUuid(String uuid);
    Optional<Event> findByName(String name);
    List<Event> findByCategoryUuid(String categoryUuid);

}
