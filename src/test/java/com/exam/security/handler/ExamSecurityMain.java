package com.exam.security.handler;

import com.exam.security.domain.User;

public class ExamSecurityMain {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Object beanClassObject = new User();
    System.out.format("%s", beanClassObject.getClass().getName());
  }

}
