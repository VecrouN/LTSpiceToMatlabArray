package com.vecroun;

import java.io.BufferedReader;
import java.io.File;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            LinkedList<String> fileList = new LinkedList<>();
            String line = reader.readLine();
            while (line != null) {
                fileList.addLast(line);
                //System.out.println(line);
                line = reader.readLine();
            }
            LinkedList<String> Uphase = new LinkedList<>();
            LinkedList<String> Uamplitude = new LinkedList<>();
            Stack<String> Iphase = new Stack<>();
            Stack<String> Iamplitude = new Stack<>();
            StringTokenizer st;
            String tmpString;
            while (fileList.peekFirst() != null) {
                st = new StringTokenizer(fileList.pollFirst());
                if (st.nextToken().charAt(0) == 'V') {
                    tmpString = st.nextToken();
                    tmpString = st.nextToken();
                    //System.out.print(tmpString + '\t');
                    Uamplitude.addLast(tmpString);

                    tmpString = st.nextToken();
                    tmpString = st.nextToken();
                    //System.out.println(tmpString.substring(0, tmpString.length() - 1));
                    Uphase.addLast(tmpString.substring(0, tmpString.length() - 1));


                } else {
                    tmpString = st.nextToken();
                    tmpString = st.nextToken();
                    //System.out.print(tmpString + '\t');
                    Iamplitude.push(tmpString);

                    tmpString = st.nextToken();
                    tmpString = st.nextToken();
                    //System.out.println(tmpString.substring(0, tmpString.length() - 1));
                    Iphase.push(tmpString.substring(0, tmpString.length() - 1));

                }
            }
            System.out.print("Iamplitude = \n[");
            while (!Iamplitude.isEmpty()) {
                System.out.print(Iamplitude.pop() + ", ");
            }
            System.out.println("\b\b]");
            System.out.print("Iphase = \n[");
            while (!Iphase.isEmpty()) {
                System.out.print(Iphase.pop() + ", ");
            }
            System.out.println("\b\b]");

            System.out.print("Uamplitude = \n[");
            while (!Uamplitude.isEmpty()) {
                System.out.print(Uamplitude.pollFirst() + ", ");
            }
            System.out.println("\b\b]");
            System.out.print("Uphase = \n[");
            while (!Uphase.isEmpty()) {
                System.out.print(Uphase.pollFirst() + ", ");
            }
            System.out.println("\b\b]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
