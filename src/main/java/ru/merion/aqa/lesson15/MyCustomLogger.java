package ru.merion.aqa.lesson15;

import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class MyCustomLogger implements HttpLoggingInterceptor.Logger {
    @Override
    public void log(@NotNull String s){
        //Files.writeString(Path.of("log.log"), s);
        System.out.println(LocalDateTime.now() + "  " + s);
    }

}
