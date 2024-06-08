package com.leultewolde.cms.model;

import com.leultewolde.cms.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;

    private String title;
    private String description;
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToMany
    @JoinTable(
            name = "task_publishing_platform",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private List<PublishingPlatform> targetPlatforms;

    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    @OneToMany(mappedBy = "belongsTo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Content> contents;

    @ManyToOne
    @JoinColumn(name = "task_queue_id")
    private TaskQueue taskQueue;
}

