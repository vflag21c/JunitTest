package org.example.junittest;

public class Study {

    private StudyStatus status = StudyStatus.DRAFT;


    private int limit;
    private String name;


    public Study(){

    }

    public Study(int limit, String name) {
        this.limit = limit;
        this.name = name;
    }

    public StudyStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Study{" +
                "status=" + status +
                ", limit=" + limit +
                ", name='" + name + '\'' +
                '}';
    }
}
