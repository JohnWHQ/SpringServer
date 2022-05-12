package com.web.repository;

import javax.persistence.*;

/**
 * ORM RDBMS表映射示例
 */

@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 256, name = "user_id")
    String userId;

    @Column(length = 256, name = "nick_name")
    String nickName;

    @Column(name = "gender")
    Integer gender;

    @Column(length = 128, name = "country")
    String country;

    @Column(length = 128, name = "province")
    String province;

    @Column(length = 128, name = "city")
    String city;

    @Column(name = "phone_number")
    Long phoneNumber;

    @Column(length = 128, name = "language")
    String language;

    @Column(columnDefinition = "TEXT", name = "avatar_url")
    String avatarUrl;

    @Column(name = "register_time")
    Long registerTime;

    @Column(name = "update_time")
    Long updateTime;

    @Column(name = "register_type")
    String registerType;

    public UserInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", language='" + language + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", registerTime=" + registerTime +
                ", updateTime=" + updateTime +
                ", registerType='" + registerType + '\'' +
                '}';
    }
}
