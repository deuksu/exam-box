package com.exam.security.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement(name = "user")
@Entity
@Table(name="fd_user")
public class User implements Serializable {
  
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private Long userId;
    @Column(name="user_name")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="enabled")
    private int enabled;
    @Column(name="active")
    private int active;
    @Column(name="provider")
    private String provider;
    @Column(name="social_user_id")
    private Long socialUserId;    

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
/*    @JoinTable(
        name = "fd_user_role",
        joinColumns = @JoinColumn(name="user_id"),
        inverseJoinColumns = @JoinColumn(name="user_id"))*/
    private Collection<UserRole> roles;
    @XmlElement
    public Long getUserId() {
      return userId;
    }
    public void setUserId(Long userId) {
      this.userId = userId;
    }
    @XmlElement
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
    public int getEnabled() {
      return enabled;
    }
    public void setEnabled(int enabled) {
      this.enabled = enabled;
    }
    
    public Collection<UserRole> getRoles() {
      return roles;
    }

    public void setRoles(Collection<UserRole> roles) {
      this.roles = roles;
    }

    public int getActive() {
      return active;
    }
    public void setActive(int active) {
      this.active = active;
    }
    public String getProvider() {
      return provider;
    }
    public void setProvider(String provider) {
      this.provider = provider;
    }
    
    public Long getSocialUserId() {
      return socialUserId;
    }
    public void setSocialUserId(Long socialUserId) {
      this.socialUserId = socialUserId;
    }
    
    @JsonIgnore
    @Override
    public String toString() {
      return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
          + ", enabled=" + enabled + ", active=" + active + ", provider=" + provider + ", socialUserId=" + socialUserId
          + ", roles=" + roles + "]";
    }
}
