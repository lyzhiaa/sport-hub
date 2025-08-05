package kh.edu.istad_sport.feature.event;

import kh.edu.istad_sport.domain.Event;
import kh.edu.istad_sport.feature.event.dto.EventCreateRequest;
import kh.edu.istad_sport.feature.event.dto.EventResponse;
import kh.edu.istad_sport.feature.event.dto.EventUpdateRequest;

import java.util.List;

public interface EventService {
    // create event
    EventResponse createEvent(EventCreateRequest eventCreateRequest);
    // get all event
    List<EventResponse> getAllEvents();
    // get event by uuid
    EventResponse getEventByUuid(String uuid);
    // update event
    EventResponse updateEvent(String uuid, EventUpdateRequest eventUpdateRequest);
    // delete event
    void deleteEvent(String uuid);
}
