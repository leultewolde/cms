package com.leultewolde.cms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "content-histories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer changeId;

    private LocalDate changeDate;
    private String changeDescription;
    private String version;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;

    @ManyToOne
    @JoinColumn(name = "modified_by")
    private User modifiedBy;
}
