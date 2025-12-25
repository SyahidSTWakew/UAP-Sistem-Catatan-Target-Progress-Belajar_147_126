package model;

import java.time.LocalDate;

public class StudyTarget {
    private String name;
    private String subject;
    private LocalDate deadline;
    private String status;

    public StudyTarget(String name, String subject, LocalDate deadline, String status) {
        this.name = name;
        this.subject = subject;
        this.deadline = deadline;
        this.status = status;
    }

    public String getName() { return name; }
    public String getSubject() { return subject; }
    public LocalDate getDeadline() { return deadline; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String toCSV() {
        return name + "," + subject + "," + deadline + "," + status;
    }

    public static StudyTarget fromCSV(String line) {
        String[] d = line.split(",");
        return new StudyTarget(d[0], d[1], LocalDate.parse(d[2]), d[3]);
    }
}
