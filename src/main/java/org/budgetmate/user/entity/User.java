package org.budgetmate.user.entity;


import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가
    private Long userId;  // PK

    @Column(nullable = false, length = 45, name = "user_name")
    private String userName;  // 별명

    @Column(nullable = false, length = 255)
    private String password;  // 비밀번호

    @Column(length = 100)
    private String email;  // 이메일

    @Column(nullable = false, name = "last_week")
    private int lastWeek = 0;  // 지난주 지출 비용 합계

    @Column(nullable = false, name = "current_week")
    private int currentWeek = 0;  // 이번 주 지출 비용 합계

    @Column(nullable = false)
    private int point = 0;  // 성공 횟수

    // 기본 생성자, getter, setter, toString 등 추가
    public User() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLastWeek() {
        return lastWeek;
    }

    public void setLastWeek(int lastWeek) {
        this.lastWeek = lastWeek;
    }

    public int getCurrentWeek() {
        return currentWeek;
    }

    public void setCurrentWeek(int currentWeek) {
        this.currentWeek = currentWeek;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", lastWeek=" + lastWeek +
                ", currentWeek=" + currentWeek +
                ", point=" + point +
                '}';
    }
    
    /*@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Receipt> receipts;*/

}

