package com.example.how_lunch.model;

import java.util.List;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public class Group {
    private long groupId;
    private long leaderId;
    private List<Long> userIds;
    private boolean isDismissed;

    public Group(long leaderId, List<Long> userIds) {
        this.leaderId = leaderId;
        this.userIds = userIds;
    }

    public long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(long leaderId) {
        this.leaderId = leaderId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public void setDismissed(boolean dismissed) {
        isDismissed = dismissed;
    }

    public long getGroupId() {
        return groupId;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public boolean isDismissed() {
        return isDismissed;
    }
}
