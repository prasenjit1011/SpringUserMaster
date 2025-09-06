package com.example.m_paridarshan.dto;

public class DistributorDTO {
    private Long id;
    private String name;
    private String emailid;
    private String profilePhotoUrl;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmailid() { return emailid; }
    public void setEmailid(String emailid) { this.emailid = emailid; }
    public String getProfilePhotoUrl() { return profilePhotoUrl; }
    public void setProfilePhotoUrl(String profilePhotoUrl) { this.profilePhotoUrl = profilePhotoUrl; }
}
