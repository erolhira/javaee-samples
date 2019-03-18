package com.jtudy.jee7.jsonp;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;

import org.junit.Test;

/*
 * https://jcp.org/en/jsr/detail?id=353
 */
public class JsonPApplication {

	@Test
	public void jsonReader() {

		StringReader sr = new StringReader(
				"{\"name\": \"erol\", \"surname\": \"hira\", \"children\": [\"zeynep\", \"ayca\"]}");
		JsonReader reader = Json.createReader(sr);
		JsonObject root = reader.readObject();
		sr.close();

		System.out.println("name: " + root.getString("name"));
		System.out.println("surname: " + root.getString("surname"));

		System.out.println("children: ");
		JsonArray children = root.getJsonArray("children");
		for (JsonValue child : children) {
			System.out.println(child);
		}
	}

	@Test
	public void jsonWriter() {				
		
		JsonArrayBuilder childBuilder = Json.createArrayBuilder();		
		childBuilder.add("zeynep");
		childBuilder.add("ayca");
		
		JsonObjectBuilder fatherBuilder = Json.createObjectBuilder();
		fatherBuilder.add("name", "erol");
		fatherBuilder.add("surname", "hira");
		fatherBuilder.add("children", childBuilder);
		
		JsonObject root = fatherBuilder.build();
		System.out.println("json --> " + root);
	}
}
