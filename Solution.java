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

    public void level1DepthFirstPreOrder(String rootNodeId) {
     if (rootNodeId.isEmpty()){
         return;
     }
     /* first print data of node */
     api.activateNode(rootNodeId);
     //System.out.print(rootNodeId);

     /* then recur on left subtree */
     //System.out.println(api.getChildren(rootNodeId).get(0));
     level1DepthFirstPreOrder(api.getChildren(rootNodeId).get(0));
     
     /* now recur on right subtree */
     level1DepthFirstPreOrder(api.getChildren(rootNodeId).get(1));
 }

 /**
  * Carry out depth first in-order traversal (blue circles in the tree)
  */
 public void level2DepthFirstInOrder(String rootNodeId) {
     if (rootNodeId.isEmpty()){
         return;
     }
     
     /*recur on left subtree */
     //System.out.println(api.getChildren(rootNodeId).get(0));
     level2DepthFirstInOrder(api.getChildren(rootNodeId).get(0));
     
     /*print data of node */
     api.activateNode(rootNodeId);
     //System.out.print(rootNodeId);
     
     /* now recur on right subtree */
     level2DepthFirstInOrder(api.getChildren(rootNodeId).get(1));
 }

 /**
  * Carry out depth first post-order traversal (red circles in the tree)
  */
 public void level3DepthFirstPostOrder(String rootNodeId) {
     if (rootNodeId.isEmpty()){
         return;
     }
     
     /*recur on left subtree */
     //System.out.println(api.getChildren(rootNodeId).get(0));
     level3DepthFirstPostOrder(api.getChildren(rootNodeId).get(0));
     
     /* now recur on right subtree */
     level3DepthFirstPostOrder(api.getChildren(rootNodeId).get(1));
     
     /*print data of node */
     api.activateNode(rootNodeId);
     //System.out.print(rootNodeId);
 
 }

   /**
     * Carry out breadth first traversal
     */
    public void level4BreadthFirst(String rootNodeId) {
        
        int h = height(rootNodeId);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(rootNodeId, i);
      
    }
    
    int height(String rootNodeId)
    {
        if (rootNodeId.isEmpty())
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(api.getChildren(rootNodeId).get(0));
            int rheight = height(api.getChildren(rootNodeId).get(1));
 
            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    public void printCurrentLevel(String rootNodeId, int level){
        if (rootNodeId.isEmpty())
            return;
        if (level == 1)
            api.activateNode(rootNodeId);
        else if (level > 1) {
            printCurrentLevel(api.getChildren(rootNodeId).get(0), level - 1);
            printCurrentLevel(api.getChildren(rootNodeId).get(1), level - 1);
        }
    }
}