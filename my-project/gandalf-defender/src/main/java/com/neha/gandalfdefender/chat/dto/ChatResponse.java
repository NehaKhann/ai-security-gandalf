package com.neha.gandalfdefender.chat.dto;

public class ChatResponse {

    private String reply;
    private boolean blockedByInputFilter;
    private boolean blockedByOutputFilter;

    public ChatResponse(String reply, boolean blockedByInputFilter, boolean blockedByOutputFilter) {
        this.reply = reply;
        this.blockedByInputFilter = blockedByInputFilter;
        this.blockedByOutputFilter = blockedByOutputFilter;
    }

    public String getReply() {
        return reply;
    }

    public boolean isBlockedByInputFilter() {
        return blockedByInputFilter;
    }

    public boolean isBlockedByOutputFilter() {
        return blockedByOutputFilter;
    }
}
