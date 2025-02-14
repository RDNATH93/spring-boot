package com.example.envers.hibernate_envers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    @Convert(converter = LocalDateTimeToStringConverter.class)
    @CreatedDate
    @Column(nullable = false, updatable = false, name = "created_date")
    private LocalDateTime createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    @Convert(converter = LocalDateTimeToStringConverter.class)
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
