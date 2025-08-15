package kh.edu.istad_sport.feature.event;

import kh.edu.istad_sport.domain.Category;
import kh.edu.istad_sport.domain.Event;
import kh.edu.istad_sport.domain.SportCategory;
import kh.edu.istad_sport.feature.category.CategoryRepository;
import kh.edu.istad_sport.feature.event.dto.EventCreateRequest;
import kh.edu.istad_sport.feature.event.dto.EventResponse;
import kh.edu.istad_sport.feature.event.dto.EventUpdateRequest;
import kh.edu.istad_sport.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final CategoryRepository categoryRepository;

    // create event
    @Override
    public EventResponse createEvent(EventCreateRequest eventCreateRequest) {
        if (eventRepository.existsByName(eventCreateRequest.name())) {
            throw new RuntimeException("Event with name " + eventCreateRequest.name() + " already exists");
        }
        // Check if category exists, otherwise create a new one
        Category category = categoryRepository.findByName(eventCreateRequest.categoryName())
                .orElseGet(() -> {
                    Category newCategory = new Category();
                    newCategory.setName(eventCreateRequest.categoryName());
                    return categoryRepository.save(newCategory);
                });
        Event event = eventMapper.fromEventCreateRequest(eventCreateRequest);
        event.setUuid(java.util.UUID.randomUUID().toString());
        event.setCreatedAt(String.valueOf(LocalDateTime.now()));
        event.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        event.setCategory(category);
        eventRepository.save(event);
        return eventMapper.toEventResponse(event);
    }

    // get all event
    @Override
    public List<EventResponse> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return eventMapper.toEventResponseList(events);
    }

    // get event by uuid
    @Override
    public EventResponse getEventByUuid(String uuid) {
        Event event = eventRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Event with uuid " + uuid + " not found"));
        return eventMapper.toEventResponse(event);
    }

    // update event
    @Override
    public EventResponse updateEvent(String uuid, EventUpdateRequest eventUpdateRequest) {
        Event event = eventRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Event with uuid " + uuid + " not found"));

        eventMapper.fromEventUpdateRequest(eventUpdateRequest, event);
        event.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        eventRepository.save(event);

        return eventMapper.toEventResponse(event);
    }

    // delete
    @Override
    public void deleteEvent(String uuid) {
        Event event = eventRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Event with uuid " + uuid + " not found"));
        eventRepository.delete(event);
    }
}
