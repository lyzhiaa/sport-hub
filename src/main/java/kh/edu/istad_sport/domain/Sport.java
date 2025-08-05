package kh.edu.istad_sport.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sports")
@Getter
@Setter
@RequiredArgsConstructor
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uuid;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 1000)
    private String description;

    @ElementCollection
    private List<String> imageUrls;

    @Column(updatable = false)
    private String createdAt;

    private String updatedAt;

    Boolean disabled;
    Boolean enabled;

//    @JoinTable(
//            name = "sport_category_mapping",
//            joinColumns = @JoinColumn(name = "sport_id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id")
//    )
    // Category
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "sport_category_id", nullable = false)
    private SportCategory sportCategory;

}
