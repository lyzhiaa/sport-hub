package kh.edu.istad_sport.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "events")
@Setter
@Getter
@RequiredArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uuid;

    private String name;

    private String description;

    @Column(nullable = false, unique = true)
    private String locationName;

    @Column(nullable = false, unique = true)
    private Double latitude;

    @Column(nullable = false, unique = true)
    private Double longitude;

    @Column(updatable = false)
    private String createdAt;

    private String updatedAt;

    Boolean disabled;
    Boolean enabled;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;


}
