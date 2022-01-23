package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.domain.NotFoundException;
import ru.netology.repository.IssueRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {
    IssueRepository issueRepository = new IssueRepository();
    IssueManager manager = new IssueManager(issueRepository);

    Set<String> milestones1 = new HashSet<>();
    Set<String> labels1 = new HashSet<>();
    Set<String> assignees1 = new HashSet<>();
    Set<String> comments1 = new HashSet<>();
    Issue issue1;
    Set<String> milestones2 = new HashSet<>();
    Set<String> labels2 = new HashSet<>();
    Set<String> assignees2 = new HashSet<>();
    Set<String> comments2 = new HashSet<>();
    Issue issue2;
    Set<String> milestones3 = new HashSet<>();
    Set<String> labels3 = new HashSet<>();
    Set<String> assignees3 = new HashSet<>();
    Set<String> comments3 = new HashSet<>();
    Issue issue3;
    Set<String> milestones4 = new HashSet<>();
    Set<String> labels4 = new HashSet<>();
    Set<String> assignees4 = new HashSet<>();
    Set<String> comments4 = new HashSet<>();
    Issue issue4;
    Set<String> milestones5 = new HashSet<>();
    Set<String> labels5 = new HashSet<>();
    Set<String> assignees5 = new HashSet<>();
    Set<String> comments5 = new HashSet<>();
    Issue issue5;
    Set<String> milestones6 = new HashSet<>();
    Set<String> labels6 = new HashSet<>();
    Set<String> assignees6 = new HashSet<>();
    Set<String> comments6 = new HashSet<>();
    Issue issue6;
    Set<String> milestones7 = new HashSet<>();
    Set<String> labels7 = new HashSet<>();
    Set<String> assignees7 = new HashSet<>();
    Set<String> comments7 = new HashSet<>();
    Issue issue7;

    @BeforeEach
    public void managerInit() {
        milestones1.add("ms1");
        milestones1.add("ms2");
        labels1.add("label1");
        assignees1.add("assignee1");
        assignees1.add("assignee2");
        assignees1.add("assignee3");
        comments1.add("comment1");
        comments1.add("comment2");

        issue1 = new Issue(1, true, 1052, "head1", "desc1",
                "author1", "project1", milestones1, labels1, assignees1, comments1);

        milestones2.add("ms2");
        labels2.add("label1");
        labels2.add("label3");
        assignees2.add("assignee2");
        comments2.add("comment1");
        comments2.add("comment2");
        comments2.add("comment3");
        comments2.add("comment4");

        issue2 = new Issue(2, false, 1098, "head2", "desc2",
                "author2", "project1", milestones2, labels2, assignees2, comments2);

        milestones3.add("ms1");
        labels3.add("label1");
        labels3.add("label2");
        labels3.add("label4");
        assignees3.add("assignee1");
        assignees3.add("assignee2");
        assignees3.add("assignee3");
        comments3.add("comment1");

        issue3 = new Issue(3, true, 1005, "head3", "desc3",
                "author2", "project3", milestones3, labels3, assignees3, comments3);

        milestones4.add("ms2");
        milestones4.add("ms3");
        labels4.add("label2");
        labels4.add("label3");
        assignees4.add("assignee3");
        comments4.add("comment1");
        comments4.add("comment2");

        issue4 = new Issue(4, true, 1346, "head4", "desc4",
                "author1", "project1", milestones4, labels4, assignees4, comments4);

        milestones5.add("ms1");
        milestones5.add("ms3");
        labels5.add("label1");
        labels5.add("label4");
        assignees5.add("assignee1");
        assignees5.add("assignee2");
        comments5.add("comment1");
        comments5.add("comment2");
        comments5.add("comment3");

        issue5 = new Issue(5, false, 1123, "head5", "desc5",
                "author2", "project2", milestones5, labels5, assignees5, comments5);

        labels6.add("label2");
        assignees6.add("assignee2");

        issue6 = new Issue(6, true, 1109, "head6", "desc6",
                "author3", "project1", milestones6, labels6, assignees6, comments6);

        milestones7.add("ms3");
        labels7.add("label4");
        assignees7.add("assignee2");
        assignees7.add("assignee4");

        issue7 = new Issue(7, false, 1063, "head7", "desc7",
                "author3", "project2", milestones7, labels7, assignees7, comments7);

        manager.addIssue(issue1);
        manager.addIssue(issue2);
        manager.addIssue(issue3);
        manager.addIssue(issue4);
        manager.addIssue(issue5);
        manager.addIssue(issue6);
        manager.addIssue(issue7);
    }

    @Test
    void shouldFindOpenIssues() {
        List<Issue> actual = manager.findOpenIssues();
        List<Issue> expected = new ArrayList<>();
        expected.add(issue1);
        expected.add(issue3);
        expected.add(issue4);
        expected.add(issue6);
        assertEquals(actual, expected);
    }

    @Test
    void shouldFindCloseIssues() {
        List<Issue> actual = manager.findCloseIssues();
        List<Issue> expected = new ArrayList<>();
        expected.add(issue2);
        expected.add(issue5);
        expected.add(issue7);
        assertEquals(actual, expected);
    }

    @Test
    void shouldFindIssuesByValidAuthor() {
        List<Issue> actual = manager.findIssuesByAuthor("author2");
        List<Issue> expected = new ArrayList<>();
        expected.add(issue2);
        expected.add(issue3);
        expected.add(issue5);
        assertEquals(actual, expected);
    }

    @Test
    void shouldFindIssuesByInvalidAuthor() {
        List<Issue> actual = manager.findIssuesByAuthor("author5");
        List<Issue> expected = new ArrayList<>();
        assertEquals(actual, expected);
    }

    @Test
    void shouldFindIssuesByValidLabel() {
        List<Issue> actual = manager.findIssuesByLabel("label3");
        List<Issue> expected = new ArrayList<>();
        expected.add(issue2);
        expected.add(issue4);
        assertEquals(actual, expected);
    }

    @Test
    void shouldFindIssuesByInvalidLabel() {
        List<Issue> actual = manager.findIssuesByLabel("label5");
        List<Issue> expected = new ArrayList<>();
        assertEquals(actual, expected);
    }

    @Test
    void shouldFindIssuesByValidAssignee() {
        List<Issue> actual = manager.findIssuesByAssignee("assignee2");
        List<Issue> expected = new ArrayList<>();
        expected.add(issue1);
        expected.add(issue2);
        expected.add(issue3);
        expected.add(issue5);
        expected.add(issue6);
        expected.add(issue7);
        assertEquals(actual, expected);
    }

    @Test
    void shouldFindIssuesByInvalidAssignee() {
        List<Issue> actual = manager.findIssuesByAssignee("assignee5");
        List<Issue> expected = new ArrayList<>();
        assertEquals(actual, expected);
    }

    @Test
    void shouldSortIssuesByCreateDate() {
        manager.sortingByCreateDate();
        List<Issue> actual = manager.getIssues().getIssueList();
        List<Issue> expected = new ArrayList<>();
        expected.add(issue3);
        expected.add(issue1);
        expected.add(issue7);
        expected.add(issue2);
        expected.add(issue6);
        expected.add(issue5);
        expected.add(issue4);
        assertEquals(actual, expected);
    }

    @Test
    void shouldReverseSortIssuesByCreateDate() {
        manager.sortingReverseByCreateDate();
        List<Issue> actual = manager.getIssues().getIssueList();
        List<Issue> expected = new ArrayList<>();
        expected.add(issue4);
        expected.add(issue5);
        expected.add(issue6);
        expected.add(issue2);
        expected.add(issue7);
        expected.add(issue1);
        expected.add(issue3);
        assertEquals(actual, expected);
    }

    @Test
    void shouldUpdateIssueStatusFromOpenedToClosedByValidId() {
        manager.updateIssueById(1);
        int index = manager.getIssues().getIssueIndexById(1);
        boolean actual = manager.getIssues().getIssueList().get(index).getStatus();
        assertEquals(actual, false);
    }

    @Test
    void shouldUpdateIssueStatusFromClosedToOpenedByValidId() {
        manager.updateIssueById(2);
        int index = manager.getIssues().getIssueIndexById(1);
        boolean actual = manager.getIssues().getIssueList().get(index).getStatus();
        assertEquals(actual, true);
    }

    @Test
    void shouldUpdateIssueStatusByInvalidId() {
        assertThrows(NotFoundException.class, () -> {
            manager.updateIssueById(10);;
        });
    }
}