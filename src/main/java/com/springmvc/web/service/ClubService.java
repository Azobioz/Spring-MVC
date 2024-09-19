package com.springmvc.web.service;

import com.springmvc.web.dto.ClubDto;
import com.springmvc.web.model.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club saveClub(Club club);
}
