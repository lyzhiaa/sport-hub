package kh.edu.istad_sport.feature.event;

import jakarta.validation.Valid;
import kh.edu.istad_sport.feature.event.dto.EventCreateRequest;
import kh.edu.istad_sport.feature.event.dto.EventResponse;
import kh.edu.istad_sport.feature.event.dto.EventUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/events")
public class EventController {
    private final EventService eventService;

    // create event
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    EventResponse creatEvent(@Valid @RequestBody EventCreateRequest eventCreateRequest) {
        return eventService.createEvent(eventCreateRequest);
    }

    // get all events
    @GetMapping
    List<EventResponse> getAllEvents() {
        return eventService.getAllEvents();
    }

    // get event by uuid
    @GetMapping("/{uuid}")
    EventResponse getEventByUuid(@Valid @PathVariable("uuid") String uuid) {
        return eventService.getEventByUuid(uuid);
    }

    // update event by uuid
    @PatchMapping("/{uuid}")
    EventResponse updateEvent(@Valid @PathVariable("uuid") String uuid, @RequestBody EventUpdateRequest eventUpdateRequest) {
        return eventService.updateEvent(uuid, eventUpdateRequest);
    }
}
