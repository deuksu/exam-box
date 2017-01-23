package com.exam.security.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fd_user_role")
public class UserRole {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="role_id")
  private Long roleId;
  @Column(name="user_id")
  private Long userId;
  @Column(name="role")
  private String role;
  public Long getRoleId() {
    return roleId;
  }
  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }
  public Long getUserId() {
    return userId;
  }
  public void setUserId(Long userId) {
    this.userId = userId;
  }
  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }
  @Override
  public String toString() {
    return "UserRole [roleId=" + roleId + ", userId=" + userId + ", role=" + role + "]";
  }
  
}
