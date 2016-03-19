package com.richodemus.test.couchdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"_id", "_rev"})
public class User
{
	@JsonProperty("_id")
	private String id;

	@JsonProperty("_rev")
	private String revision;
	private String name;
	private int age;

	public User(String name, int age)
	{
		this.id = null;
		this.name = name;
		this.age = age;
	}

	public User(String id, String name, int age)
	{
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}
}
