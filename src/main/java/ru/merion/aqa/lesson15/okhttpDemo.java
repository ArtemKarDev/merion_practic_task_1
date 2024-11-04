package ru.merion.aqa.lesson15;

import okhttp3.*;

import java.io.IOException;

public class okhttpDemo {
    public static final String URL = "https://todo-app-sky.herokuapp.com";
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request getAllTaskReq = new Request.Builder().url(URL).method("GET",null).build();
        Response response = client.newCall(getAllTaskReq).execute();

        System.out.println(response.code());
        String cookie = response.header("set-cookie");
        System.out.println(cookie);
        MediaType mediaType = response.body().contentType();
        String body = response.body().string();
        System.out.println(body);

        String json = "{\"title\":\"123\",\"completed\":false}";
        RequestBody reqBody = RequestBody.create(json, MediaType.get("application/json"));
        Request createNewTaskRequest = new Request.Builder()
                .url(URL)
                .post(reqBody)
                .build();

        response = client.newCall(createNewTaskRequest).execute();
        System.out.println(response);


    }

}
