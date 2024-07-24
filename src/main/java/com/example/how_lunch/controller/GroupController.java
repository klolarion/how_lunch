package com.example.how_lunch.controller;

import com.example.how_lunch.service.GroupService;
import com.example.how_lunch.service.GroupServiceImpl;
import com.example.how_lunch.util.lunch_mate.LunchTeam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

@WebServlet("/group/*")
public class GroupController extends HttpServlet {
    private final String BASEPATH = "/WEB-INF/views";
    private GroupService groupService = new GroupServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/group.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int playerNumber = Integer.parseInt(req.getParameter("playerNumber"));
        int days = Integer.parseInt(req.getParameter("days"));
        int teamSize = Integer.parseInt(req.getParameter("teamSize"));

        List<LunchTeam> teams = groupService.generateTeams(playerNumber, days, teamSize);

        req.setAttribute("teams", teams);
        req.getRequestDispatcher(BASEPATH + "/group.jsp").forward(req, resp);
    }
}
