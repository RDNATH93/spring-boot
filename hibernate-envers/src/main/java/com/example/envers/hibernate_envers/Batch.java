package com.example.envers.hibernate_envers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Batch {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "batch_name")
    private String name;

    @Column(name = "batch_description")
    private String description;

    @CreatedDate
    @Column(nullable = false, updatable = false, name = "created_date")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false, name = "updated_date")
    private LocalDateTime updatedDate;

    @CreatedBy
    @Column(nullable = false, updatable = false, name = "created_user")
    private String createdUser;

    @LastModifiedBy
    @Column(insertable = false, name = "updated_user")
    private String updatedUser;

}
