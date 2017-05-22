package com._520it.crm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
//@AllArgsConstructor
public class Supplier {
	
	// id
	private Long id;
	
	//供应商编号
	private String number;
	
	public Supplier(Long id, String number, String name, Integer credit, String city) {
        super();
        this.id = id;
        this.number = number;
        this.name = name;
        this.credit = credit;
        this.city = city;
    }

    //供应商名称
	private String name;
	
	// 信誉度， 0 -100 
	private Integer credit;
	
	//所在城市
	private String city;
	

}
