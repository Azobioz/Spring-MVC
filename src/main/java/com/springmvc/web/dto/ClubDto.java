package com.springmvc.web.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ClubDto {

    private Long id;
    @NotEmpty(message = "No empty title")
    private String title;
    @NotEmpty(message = "No empty photo url link")
    private String photoUrl;
    @NotEmpty(message = "No empty content")
    private String content;
    private LocalDateTime createOn;
    private LocalDateTime updateOn;
    private List<EventDto> events;
}
