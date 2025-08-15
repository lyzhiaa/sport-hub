package kh.edu.istad_sport.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String uuid;
    @Column(nullable = false)
    private String eventUuid;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private String createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private Event event;

}
