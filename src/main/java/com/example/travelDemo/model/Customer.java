package com.example.travelDemo.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Customer")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
	@Id
	private int id;
	private String custName;
	private String custEmployer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmployer() {
		return custEmployer;
	}

	public void setCustEmployer(String custEmployer) {
		this.custEmployer = custEmployer;
	}



}
