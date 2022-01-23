package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.List;

public class IssueRepository {
    private List<Issue> issueList = new ArrayList<>();

    public IssueRepository() {}

    public IssueRepository(List<Issue> issueList) {
        this.issueList = issueList;
    }

    public void addIssue(Issue issue) {
        this.issueList.add(issue);
    }

    public void removeIssue(int index) {
        this.issueList.remove(index);
    }

    public List<Issue> getIssueList() {
        return this.issueList;
    }

    public int getIssueIndexById(int id) {
        for (int i = 0; i < this.issueList.size(); i++) {
            if (issueList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}