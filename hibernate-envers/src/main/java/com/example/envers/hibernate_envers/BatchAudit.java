package com.example.envers.hibernate_envers;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BatchAudit {

    @Id
    @GeneratedValue
    private Long id;

    private Long batch_id;

    @Enumerated(EnumType.STRING)
    private Status batch_run_status;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedDate;

    @Column(updatable = false)
    private String createdUser;

    private String updatedUser;

    public enum Status {
        IN_PROGRESS, COMPLETED, FAILED
    }

}
