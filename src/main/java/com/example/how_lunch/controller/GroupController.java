package com.example.how_lunch.controller;

import com.example.how_lunch.service.GroupService;
import com.example.how_lunch.service.GroupServiceImpl;

import javax.servlet.annotation.WebServlet;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

@WebServlet("/group/*")
public class GroupController {
    private final String BASEPATH = "/WEB-INF/views";
    private GroupService groupService = new GroupServiceImpl();
}
