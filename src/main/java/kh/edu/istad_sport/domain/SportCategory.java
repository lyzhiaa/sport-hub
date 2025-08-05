package kh.edu.istad_sport.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sports_categories")
@Setter
@Getter
public class SportCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String createdAt;

    private String updatedAt;

    @OneToMany(mappedBy = "sportCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sport> sports;
}
