package com.springmvc.web.service;

import com.springmvc.web.dto.ClubDto;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
}
