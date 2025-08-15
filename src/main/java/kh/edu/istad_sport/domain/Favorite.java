package kh.edu.istad_sport.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uuid;
    private String sportUuid;
    private String eventUuid;
    private LocalDateTime createdAt;
    private Boolean isDeleted;
    private Boolean isFavorite;
}
