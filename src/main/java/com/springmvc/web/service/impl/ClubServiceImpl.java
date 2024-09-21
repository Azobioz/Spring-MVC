package com.springmvc.web.service.impl;

import com.springmvc.web.dto.ClubDto;
import com.springmvc.web.repository.ClubRepository;
import com.springmvc.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.web.model.Club;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
         List<Club> clubs = clubRepository.findAll();
         return clubs.stream().map((club) -> mapToClubDto(club))
                 .collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        return clubRepository.save(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.save(club);
    }

    @Override
    public void deleteClub(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    private Club mapToClub(ClubDto club) {
        Club clubDto = Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .photoUrl(club.getPhotoUrl())
                .createOn(club.getCreateOn())
                .updateOn(club.getUpdateOn())
                .build();
        return clubDto;
    }

    @Override
    public ClubDto findClubById(Long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    private ClubDto mapToClubDto(Club club) {  // Club в ClubDto
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createOn(club.getCreateOn())
                .updateOn(club.getUpdateOn())
                .build();
        return clubDto;
    }

}
