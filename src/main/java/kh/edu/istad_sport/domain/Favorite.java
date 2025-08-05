package kh.edu.istad_sport.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Favorite {
    private String id;
    private String uuid;
    private String sportUuid;
    private String eventUuid;
    private Boolean isDeleted;
    private Boolean isFavorite;

}
