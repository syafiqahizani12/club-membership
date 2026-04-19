/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lab.model;

/**
 *
 * @author user
 */
public class Membership {
    private int membershipId;
    private String studentName;
    private String planType;
    private String status;
    private String expiryDate;

    public Membership() {}

    public Membership(int membershipId, String studentName, String planType, String status, String expiryDate) {
        this.membershipId = membershipId;
        this.studentName = studentName;
        this.planType = planType;
        this.status = status;
        this.expiryDate = expiryDate;
    }

    public int getMembershipId() { return membershipId; }
    public void setMembershipId(int membershipId) { this.membershipId = membershipId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getPlanType() { return planType; }
    public void setPlanType(String planType) { this.planType = planType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
}