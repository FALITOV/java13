import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Позвонить");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskNoMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("позвонить");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testSimpleTaskEmptyTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "привет");
        String actual = simpleTask.getTitle();
        String expected = "привет";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Молоко", "Яйца"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Молоко");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicNoMatches() {
        String[] subtasks = {"Молоко", "Яйца"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Хлеб");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicEmptySubtasks() {
        String[] subtasks = {"Молоко", "Яйца"};
        Epic epic = new Epic(55, subtasks);
        String[] actual = epic.getSubtasks();
        String[] expected = {"Молоко", "Яйца"};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testMeetingMatchesTopic() {
        Meeting meeting = new Meeting(55, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("Выкатка");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testMeetingMatchesProject() {
        Meeting meeting = new Meeting(55, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("Приложение");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingNoMatches() {
        Meeting meeting = new Meeting(55, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("выкатка");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingEmptyProject() {
        Meeting meeting = new Meeting(55, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String actual = ("Приложение НетоБанка");
        String expected = meeting.getProject();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingEmptyStart() {
        Meeting meeting = new Meeting(55, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String actual = ("Во вторник после обеда");
        String expected = meeting.getStart();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingEmptyTopic() {
        Meeting meeting = new Meeting(55, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String actual = ("Выкатка 3й версии приложения");
        String expected = meeting.getTopic();
        Assertions.assertEquals(expected, actual);
    }


}