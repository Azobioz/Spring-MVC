package com.springmvc.web.mapper;

import com.springmvc.web.dto.ClubDto;
import com.springmvc.web.model.Club;

import java.util.stream.Collectors;

import static com.springmvc.web.mapper.EventMapper.mapToEventDto;

public class ClubMapper {

    public static ClubDto mapToClubDto(Club club) {  // Club в ClubDto
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdBy(club.getCreatedBy())
                .createOn(club.getCreateOn())
                .updateOn(club.getUpdateOn())
                .events(club.getEvents().stream().map((event) ->  mapToEventDto(event)).collect(Collectors.toList()))
                .build();
        return clubDto;
    }

    public static Club mapToClub(ClubDto club) {
        Club clubDto = Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .createdBy(club.getCreatedBy())
                .photoUrl(club.getPhotoUrl())
                .createOn(club.getCreateOn())
                .updateOn(club.getUpdateOn())
                .build();
        return clubDto;
    }


}
