package com.example.how_lunch.dao;

import java.util.List;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public interface GroupDAO {

    /*그룹생성 - 그룹장아이디(long), 그룹원아이디 목록(List<Long>)*/
    void createGroup(long leaderId, List<Long> userIds);
    /*그룹해제 - 그룹아이디(long), 그룹장아이디(long)*/
    void dismissGroup(long groupId, long leaderId);

    void randomGroup(int playerNumber, int days, int teamSize);
}
