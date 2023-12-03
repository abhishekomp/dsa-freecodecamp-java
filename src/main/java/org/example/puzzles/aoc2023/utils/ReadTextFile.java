package org.example.puzzles.aoc2023.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadTextFile {
    String filePath;

    public ReadTextFile(String filePath) {
        this.filePath = filePath;
    }

    public ReadTextFile() {
    }

    public List<String> readTextFile() {
        List<String> readLines = new ArrayList<>();
        try (FileReader file = new FileReader(filePath);
             // try (FileReader file = new
             // FileReader("C:\\MyJava\\AdventOfCode2021\\2-Dec\\input.txt");
             BufferedReader fileStream = new BufferedReader(file);) {
            String temp = null;
            while ((temp = fileStream.readLine()) != null) {
                readLines.add(temp);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return readLines;
    }

    public static void main(String[] args) {
        // ReadTextFile readTextFile = new
        // ReadTextFile("C:\\MyJava\\AdventOfCode2021\\2-Dec\\input_example.txt"); //OK
//        ReadTextFile readTextFile = new ReadTextFile("allURLs.txt");
//        List<String> strings = readTextFile.readTextFile();
        ReadTextFile readTextFile = new ReadTextFile();
        //List<String> strings = readTextFile.readTextFileFromResources("Day1Part1Sample.txt");
        List<String> strings = readTextFile.readTextFileFromResources("day1", "Day1Part1Sample.txt");
        System.out.println("Number of lines read: " + strings.size());
        strings.forEach(System.out::println);
    }

    // This method reads a text file and extracts all urls from the file.
    // Each url is separated by pipe. Using it to capture all urls from open tabs in
    // firefox browser
    public List<String> extractURLsSeparatedByPipe() {
        List<String> allURLs = new ArrayList<>();
        try (FileReader file = new FileReader(filePath);
             BufferedReader fileStream = new BufferedReader(file);) {
            String temp = "";
            while ((temp = fileStream.readLine()) != null) {
                String a = temp;
                String[] strings = temp.split("\\|");
                for (String url : strings) {
                    allURLs.add(url);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allURLs;
    }

    /**
     * Get the content of a resource as a string
     *
     * @param fileName the name of the resource if it is located in the
     *                 same package as the calling class. The absolute name if it is
     *                 located
     *                 in another package.
     *                 <p>
     *                 Examples:
     *                 The resource foo.txt is in the same package as
     *                 the calling class, use the name <code>foo.txt</code>
     *                 The resource bar.tst is in a different package
     *                 than the calling class, use the name
     *                 <code>/se/telia/tac/foo/bar.txt</code>
     * @return the content as a List of strings
     */
    public List<String> readTextFileFromResources(String fileName) {
        String concatFileName = "/aoc2023/".concat(fileName);
        try (InputStream is = getClass().getResourceAsStream(concatFileName)) {
            if (is == null) {
                throw new IllegalArgumentException("Failed reading file: " + fileName);
            }
            return new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
                    .lines()
                    .filter(line -> !line.isBlank())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /*
    Reads each line from a text file and returns a list of string with each string being a single line from the file
     */
    public List<String> readTextFileFromResources(String dirName, String fileName) {
        String path = dirName.concat("/").concat(fileName);
        return readTextFileFromResources(path);
    }
}
