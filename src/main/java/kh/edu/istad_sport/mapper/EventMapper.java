package kh.edu.istad_sport.mapper;

import kh.edu.istad_sport.domain.Event;
import kh.edu.istad_sport.feature.event.dto.EventCreateRequest;
import kh.edu.istad_sport.feature.event.dto.EventResponse;
import kh.edu.istad_sport.feature.event.dto.EventUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    // create event
    Event fromEventCreateRequest(EventCreateRequest eventCreateRequest);
    // get all event
    List<EventResponse> toEventResponseList(List<Event> events);
    // get event by uuid
    EventResponse toEventResponse(Event event);
    // update event by uuid
    void fromEventUpdateRequest(EventUpdateRequest eventUpdateRequest, @MappingTarget Event event);
}
