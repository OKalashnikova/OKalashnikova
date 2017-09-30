package com.urise.webapp.model;

/**
 * Created by OK on 03.02.2017.
 */
public enum ContactType {
        PHONE("Тел."),
        MOBILE("Мобильный"),
        HOME_PHONE("домашний тел."),
        SKYPE("Skype"){
            @Override
            public String toHtml0(String value){
                return "<a href = 'skype:" + value + "'>" +value + "</a>";
            }
        },
        MAIL("Почта"){
            @Override
            public String toHtml0(String value) {
                
                return "<a href='mailto:" + value + "'>" + value + "</a>";
            }
        },
        LINKEDIN("Профиль в LinkedIn"),
        GITHUB("Профиль GitHub"),
        STACKOVERFLOW("Профиль Stack Overflow"),
        HOME_PAGE("Домашняя страница");


        private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    protected String toHtml0(String value) { return title + ": " + value; }

    public String toHtml(String value) {
       return(value == null) ? "" : toHtml0(value);

    }
}
