package com.shev.long_multiplication;

class LongMultiplication {
    private int minValue;
    private int maxValue;
    private long result;
    private int lengthOfMaxValue;
    private int lengthOfMinValue;
    private int lengthOfResult;
    private int biggestLength;
    private String minValueSpace;
    private String maxValueSpace;
    private String resultSpace;

   LongMultiplication(int value_1, int value_2) {
        if(value_1>value_2){
            maxValue = value_1;
            minValue = value_2;
        }else {
            maxValue = value_2;
            minValue = value_1;
        }
        result = maxValue*minValue;
        lengthOfMaxValue = String.valueOf(maxValue).length();
        lengthOfMinValue = String.valueOf(minValue).length();
        lengthOfResult = String.valueOf(result).length();
        getBiggestLengthWithAllSpaces();
        getMultiplicationResults();
    }

    private void getBiggestLengthWithAllSpaces() {
       if(lengthOfMaxValue>lengthOfMinValue&&lengthOfMaxValue>lengthOfResult|lengthOfResult==lengthOfMaxValue){
           biggestLength=lengthOfMaxValue;
           maxValueSpace = "";
           minValueSpace = getSpace(lengthOfMaxValue-lengthOfMinValue);
           resultSpace = getSpace(lengthOfMaxValue-lengthOfResult);
       }
       if(lengthOfMaxValue>lengthOfMinValue&&lengthOfMaxValue<lengthOfResult){
           biggestLength=lengthOfResult;
           maxValueSpace = getSpace(lengthOfResult-lengthOfMaxValue);
           minValueSpace = getSpace(lengthOfResult-lengthOfMinValue);
           resultSpace = "";
       }
       if(lengthOfMinValue>lengthOfMaxValue&&lengthOfMinValue>lengthOfResult|lengthOfResult==lengthOfMinValue){
           biggestLength=lengthOfMinValue;
           maxValueSpace = getSpace(lengthOfMinValue-lengthOfMaxValue);
           minValueSpace = "";
           resultSpace = getSpace(lengthOfMinValue-lengthOfResult);
       }
       if(lengthOfMinValue>lengthOfMaxValue&&lengthOfMinValue<lengthOfResult){
           biggestLength=lengthOfResult;
           maxValueSpace = getSpace(lengthOfResult-lengthOfMaxValue);
           minValueSpace = getSpace(lengthOfResult-lengthOfMinValue);
           resultSpace = "";
        }
        if(lengthOfMinValue==lengthOfMaxValue&&lengthOfResult>lengthOfMinValue){
            biggestLength=lengthOfResult;
            maxValueSpace = getSpace(lengthOfResult-lengthOfMaxValue);
            minValueSpace = getSpace(lengthOfResult-lengthOfMinValue);
            resultSpace = "";
        }
        if(lengthOfMinValue==lengthOfMaxValue&&lengthOfMaxValue==lengthOfResult){
           biggestLength=lengthOfResult;
           maxValueSpace = "";
           minValueSpace = "";
           resultSpace = "";
        }

    }

    private String getSpace(int index){
       StringBuilder spaces = new StringBuilder("");
        for (int cursor=1;cursor<=index;cursor++){
            spaces.append(" ");
        }
       return spaces.toString();
    }

    private long returnPositiveDigit(long number){
       if(number<0){
           return number*-1;

       }
       return number;
    }

    private String getLine(){
        StringBuilder line = new StringBuilder("");
        if(biggestLength==1){
            line.append("-");
        }else {
            for (int cursor=0;cursor<biggestLength;cursor++){
                line.append("-");
            }
        }
        return line.toString();
    }

    private long[] getMultiplicationResults(){
        long[] multiplicationResults;
        if(minValue<0){
            multiplicationResults = new long[lengthOfMinValue-1];
            int positiveMinValue = minValue*-1;
            for (int cursor=multiplicationResults.length-1;cursor>=0;cursor--){
                long multiplicationResult = maxValue* Character.getNumericValue(String.valueOf(positiveMinValue).charAt(cursor));
                multiplicationResults[multiplicationResults.length-cursor-1] = multiplicationResult;

            }
            return multiplicationResults;
        }else {
            multiplicationResults = new long[lengthOfMinValue];
            for (int cursor=lengthOfMinValue-1;cursor>=0;cursor--){
                long multiplicationResult = maxValue* Character.getNumericValue(String.valueOf(minValue).charAt(cursor));
                multiplicationResults[lengthOfMinValue-cursor-1] = multiplicationResult;
            }
            return multiplicationResults;
        }


    }

    private String getPartMultiplicationFormat(){
        StringBuilder multiplicationBuilder =new StringBuilder("");
        int spaceIndicator = biggestLength;
        for (int cursor=0;cursor<lengthOfMinValue-1;cursor++) {
            buildMultiplicationPartResults(multiplicationBuilder, spaceIndicator, getMultiplicationResults()[cursor]);
            spaceIndicator--;
        }
        return multiplicationBuilder.toString();
    }

    private void buildMultiplicationPartResults(StringBuilder multiplicationBuilder, int spaceIndicator, long number) {
        long multiplicationResult = returnPositiveDigit(number);

        String spaces = getSpace(spaceIndicator-String.valueOf(multiplicationResult).length());
        String stringResult = spaces + multiplicationResult + "\n";
        multiplicationBuilder.append(stringResult);
    }

    void print(){
        //if(maxValue==1|minValue==1|maxValue==0|minValue==0|maxValue==-1|minValue==-1){
        /*if(maxValue<=9|maxValue>=-9|minValue<=9|minValue>=-9){
            System.out.print(maxValueSpace+maxValue+"\n");
            System.out.print(minValueSpace+minValue+"\n");
            System.out.print(getLine()+"\n");
            System.out.print(resultSpace+result);*//*
        }else {*/
            System.out.print(maxValueSpace+maxValue+"\n");
            System.out.print(minValueSpace+minValue+"\n");
            System.out.print(getLine()+"\n");
            System.out.print(getPartMultiplicationFormat());
            System.out.print(getLine()+"\n");
            System.out.print(resultSpace+result);

    }

}
