package com.richodemus.test.couchdb;

import com.google.common.collect.ImmutableMap;
import com.google.common.io.ByteStreams;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;

import java.io.IOException;
import java.io.InputStream;

public class Main
{

	public static final String NAME = "richo";

	public static void main(String[] args) throws Exception
	{
		System.out.println("Doing stuff");

		final HttpClient httpClient = new StdHttpClient.Builder()
				.url("http://localhost:5984")
				.build();

		final CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
		final CouchDbConnector db = new StdCouchDbConnector("java-db", dbInstance);

		db.createDatabaseIfNotExists();


		db.getAllDocIds().forEach(id ->
				db.delete(id, db.getCurrentRevision(id)));

		final UserRepository repo = new UserRepository(db);


		final User richo = new User(NAME, 29, ImmutableMap.of("key1", "val1", "key 2", "value 2"), "pens", "islands", "kittens");
		repo.add(richo);

		repo.getAll().forEach(System.out::println);


		System.out.println("Using view:");
		repo.findByName(NAME).forEach(System.out::println);


		System.out.println("Printing all ids:");
		db.getAllDocIds().forEach(System.out::println);

		System.out.println("All raw:");
		db.getAllDocIds()
				.stream()
				.map(db::getAsStream)
				.map(Main::toByteArray)
				.map(String::new)
				.findAny()
				.ifPresent(System.out::println);

		System.out.println("Done");
	}

	private static byte[] toByteArray(InputStream in)
	{
		try
		{
			return ByteStreams.toByteArray(in);
		}
		catch (IOException e)
		{
			throw new RuntimeException("byte thing fail", e);
		}
	}
}
