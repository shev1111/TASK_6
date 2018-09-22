package com.shev.long_multiplication;

public class MainTask6 {
    public static void main(String[] args) {
        long xMax = 1234;
        long yMin = 123;
        long result = xMax*yMin;


        //get length of x
        int lengthOfX = String.valueOf(xMax).length();
        //get length of y
        int lengthOfY = String.valueOf(yMin).length();
        //get length of result
        int lengthOfResult = String.valueOf(result).length();

        //get count of Y spaces
        StringBuilder spacesY = new StringBuilder("");
        for (int cursor=0;cursor<lengthOfResult-lengthOfY;cursor++){
            spacesY.append(" ");
        }
        //get count of X spaces
        StringBuilder spacesX = new StringBuilder("");
        for (int cursor=0;cursor<lengthOfResult-lengthOfX;cursor++){
            spacesX.append(" ");
        }
        //get count of lines
        StringBuilder line = new StringBuilder("");
        for (int cursor=0;cursor<lengthOfResult;cursor++){
            line.append("-");
        }

        System.out.print(spacesX.toString()+xMax+"\n");
        System.out.print(spacesY.toString()+yMin+"\n");
        System.out.print(line+"\n");

        //multiplication result formatter
        int multiplicationResultSpaceCounter = lengthOfResult;
        for (int cursor=lengthOfY-1;cursor>=0;cursor--){
            long multiplicationResult = xMax* Character.getNumericValue(String.valueOf(yMin).charAt(cursor));
            int multiplicationResultLength = String.valueOf(multiplicationResult).length();

            StringBuilder multiplicationResultSpace = new StringBuilder("");
            for (int index=0;index<multiplicationResultSpaceCounter-multiplicationResultLength;index++){
                    multiplicationResultSpace.append(" ");
            }

            System.out.println(multiplicationResultSpace.toString()+multiplicationResult);
            multiplicationResultSpaceCounter--;
        }
        System.out.println(line);
        System.out.println(result);
    }
}
