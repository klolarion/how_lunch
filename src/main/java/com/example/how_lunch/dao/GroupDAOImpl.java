package com.example.how_lunch.dao;



import com.example.how_lunch.util.lunch_mate.LunchMate;
import com.example.how_lunch.util.lunch_mate.LunchTeam;

import java.util.List;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public class GroupDAOImpl implements GroupDAO{
    /*그룹생성 - 그룹장아이디(long), 그룹원아이디 목록(List<Long>)
    * LunchMate 라이브러리 사용해서 그룹 랜덤생성
    * */
    @Override
    public void createGroup(long leaderId, List<Long> userIds) {


    }

    /*그룹해제 - 그룹아이디(long), 그룹장아이디(long)*/
    @Override
    public void dismissGroup(long groupId, long leaderId) {

    }

    /*랜덤그룹생성 - 인원수(int), 일수(int), 팀원수(int)*/
    @Override
    public void randomGroup(int playerNumber, int days, int teamSize) {
        LunchMate lunchMate = new LunchMate(playerNumber, days, teamSize);
        List<LunchTeam> teams = lunchMate.generateTeams();
    }
}
