package com.leultewolde.cms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "task-queues")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer queueId;

    @OneToMany(mappedBy = "taskQueue", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}

