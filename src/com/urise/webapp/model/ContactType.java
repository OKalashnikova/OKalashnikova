package com.urise.webapp.model;

/**
 * Created by OK on 03.02.2017.
 */
public enum ContactType {
        PHONE("Тел."),
        MOBILE("Мобильный"),
        HOME_PHONE("домашний тел."),
        SKYPE("Skype"),
        MAIL("Почта"),
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
}
