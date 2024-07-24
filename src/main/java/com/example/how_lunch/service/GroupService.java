package com.example.how_lunch.service;

import com.example.how_lunch.util.lunch_mate.LunchTeam;

import java.util.List;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public interface GroupService {
    List<LunchTeam> generateTeams(int playerNumber, int days, int teamSize);
}
