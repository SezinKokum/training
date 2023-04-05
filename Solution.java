package solution;

import api.*;
import java.util.*;

public class Solution implements SolutionInterface {
    private APICaller api;

    public Solution(APICaller api) {
        this.api = api;
        System.out.println("Press run code to see this in the console!");
        // You can initiate and calculate things here
    }

    /**
     * Return a list where any number evenly divisible by 3 is replaced with
     * the word "Fizz". For example, given the list [1, 2, 3, 4, 5, 6] you
     * should return the following list of strings: ["1", "2", "Fizz", "4",
     * "5", "Fizz"]
     */
    public List<String> level1Fizz(List<Integer> intList) {
        // Write your code here
        ArrayList<String> outputList = new ArrayList<String>(intList.size()-1);

        for(int i: intList){
            if(i%3 == 0){
                 outputList.add("Fizz"); 
            }else{
                 outputList.add(((Integer)i).toString()); 
            }
        }
        return outputList;
    }

    /**
     * Return a list of strings where the following has been replaced:
- Any
     * number evenly divisible by 3 with the word "Fizz".
- Any number evenly
     * divisible by 5 with the word "Buzz".
- Any number evenly divisible by
     * both 3 and 5 with the word "FizzBuzz".
For example, given the list
     * [12, 13, 14, 15, 16] you should return the following list of strings:
     * ["Fizz", "13", "14", "FizzBuzz", "16"]
     */
    public List<String> level2Fizzbuzz(List<Integer> intList) {
        // Write your code here
         ArrayList<String> outputList = new ArrayList<String>(intList.size()-1);

        for(int i: intList){
            if(i%3 ==0 && i%5 == 0){
                 outputList.add("FizzBuzz");
            }else if(i%3 == 0){
                 outputList.add("Fizz"); 
            }else if(i%5 == 0){
                 outputList.add("Buzz"); 
            }else{
                outputList.add(((Integer)i).toString()); 
            }
        }
        return outputList;
    }
}