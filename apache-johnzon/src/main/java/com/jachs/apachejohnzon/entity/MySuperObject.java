package com.jachs.apachejohnzon.entity;

import org.apache.johnzon.mapper.JohnzonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 
 * @author zhanchaohan
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MySuperObject {
	private String name;
	private int age;
	
	@JohnzonIgnore
	private String address;
	
	@JohnzonIgnore(minVersion = 3)
	private String t_Address;
}
