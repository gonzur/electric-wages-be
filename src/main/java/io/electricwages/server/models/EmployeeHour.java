package io.electricwages.server.models;

import javax.persistence.*;

@Entity
public class EmployeeHour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Employee employee;
    @ManyToOne
    private DailyTimeReport report;

    private double hoursWorked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public DailyTimeReport getReport() {
        return report;
    }

    public void setReport(DailyTimeReport report) {
        this.report = report;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
