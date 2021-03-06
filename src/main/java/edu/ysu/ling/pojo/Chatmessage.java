package edu.ysu.ling.pojo;

import java.util.Date;

/**
 * Created by 10047 on 2017/4/22.
 */

public class Chatmessage {

    private String chatId;
    private String businessUserId;
    private String userId;
    private String chatInfo;
    private Date chatDateTime;
    private String sendFrom;//1 表示普通用户发送 2 表示企业用户发送
    private String jobMessageId;

    private Businessuser businessuser;
    private User user;
    private Requirementinfo requirementinfo;


    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }


    public String getBusinessUserId() {
        return businessUserId;
    }

    public void setBusinessUserId(String businessUserId) {
        this.businessUserId = businessUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChatInfo() {
        return chatInfo;
    }

    public void setChatInfo(String chatInfo) {
        this.chatInfo = chatInfo;
    }

    public Date getChatDateTime() {
        return chatDateTime;
    }

    public void setChatDateTime(Date chatDateTime) {
        this.chatDateTime = chatDateTime;
    }

    public String getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom;
    }

    public String getJobMessageId() {
        return jobMessageId;
    }

    public void setJobMessageId(String jobMessageId) {
        this.jobMessageId = jobMessageId;
    }

    public Businessuser getBusinessuser() {
        return businessuser;
    }

    public void setBusinessuser(Businessuser businessuser) {
        this.businessuser = businessuser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Requirementinfo getRequirementinfo() {
        return requirementinfo;
    }

    public void setRequirementinfo(Requirementinfo requirementinfo) {
        this.requirementinfo = requirementinfo;
    }
}
