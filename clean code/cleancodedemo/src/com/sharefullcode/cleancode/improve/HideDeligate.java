package com.sharefullcode.cleancode.improve;

public class HideDeligate {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setName("teacher lucy");

        ClassRoom room = new ClassRoom();
        room.setName("101");
        room.setMainTecher(teacher);

        Student student = new Student();
        student.setName("John");
        student.setRoom(room);

        // how to get teach of student John

        //bad
        ClassRoom roomRetrieve = student.getRoom();
        roomRetrieve.getMainTecher();

        //Good create function in student to get teacher main
        student.getTecherMain();
    }

}

class Student {
    private String name;
    private ClassRoom room;

    public void setName(String name) {
        this.name = name;
    }

    public void setRoom(ClassRoom room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public ClassRoom getRoom() {
        return room;
    }

    Teacher getTecherMain(){
        return this.getRoom().getMainTecher();
    }
}

class Teacher {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ClassRoom {
    private String name;
    private Teacher mainTecher;

    public String getName() {
        return name;
    }

    public Teacher getMainTecher() {
        return mainTecher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMainTecher(Teacher mainTecher) {
        this.mainTecher = mainTecher;
    }
}