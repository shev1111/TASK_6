package com.shev.long_multiplication;

class LongMultiplication {
    private int minValue;
    private int maxValue;
    private long result;
    private int lengthOfMaxValue;
    private int lengthOfMinValue;
    private int lengthOfResult;
    //private long[] multiplicationResults;

   LongMultiplication(int value_1, int value_2) {
        if(value_1>value_2){
            this.maxValue = value_1;
            this.minValue = value_2;
        }else {
            this.maxValue = value_2;
            this.minValue = value_1;
        }
        this.result = maxValue*minValue;
        this.lengthOfMaxValue = String.valueOf(this.maxValue).length();
        this.lengthOfMinValue = String.valueOf(this.minValue).length();
        this.lengthOfResult = String.valueOf(this.result).length();
        //multiplicationResults = new long[this.lengthOfMinValue];
        getMultiplicationResults();
    }

    private long returnPositiveDigit(long number){
       if(number<0){
           return number*-1;

       }
       return number;
    }

    private String getMinValueSpaces(){
        StringBuilder spaces = new StringBuilder("");
        if(minValue==0){
            for (int cursor=1;cursor<lengthOfMaxValue;cursor++){
                spaces.append(" ");
            }
        }
        else {
            for (int cursor=0;cursor<lengthOfResult-lengthOfMinValue;cursor++){
                spaces.append(" ");
            }
        }
        return spaces.toString();
    }

    private String getMaxValueSpaces(){
        StringBuilder spaces = new StringBuilder("");
        if(maxValue<0){
            for (int cursor=-1;cursor<lengthOfResult-lengthOfMaxValue;cursor++){
                spaces.append(" ");
            }
        }
        if(maxValue==0){
            for (int cursor=1;cursor<lengthOfMinValue;cursor++){
                spaces.append(" ");
            }
        }
        if(maxValue>0){
            for (int cursor=0;cursor<lengthOfResult-lengthOfMaxValue;cursor++){
                spaces.append(" ");
            }
        }
        return spaces.toString();
    }

    private String getResultSpaces(){
        StringBuilder spaces = new StringBuilder("");
        if(lengthOfMinValue>lengthOfResult&&result!=0){
            for (int cursor=0;cursor<lengthOfMinValue-lengthOfResult;cursor++){
                spaces.append(" ");
            }
        }
        return spaces.toString();
    }

    private String getLine(){
        StringBuilder line = new StringBuilder("");
        if(result==0&&lengthOfMaxValue>lengthOfMinValue){
            for (int cursor=1;cursor<lengthOfMaxValue;cursor++){
                line.append("-");
            }

        }
        if(result==0&&lengthOfMaxValue<lengthOfMinValue){
            for (int cursor=1;cursor<lengthOfMinValue;cursor++){
                line.append("-");
            }
        }
        if(lengthOfResult<lengthOfMinValue&&maxValue!=0){
           /* for (int cursor=0;cursor<lengthOfMinValue;cursor++){
                line.append("-");
            }*/
        }
        else{
            for (int cursor=0;cursor<lengthOfResult;cursor++){
                line.append("-");
            }
        }
        return line.toString();
    }

    public long[] getMultiplicationResults(){
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

    private String getMultiplicationResultSpaces(int index, long partResult){
        StringBuilder spaces =new StringBuilder("");
        if(result<0){
            int partResultLength = String.valueOf(partResult).length()-1;
            for (int cursor=index;cursor<lengthOfResult-partResultLength;cursor++){
                spaces.append("-");
            }
        }
        else {
            int partResultLength = String.valueOf(partResult).length();
            for (int cursor=index;cursor<lengthOfResult-partResultLength;cursor++){
                spaces.append(" ");
            }
        }

        return spaces.toString();
    }

    private String getPartMultiplicationFormat(){
        StringBuilder multiplicationBuilder =new StringBuilder("");
        if(minValue<0){
            for (int cursor=0;cursor<lengthOfMinValue-1;cursor++){
                long multiplicationResult = returnPositiveDigit(getMultiplicationResults()[cursor]);
                String spaces = " "+getMultiplicationResultSpaces(cursor,multiplicationResult);
                String stringResult = spaces+multiplicationResult+"\n";
                multiplicationBuilder.append(stringResult);
            }
        }else {
            for (int cursor=0;cursor<lengthOfMinValue;cursor++){
                String spaces = getMultiplicationResultSpaces(cursor,getMultiplicationResults()[cursor]);
                String stringResult = spaces+getMultiplicationResults()[cursor]+"\n";
                multiplicationBuilder.append(stringResult);
            }
        }

        return multiplicationBuilder.toString();
    }

    void print(){
        //if(maxValue==1|minValue==1|maxValue==0|minValue==0|maxValue==-1|minValue==-1){
        if(maxValue<=9&maxValue>=-9&minValue<=9&minValue>=-9){
            System.out.print(getMaxValueSpaces()+maxValue+"\n");
            System.out.print(getMinValueSpaces()+minValue+"\n");
            System.out.print(getLine()+"\n");
            System.out.print(getResultSpaces()+result);
        }else {
            System.out.print(getMaxValueSpaces()+maxValue+"\n");
            System.out.print(getMinValueSpaces()+minValue+"\n");
            System.out.print(getLine()+"\n");
            System.out.print(getPartMultiplicationFormat());
            System.out.print(getLine()+"\n");
            System.out.print(getResultSpaces()+result);
        }
    }
}
