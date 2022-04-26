package com.week1.q2;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class CustomClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Object obj = new CustomClassLoader().findClass("Hello").getDeclaredConstructor().newInstance();
            Method method = obj.getClass().getMethod("hello");
            method.invoke(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] bytes;
        try {
            bytes = readBytes("Hello.xlass");
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

    public byte[] readBytes(String fileName) throws IOException, URISyntaxException {
        Path path = Paths.get(Objects.requireNonNull(this.getClass().getClassLoader().getResource(fileName)).toURI());
        byte[] data = Files.readAllBytes(path);
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (255 - data[i]);
        }
        return data;
    }
}
