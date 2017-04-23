package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * com.urise.webapp.model.com.urise.webapp.model.Resume class
 */
//public class Resume implements Comparable<Resume> {
    // Комперибл для применения в сортед АррэейСторедж. Для сравнения резюмешек

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD) // Это команда - работать с полями, которые без сеттеров
public class Resume implements Comparable<Resume>, Serializable {
    private final static long serialVersionUID = 1L;
    // Unique identifier
    private String uuid;
    private String fullName;
    private final Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private final Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    public Resume() {
    }

    public Resume(String fullName){
        this(UUID.randomUUID().toString(), fullName);
    }
// Реализацию первого конструктора делегируем второму
    // Сохздаютсяметоды со всеми параметрами и потом создаются методы с меньшими параметрами и из них уже выхываются методы, где много параметров
    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }


    public String getUuid() {
        return uuid;
    }

    public  String getContact(ContactType type){
        return contacts.get(type);
    }

    public  Section getSection(SectionType type){
        return sections.get(type);
        }

    public void addContact(ContactType type, String value){contacts.put(type, value);}
    public void addSection(SectionType type, Section section){sections.put(type, section);}
// Когда создаем конструктор для Резюме с вводом uuid - сеттеры уже не нужны. Их можно удалить
//    public void setUuid(String uuid) {
//        this.uuid = uuid;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Resume resume = (Resume) o;
//
//        return uuid.equals(resume.uuid);
//
//    }
//
//    @Override
//    public int hashCode() {
//        return uuid.hashCode();
//    }

// DELETE it:
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Resume resume = (Resume) o;
//
//        if (!uuid.equals(resume.uuid)) return false;
//        return fullName.equals(resume.fullName);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = uuid.hashCode();
//        result = 31 * result + fullName.hashCode();
//        return result;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) &&
                Objects.equals(fullName, resume.fullName) &&
                Objects.equals(contacts, resume.contacts) &&
                Objects.equals(sections, resume.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, contacts, sections);
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')';
    }



    @Override
    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.fullName);
        return cmp != 0 ? cmp : uuid.compareTo(o.uuid);
    }

//    @Override
//    public int compareTo(Resume o) {
//        return uuid.compareTo(o.uuid); // это для того чтобы binarySearch  работал котрые не мы делали, чтобы поиск знал что сравнивать
//    }
}