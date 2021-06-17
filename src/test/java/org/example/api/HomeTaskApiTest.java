package org.example.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.example.model.StorePojo;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class HomeTaskApiTest {
    int id = new Random().nextInt(500000);
    @BeforeClass
    public void preparation(){
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")

                .addHeader("api-key","pass")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    @Test
    public void createStoreTest(){
        StorePojo storePojo  = new StorePojo();

        int petId = new Random().nextInt(500000);
        storePojo.setId(id);
        storePojo.setPetId(petId);
        storePojo.setQuantity(1);
        storePojo.setShipDate("2021-06-16T10:42:30.968Z");
        storePojo.setStatus("placed");
        storePojo.setComplete(true);
        given().body(storePojo).when().post("/store/order")
                .then() .statusCode(200);

        StorePojo storePojoNew = given().pathParam("orderId", id).when().get("/store/order/{orderId}").then()
                .statusCode(200)
                .extract().body()
                .as(StorePojo.class);

        Assert.assertEquals(storePojoNew.getId(), storePojo.getId());
    }

    @Test
    public void getTest(){
        given()
                .pathParam("orderId",id)
                .when()
                .delete("/store/order/{orderId}")
                .then();

        StorePojo storePojoNew = given().pathParam("orderId", id).when().get("/store/order/{orderId}").then()
                .statusCode(404).extract().body().as(StorePojo.class);
    }
}
