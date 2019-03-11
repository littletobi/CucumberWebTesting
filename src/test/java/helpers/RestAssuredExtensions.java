package helpers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtensions {

    public static RequestSpecification Request;

    public RestAssuredExtensions(String baseUri) {
        //Arrange
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(baseUri);
        builder.setContentType(ContentType.JSON);
        Request = RestAssured.given().spec(builder.build());
    }

    public static ResponseOptions<Response> GetOpsWithPathParameter(String url, Map<String, String> pathParams) {//wczesniej void
        //Act
        Request.pathParams(pathParams);
        return Request.get(url);
    }

    public static void GetOpsWithQueryParameter(String url, String queryParams) {
        //Act
        Request.queryParam(queryParams);
        try {
            Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static ResponseOptions<Response> GetOps(String url) {
        //Act
        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> GetOpsWithToken(String url, String token) {
        //Act
        try {
            Request.header(new Header("Authorization", "Bearer " + token));
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> PostOpsWithBodyAndPathParams(String url, Map<String, String> pathParams, Map<String, String> bodyParams) {
        Request.pathParams(pathParams);
        Request.body(bodyParams);
        return Request.post(url); //Zamiast new URI uzywam String zeby obejs problem Illegal character in path czyli klamerki {}
    }

    public static ResponseOptions<Response> DeleteOpsWithPathParams(String url, Map<String, String> pathParams) {
        Request.pathParams(pathParams);
        return Request.delete(url);
    }
}
