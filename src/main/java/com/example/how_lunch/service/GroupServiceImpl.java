package com.example.how_lunch.service;


import org.groom.io.how_lunch.LunchMate;
import org.groom.io.how_lunch.LunchTeam;

import java.util.List;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public class GroupServiceImpl implements GroupService{
    @Override
    public List<LunchTeam> generateTeams(int playerNumber, int days, int teamSize) {
        System.out.println("333");
        try {
            LunchMate lunchMate = new LunchMate(playerNumber, days, teamSize);
            return lunchMate.generateTeams();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("4444");
        return null;
    }
}
