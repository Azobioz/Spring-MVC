package com.springmvc.web.dto;


import com.springmvc.web.model.Club;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {


    private Long id;

    @NotEmpty(message = "No empty name")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @NotNull(message = "must have start time")
    private LocalDateTime startTime;

    @NotNull(message = "must have end time")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime endTime;

    @NotEmpty(message = "No empty type")
    private String type;

    @NotEmpty(message = "No empty name")
    private String photoUrl;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private Club club;


}
