package com.springmvc.web.controller;

import com.springmvc.web.dto.ClubDto;
import com.springmvc.web.dto.EventDto;
import com.springmvc.web.model.Club;
import com.springmvc.web.model.Event;
import com.springmvc.web.model.UserEntity;
import com.springmvc.web.security.SecurityUtil;
import com.springmvc.web.service.ClubService;
import com.springmvc.web.service.EventService;
import com.springmvc.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClubController {

    private ClubService clubService;
    private UserService userService;
    private EventService eventService;

    @Autowired
    public ClubController(ClubService clubService, UserService userService, EventService eventService) {
        this.clubService = clubService;
        this.userService = userService;
        this.eventService = eventService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model) {
        UserEntity user = new UserEntity();
        List<ClubDto> clubs = clubService.findAllClubs();
        String username = SecurityUtil.getSessionUser();
        if(username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("club", clubDto);
            return "clubs-create";
        }
        clubService.saveClub(clubDto);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") Long clubId, Model model) {
        ClubDto club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "clubs-edit";
    }

    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Long clubId, @Valid @ModelAttribute("club") ClubDto club,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("club", club);
            return "clubs-edit";
        }
        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubId}")
    public String clubDetail(@PathVariable("clubId") Long clubId, Model model) {
        UserEntity user = new UserEntity();
        ClubDto clubDto = clubService.findClubById(clubId);
        String username = SecurityUtil.getSessionUser();
        if(username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("club", clubDto);
        return "clubs-detail";
    }

    @GetMapping("/clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") Long clubId) {
        clubService.deleteClub(clubId);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value="query") String query, Model model) {
        List<ClubDto> clubs = clubService.searchClubs(query);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }


}
