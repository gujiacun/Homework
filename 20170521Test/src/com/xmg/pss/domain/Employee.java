package com.xmg.pss.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter@Getter@ToString@NoArgsConstructor@AllArgsConstructor
public class Employee {
   private Long id;
   private String username;
   private String  password;
   private String  email;
   private BigDecimal salary;
   private Date hiredate;
   private String headImg;
}
