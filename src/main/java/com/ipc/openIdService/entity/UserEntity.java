package com.ipc.openIdService.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GenericGenerator(name = "sequence_user_id", strategy = "com.ipc.openIdService.util.UserIdGenerator")
    @GeneratedValue(generator = "sequence_user_id")
    @Column(name = "userid")
    private String userId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "nicnr")
    private String nicNr;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "institutebranch")
    private String instituteBranch;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "usertype")
    private String userType;

    @Column(name = "password")
    private String password;

    @Column(name = "loginstatus")
    private byte loginStatus;

    @Column(name = "useraccounttype")
    private String userAccountType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userid) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNicNr() {
        return nicNr;
    }

    public void setNicNr(String nicNr) {
        this.nicNr = nicNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getInstituteBranch() {
        return instituteBranch;
    }

    public void setInstituteBranch(String instituteBranch) {
        this.instituteBranch = instituteBranch;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public byte getLoginstatus() {
        return loginStatus;
    }

    public void setLoginStatus(byte loginStatus) {
        this.loginStatus = loginStatus;
    }


    public String getUserAccountType() {
        return userAccountType;
    }

    public void setUserAccountType(String userAccountType) {
        this.userAccountType = userAccountType;
    }
}
