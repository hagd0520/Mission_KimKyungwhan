package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void run(){
        Scanner sc = new Scanner(System.in);
        List<Quote> quotes = new ArrayList<>();

        // 1 단계
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령)");
            String cmd = sc.nextLine();
            Rq rq = new Rq(cmd, 0);

            if (rq.cmd.equals("종료")) break;
        }
    }
}

class Quote {
    private int id;
    private String content;
    private String author;
    private int idQueue = 1;
    public Quote(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
        idQueue++;
    }
}

class Rq {
    String cmd;
    String content;
    String id;
    public Rq(String cmd, int defaultNum) {
        String[] cmds = cmd.split("\\?");
        if (cmds.length == 1) this.cmd = cmds[0];
        if (cmds.length > 1) {
            this.cmd = cmds[0].trim();
            if (cmds.length > 1) {
                String[] contents = cmds[1].split("=");
                content = contents[0].trim();
                id = contents[1].trim();
            }
        }
    }
}