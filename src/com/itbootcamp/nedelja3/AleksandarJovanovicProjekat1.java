package com.itbootcamp.nedelja3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AleksandarJovanovicProjekat1 {
    public static void main(String[] args) {
        System.out.println(zbirCifara(2356));
        System.out.println(stepenBroja(27, 3));
        System.out.println(Arrays.toString(zbirIndexaNizaMeta(new int[] {1,2,3,4,5,6,7}, 5)));
        System.out.println(toBinary(16));
        System.out.println(brojPonavljanja("cao", "Cao, ja sam Aleksandar, caocao cao pozdrav."));
        System.out.println(Arrays.toString(pomeriNule(new int[] {1,0,3,4,5,0,0,4,3,0,9})));
        System.out.println(Arrays.toString(izbaciDuplikate(new int[] {1,2,3,4,5,6,4,3,2})));
        System.out.println(validatePhone("343-323-4568"));
        System.out.println(Arrays.deepToString(powerSet(new int[]{1,2,3})));
    }
    public static int[] unosNizaInt() {
        Scanner skener = new Scanner(System.in);
        System.out.print("Unesite duzinu niza: ");
        int lengthOfFirstArray = skener.nextInt();
        int[] firstArray = new int[lengthOfFirstArray];
        for (int i = 0; i < lengthOfFirstArray; i++) {
            System.out.print("Unesite " + (i+1) + ". element niza: ");
            firstArray[i] = skener.nextInt();
        }
        return firstArray;
    }
    public static String[] unosNizaString (){
        Scanner skener = new Scanner(System.in);
        System.out.print("Unesite duzinu niza: ");
        int lengthOfFirstArray = skener.nextInt();
        String[] firstArray = new String[lengthOfFirstArray];
        for (int i = 0; i < lengthOfFirstArray; i++) {
            System.out.print("Unesite " + (i+1) + ". element niza: ");
            firstArray[i] = skener.next();
        }
        return firstArray;
    }
    public static char[] unosNizaChar (){
        Scanner skener = new Scanner(System.in);
        System.out.print("Unesite duzinu niza: ");
        int lengthOfFirstArray = skener.nextInt();
        char[] firstArray = new char[lengthOfFirstArray];

        for (int i = 0; i < lengthOfFirstArray; i++) {
            System.out.print("Unesite " + (i+1) + ". element niza: ");
            firstArray[i] = skener.next().charAt(0);
        }
        return firstArray;
    }
    public static int zbirCifara (int n){
        int startingNumber = n;
        int numberOfDigits = 0;
        int sumOfDigits = 0;
        for (;startingNumber > 0;) {
            startingNumber /= 10;
            numberOfDigits++;
        }
        startingNumber = n;
        for (int i = numberOfDigits; i > 0; i--){
            sumOfDigits += startingNumber % 10;
            startingNumber /= 10;
        }
        if (sumOfDigits >= 10) {
            sumOfDigits = zbirCifara(sumOfDigits);
        }
        return sumOfDigits;
    }
    public static boolean stepenBroja (int n, int m) {
        boolean isPower = false;
        if ((Math.log(n)/Math.log(m))==(int)(Math.log(n)/Math.log(m))) {
            isPower = true;
        }
        return isPower;
    }
    public static int[] zbirIndexaNizaMeta (int [] firstArray, int meta){
        int[] returnedIndexes = new int[2];
        for (int i = 0; i < firstArray.length; i++) {
            for (int j = (i+1); j < firstArray.length; j++){
                if (meta == (firstArray[i] + firstArray[j])) {
                    returnedIndexes[0] = i;
                    returnedIndexes[1] = j;
                    break;
                }
            }
        }
        return returnedIndexes;
    }
    public static String toBinary (int n){
        String numberInBinaryFormatInverse = "";
        int inputedNumber = n;
        for (;inputedNumber > 0;){
            char a =(char) ((inputedNumber % 2) + '0');
            numberInBinaryFormatInverse += a;
            inputedNumber /= 2;
        }
        String numberInBinaryFormat = "";
        for (int i = (numberInBinaryFormatInverse.length() - 1); i >= 0; i--) {
            numberInBinaryFormat += numberInBinaryFormatInverse.charAt(i);
        }
        return numberInBinaryFormat;
    }
    public static int brojPonavljanja (String s, String sentence){
        String[] arrayOfStrings = sentence.toLowerCase().split(s, -2);
        int numberOfRepetitions = arrayOfStrings.length - 1;
        return numberOfRepetitions;
    }
    public static int[] pomeriNule (int[] array) {
        int[] returnedArray = new int[array.length];
        int counter = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i]!=0){
                returnedArray[counter] = array[i];
                counter++;
            }
        }
        for (int i = counter; i < array.length; i++){
            returnedArray[i] = 0;
        }
        return returnedArray;
    }
    public static int[] izbaciDuplikate (int[] array){
        int[] secondArray = new int[array.length];
        int counter = 0;
        for (int i = 0; i < array.length; i++){
            boolean isDuplicate = true;
            for (int j = (i + 1); j < array.length; j++){
                if (array[i] == array[j]) {
                    isDuplicate = false;
                    break;
                }
            }
            if (isDuplicate){
                secondArray[counter] = array[i];
                counter++;
            }
        }
        int[] returnedArray = new int[counter];
        for (int i = 0; i < counter; i++){
            returnedArray[i] = secondArray[i];
        }
        return returnedArray;
    }
    public static int[][] powerSet (int[] inputArr) {
        int n = (int) (Math.pow(2,inputArr.length));
        int [][]subSets= new int [n][3];

        for(int i = 0;i<n;i++){
            int []arr2= new int[inputArr.length];
            int k=0;
            for (int j=0;j< inputArr.length;j++){
                if((i & (1<<j))!=0){
                   arr2[k]=inputArr[j];
                    k++;
                }
            }
            subSets[i]=Arrays.copyOf(arr2,k);
        }
        return subSets;
    }
    public static boolean validatePhone (String num){
        Pattern pattern = Pattern.compile("^((\\(\\d{3}\\)[ ])|\\d{3}[-])\\d{3}[-]\\d{4}$");
        return Pattern.matches(String.valueOf(pattern), num);
    }
}
