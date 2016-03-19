package com.richodemus.test.couchdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties({"_id", "_rev"})
public class User
{
	@JsonProperty("_id")
	private final String id;

	@JsonProperty("_rev")
	private final String revision;
	private final String name;
	private final int age;
	private final List<String> things;

	public User(String name, int age, String...things)
	{
		this.id = null;
		this.revision = null;
		this.name = name;
		this.age = age;
		this.things = Arrays.asList(things);
	}

	@JsonCreator
	public User(@JsonProperty("_id") String id, @JsonProperty("_rev") String revision, @JsonProperty("name") String name, @JsonProperty("age") int age, @JsonProperty("things") List<String> things)
	{
		this.id = id;
		this.revision = revision;
		this.name = name;
		this.age = age;
		this.things = things;
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}

	public List<String> getThings()
	{
		return things;
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
		sb.append(", things=").append(things);
		sb.append('}');
		return sb.toString();
	}
}
