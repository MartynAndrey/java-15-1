package ru.netology.domain;

import java.util.Set;

public class Issue implements Comparable<Issue>{
    private int id;                 //идентификатор
    private boolean status;         //состояние открыт - 1/закрыт - 0
    private int creationDate;       //дата создания
    private String header;          //заголовок
    private String description;     //содержание
    private String author;          //автор
    private String project;         //название проекта
    private Set<String> milestones; //набор вех
    private Set<String> labels;     //набор тегов
    private Set<String> assignees;  //набор приемников
    private Set<String> comments;   //комментарии

    public Issue() {}

    public Issue(int id, boolean status, int creationDate, String header, String description,
                 String author, String project, Set<String> milestones, Set<String> labels,
                 Set<String> assignees, Set<String> comments) {
        this.id = id;
        this.status = status;
        this.creationDate = creationDate;
        this.header = header;
        this.description = description;
        this.author = author;
        this.project = project;
        this.milestones = milestones;
        this.labels = labels;
        this.assignees = assignees;
        this.comments = comments;
    }

    public int getId() {
        return this.id;
    }

    public boolean getStatus() {
        return this.status;
    }

    public int getCreationDate() {
        return this.creationDate;
    }

    public String getHeader() {
        return this.header;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getProject() {
        return this.project;
    }

    public Set<String> getMilestones() {
        return this.milestones;
    }

    public Set<String> getLabels() {
        return this.labels;
    }

    public Set<String> getAssignees() {
        return this.assignees;
    }

    public Set<String> getComments() {
        return this.comments;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setMilestones(Set<String> milestones) {
        this.milestones = milestones;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    public void setAssignees(Set<String> assignees) {
        this.assignees = assignees;
    }

    public void setComments(Set<String> comments) {
        this.comments = comments;
    }

    public void updateStatus() {
        this.status = !this.status;
    }

    @Override
    public int compareTo(Issue issue) {
        return this.creationDate - issue.creationDate;
    }
}