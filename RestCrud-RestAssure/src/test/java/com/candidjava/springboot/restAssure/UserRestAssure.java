package com.candidjava.springboot.restAssure;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import com.candidjava.springboot.entity.User;
import com.candidjava.springboot.stub.UserAssertValues;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import org.junit.runners.MethodSorters;
import static org.hamcrest.MatcherAssert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRestAssure {

	private static ObjectMapper mapper = new ObjectMapper();
	User user;

	@Before
	public void setup() throws JsonMappingException, JsonProcessingException, IOException {
		RestAssured.baseURI = "http://localhost:8082";
		user = getUser("src\\test\\java\\files\\candidUser.json");
	}

	public User getUser(String path) throws JsonParseException, JsonMappingException, IOException {
		File json = new File(path);
		User user = mapper.readValue(json, User.class);
		return user;
	}

	@Test
	public void a_createUser() throws JsonMappingException, JsonProcessingException, IOException {
		Response response = given()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(user)
				.when()
				.post("/user/createUser")
				.then()
				.contentType(ContentType.JSON)
				.extract()
				.response();

		try {
			if (response.getStatusCode() != 200) {
				throw new AssertionError(response.getBody().asString());
			}
			if (user != null) {
				Gson gson = new Gson();
				User actual = gson.fromJson(response.asString(), User.class);
				assertThat(actual, UserAssertValues.isSameSide(user));
			}
		} catch (AssertionError e) {
			throw new AssertionError(e);
		}
	}

	@Test
	public void b_getUserById() throws JsonMappingException, JsonProcessingException, IOException {
		Response response = 
				given()
				.pathParam("id", user.getId())
				. when()
				.get("/user/getUserById/{id}")
				.then()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.extract()
				.response();

		try {
			if (response.getStatusCode() != 200) {
				throw new AssertionError(response.getBody().asString());
			}
			if (user != null) {
				Gson gson = new Gson();
				User actual = gson.fromJson(response.asString(), User.class);
				assertThat(actual, UserAssertValues.isSameSide(user));
			}
		} catch (AssertionError e) {
			throw new AssertionError(e);
		}
	}

	@Test
	public void c_updateUser() throws JsonMappingException, JsonProcessingException, IOException {
		Response response = given()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(user)
				.when()
				.put("/user/updateUser/1010101")
				.then()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.extract()
				.response();

		try {
			if (response.getStatusCode() != 200) {
				throw new AssertionError(response.getBody().asString());
			}
			if (user != null) {
				Gson gson = new Gson();
				User actual = gson.fromJson(response.asString(), User.class);
				assertThat(actual, UserAssertValues.isSameSide(user));
			}
		} catch (AssertionError e) {
			throw new AssertionError(e);
		}
	}

	@Test
	public void d_deleteUserById() throws JsonMappingException, JsonProcessingException, IOException {
		Response response = given().when().delete("/user/deleteUser/1010101").then().statusCode(200).extract().response();
		if (response.getStatusCode() != 200) {
			throw new AssertionError(response.getBody().asString());
		}
	}
	
	@Test
	public void e_getUsers() throws JsonMappingException, JsonProcessingException, IOException {
		Response response = given().when().get("/user").then().statusCode(200).contentType(ContentType.JSON).extract()
				.response();
		try {
			assertEquals("[]", response.asString());
		} catch (AssertionError e) {
			throw new AssertionError(e);
		}
	}

}
