package com.springmvc.web.service.impl;

import com.springmvc.web.dto.ClubDto;
import com.springmvc.web.model.UserEntity;
import com.springmvc.web.repository.ClubRepository;
import com.springmvc.web.repository.UserRepository;
import com.springmvc.web.security.SecurityUtil;
import com.springmvc.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.web.model.Club;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.springmvc.web.mapper.ClubMapper.mapToClub;
import static com.springmvc.web.mapper.ClubMapper.mapToClubDto;


@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;
    private UserRepository userRepository;

    public ClubServiceImpl(ClubRepository clubRepository, UserRepository userRepository) {
        this.clubRepository = clubRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
         List<Club> clubs = clubRepository.findAll();
         return clubs.stream().map((club) -> mapToClubDto(club))
                 .collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Club club = mapToClub(clubDto);
        club.setCreatedBy(user);
        return clubRepository.save(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Club club = mapToClub(clubDto);
        club.setCreatedBy(user);
        clubRepository.save(club);
    }

    @Override
    public void deleteClub(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public ClubDto findClubById(Long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }


}
