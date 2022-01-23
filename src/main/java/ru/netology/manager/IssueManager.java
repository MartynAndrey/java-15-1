package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.domain.NotFoundException;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IssueManager {
    private IssueRepository issues;

    public IssueManager(IssueRepository issueRepository) {
        this.issues = issueRepository;
    }

    public IssueRepository getIssues() {
        return this.issues;
    }

    public void addIssue(Issue issue) {
        this.issues.addIssue(issue);
    }

    public List<Issue> findOpenIssues() {
        List<Issue> openIssueList = new ArrayList<>();
        for (Issue issue : this.issues.getIssueList()) {
            if (issue.getStatus()) {
                openIssueList.add(issue);
            }
        }
        return openIssueList;
    }

    public List<Issue> findCloseIssues() {
        List<Issue> closeIssueList = new ArrayList<>();
        for (Issue issue : this.issues.getIssueList()) {
            if (!issue.getStatus()) {
                closeIssueList.add(issue);
            }
        }
        return closeIssueList;
    }

    public List<Issue> findIssuesByAuthor(String author) {
        List<Issue> result = new ArrayList<>();

        for (Issue issue: this.issues.getIssueList()) {
            if (issue.getAuthor() == author) {
                result.add(issue);
            }
        }

        return result;
    }

    public List<Issue> findIssuesByLabel(String label) {
        List<Issue> result = new ArrayList<>();

        for (Issue issue: this.issues.getIssueList()) {
            if (issue.getLabels().contains(label)) {
                result.add(issue);
            }
        }

        return result;
    }

    public List<Issue> findIssuesByAssignee(String assignee) {
        List<Issue> result = new ArrayList<>();

        for (Issue issue: this.issues.getIssueList()) {
            if (issue.getAssignees().contains(assignee)) {
                result.add(issue);
            }
        }

        return result;
    }

    public void updateIssueById(int id) {
        int index = this.issues.getIssueIndexById(id);

        if (index < 0) {
            throw new NotFoundException("The issue with id = " + id + " was not found");
        } else {
            this.issues.getIssueList().get(index).updateStatus();
        }
    }

    public void sortingByCreateDate() {
        Collections.sort(this.issues.getIssueList());
    }

    public void sortingReverseByCreateDate() {
        Collections.sort(this.issues.getIssueList());
        Collections.reverse(this.issues.getIssueList());
    }
}