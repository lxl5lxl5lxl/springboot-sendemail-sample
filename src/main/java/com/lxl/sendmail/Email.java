package com.lxl.sendmail;

/**
 * Created by lxl on 16/7/19.
 */
public class Email {

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String to;
    private String subject;
    private String text;

}
