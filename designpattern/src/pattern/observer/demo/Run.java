package pattern.observer.demo;


import pattern.observer.structure.IObserverable;
import pattern.observer.structure.Obverser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * School vai trò thông báo đế tất cả các sinh viên, giáo viên, staff để tiêm covid (đóng vai trò là Observerable)
 * abstract Staff là chỗ nhận thông báo từ trường học
 * scenario: 1 trường học có 5 học sinh và 5 sinh viên  và muốn thông báo đến tất cả là sẽ tiêm vaccine.
 * trường gửi thông báo đí,
 * có 1 giáo viên gửi trả lời thông báo của trường,
 * trường nhận thông báo phân tích thông báo đó
 * giử lại tất cả nhân viên 1 thông báo khác sẽ hủy tiêm vaccine vì có vấn đề vaccine.
 */
public class Run {

    public static void main(String[] args) {

        // initial evn
        School school = new School();
        Integer maxSize = 5;
        Teacher teacherLast = null;
        for (int i = 0; i < maxSize; i++) {
            String nameStudent = "student " + i;
            String nameTeacher = "teacher " + i;
            Student student = new Student(school,nameStudent);
            Teacher teacher = new Teacher(school,nameTeacher);
            teacherLast = teacher;
        }

        //trường gửi thông báo đí,
        Content content = new Content();
        String message = " chung ta chuan bi tiem vaccine ";
        content.setMessage(message);
        school.setChange(content);

        //có 1 giáo viên gửi trả lời thông báo của trường,
        teacherLast.updateContentSendReplayToSChool();

        // auto tất cả nhận lại được thông báo hủy
    }

}

/**
 * Content class contain message
 */
class Content {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

/**
 * There notification to all staff , student.
 */
class School implements IObserverable<Content> {

    private final List<Obverser<Content>> observerList = new ArrayList<>();

    @Override
    public List<Obverser<Content>> getListObserver() {
        return Collections.unmodifiableList(observerList);
    }

    @Override
    public void attackObserver(Obverser<Content> observer) {
        this.observerList.add(observer);
    }

    @Override
    public void setChange(Content data) {
        for (Obverser<Content> element : observerList) {
            element.Update(data);
        }
    }

    // logic replay from someone
    public void replayFromSomeOne(PersonReceiveNotification person, Content data) {
        if(person instanceof Teacher){
            data.setMessage(" -- HUY BECAUSE-- " + data.getMessage());
            setChange(data);
        }
    }
}

/**
 * PersonReceiveNotification here receive notification from school
 */
abstract class PersonReceiveNotification implements Obverser<Content> {
    protected School school;

    public PersonReceiveNotification(School school) {
        this.school = school;
    }
}

class Student extends PersonReceiveNotification {

    private String nameStudent;

    // registry receive from school.
    Student(School school, String nameStudent) {
        super(school);
        this.nameStudent = nameStudent;
        school.attackObserver(this);
    }

    // is called where receive notification from school
    @Override
    public void Update(Content data) {
        System.out.println("i'm student " + this.nameStudent + " was received " + data.getMessage());
    }
}

class Teacher extends PersonReceiveNotification {

    private String nameTeacher;

    // registry receive from school.
    Teacher(School school, String nameTeacher) {
        super(school);
        this.nameTeacher = nameTeacher;
        school.attackObserver(this);
    }

    // is called where receive notification from school
    @Override
    public void Update(Content data) {
        System.out.println("i'm teacher " + this.nameTeacher + " was received " + data.getMessage());
    }

    //some logic replay to school
    void updateContentSendReplayToSChool() {
        Content content = new Content();
        String message = this.nameTeacher + " said: i was detect some error ";
        content.setMessage(message);
        // notification to school
        this.school.replayFromSomeOne(this, content);
    }
}