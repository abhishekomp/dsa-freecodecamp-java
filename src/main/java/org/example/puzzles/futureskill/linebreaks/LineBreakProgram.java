package org.example.puzzles.futureskill.linebreaks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
In Level 1 your task is to take an input text and line break it so that it is has at most 'width' characters in a single line, and for each line you should come as close to the input parameter 'width' as possible. You may only break the input string 'text' where there is a space, and to break a line you should replace this space with a '\n' character in the return string. If a single word is longer than 'width', return it as a single line anyway.

For example, given the input 'text' "All work and no play makes Jack a dull boy." and the 'width' 12 you should return:

All work and
no play
makes Jack a
dull boy.
Another way to write this as a string variable is:

"All work and\nno play\nmakes Jack a\ndull boy."
Good luck!
 */
public class LineBreakProgram {

    public String lineBreakResult(String text, int width){
        String[] split = text.split("\\s+");
        List<String> lineChunks = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < split.length; i++) {
            if(i == 0 && split[i].length() >= width){
                lineChunks.add(split[i]);
                continue;
            }
            if(sb.toString().length() + split[i].length() + 1 > width){
                lineChunks.add(sb.toString());
                sb.setLength(0);
                sb.append(split[i]);
            } else {
                if(sb.toString().isEmpty()){
                    sb.append(split[i]);
                } else {
                    sb.append(" ").append(split[i]);
                }
                //lineChunks.add(sb.toString());
                if(i== split.length-1){
                    lineChunks.add(sb.toString().trim());
                }
            }

        }
        return String.join("\n", lineChunks);
    }

    public static void main(String[] args) {
        String input = "All work and no play makes Jack a dull boy";
        LineBreakProgram lineBreakProgram = new LineBreakProgram();
        System.out.println(lineBreakProgram.lineBreakResult(input, 12));
    }

}
