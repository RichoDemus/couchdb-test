package com.richodemus.test.couchdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

	@JsonCreator
	public User(@JsonProperty("_id") String id, @JsonProperty("_rev") String revision, @JsonProperty("name") String name, @JsonProperty("age") int age)
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

	@JsonIgnore
	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder("User{");
		sb.append("id='").append(id).append('\'');
		sb.append(", revision='").append(revision).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", age=").append(age);
		sb.append('}');
		return sb.toString();
	}
}
