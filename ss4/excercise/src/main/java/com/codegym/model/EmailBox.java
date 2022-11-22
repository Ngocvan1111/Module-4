package com.codegym.model;

public class EmailBox {
    private int id;
    private String languages;
    private int pageSize;
    private boolean spamFilter;
    private String signature;

    public EmailBox(String languages, int pageSize, boolean spamFilter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public EmailBox(int id, String languages, int pageSize, boolean spamFilter, String signature) {
        this.id = id;
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public EmailBox() {
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
