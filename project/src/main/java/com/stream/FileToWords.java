package com.stream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileToWords {
    public static void main(String[] args) throws Exception{
        Files.lines(Paths.get("D:\\work_speace_idea\\play\\study\\project\\src\\main\\resources\\file\\test1"))
                .flatMap(line -> Arrays.stream(line.split("\\W+")))
                .forEach(System.out::println);
    }
}
