package com.springmvc.web.service;

import com.springmvc.web.dto.ClubDto;
import com.springmvc.web.model.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club saveClub(ClubDto clubDto);
    ClubDto findClubById(Long clubId);
    void updateClub(ClubDto club);
    void deleteClub(Long clubId);
}
