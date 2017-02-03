package com.urise.webapp.model;

/**
 * Created by OK on 03.02.2017.
 */
public enum SectionType {
        PERSONAL("Личные качества"),
        OBJECTIVE("Позиция"),
        ACHIEVEMENT("Достижения"),
        QUALIFICATIONS("Квалификация"),
        EXPERIENCE("Опыт работы"),
        EDUCATION("Образование");

        private String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
