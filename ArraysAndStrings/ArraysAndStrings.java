
package arraysandstrings;
import java.util.*;
import java.math.*;


/**
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 * 
 */
class Question1
{
    private final static int  MAX_CHAR = 256;
    //unique characters using brute force technique
    // Time Complexity : o(n^2)
    public boolean uniqueCharacters(String str)
    {
        //if at any time ew encounter 2 same
        // characters, return false
        for(int i = 0; i < str.length(); i++)
            for(int j = i+1; j < str.length(); j++)
                if(str.charAt(i) == str.charAt(j))
                    return false;
        
        // If no duplicate characters encountered
        // return true
        return true;
    }
    
    //check string with unique characters using sorting technique
    // Time Complexity : o(n log n)
    public boolean uniqueCharacters2(String str)
    {
        char [] chArray = str.toCharArray();
        Arrays.sort(chArray);
        
        for(int i=0; i<chArray.length-1; i++)
        {
            //if the adjacent elements are not equal, move to next element
            if (chArray[i] != chArray[i+1])
                continue;
            
            // if at any time, 2 adjacent elements become equal, return false
            else
                return false;
        }
        return true;
    }
    

    //String with Unique Characters using data structure
    // Time Complexity : o(n)
    public boolean uniqueCharacters3(String str)
    {
        //If length is greater than 265, some characters must have been repeated
        if(str.length() > MAX_CHAR)
            return false;
        boolean[] chars = new boolean[MAX_CHAR];
        Arrays.fill(chars, false); // optional
        int index;
        for(int i = 0; i < str.length(); i++){
            index = (int) str.charAt(i);
            
            //If the value is false, set it true
            if(chars[index] == false)
                chars[index] = true;
            
            //If the value is already true, string has duplicate characters, 
            //return false 
            else
                return false; 
        }
        
        //No duplicates encountered, return true
        return true;
    }
    
}

/**
 * given two strings,
 * write a method to decide if one is a permutation of the other.
 * 
 */
class Question2
{
    private final static int  MAX_CHAR = 256;
    
    //Check if the two strings have identical character counts
    // Time Complexity : o(n)
    public boolean permutation(String str1, String str2)
    {
        if(str1.length() != str2.length())
            return false;
        
        int[] arr = new int[MAX_CHAR]; // assume character is ASCII
       
        for(int i = 0; i < str1.length(); i++)
            arr[(int)str1.charAt(i)]++;
        
        for(int i = 0; i < str2.length();i++)
            if(--arr[(int)str2.charAt(i)] < 0)
                return false;
        
        return true;
    }
    
    //Sort two strings and compare(use sort api)
    public boolean permutation2(String str1, String str2)
    {
        if(str1.length() != str2.length())
            return false;
        
        return sort(str1).equals(sort(str2));
    }
    
    private String sort(String str)
    {
        char[] temp = str.toCharArray();
        java.util.Arrays.sort(temp);
        return new String(temp);
    } 
}

/**
 * Write a method to replace all spaces in a string with '%20'. 
 * You may assume that the string has sufficient space at the end 
 * to hold the additional characters,
 * and that you are given the "true" length of the string.
 * 
 */
class Question3
{
    //using substring method and the ascii for space (32).
    // Time Complexity : o(n)
    public String replaceSpaceInString(String str)
    {
        for(int i = 0; i < str.length(); i++)
            if(str.charAt(i) == 32)
            {
                str = str.substring(0, i) + "%20" + str.substring(i+1, str.length());
                i += 2;
            }
       return str; 
    }
}
/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. 
 * A permutation is a rearrangement of letters. The palindrome does not need to be limited to just
 * dictionary words.
 */
class Question4 
{
    // Time Complexity : o(n^2)
    public boolean IsPalindromePermutation(String str)
    {
        int length = str.length(),count = 0;
        char ch;
        boolean oddChr = false ;
        // to get the numbers of characters in the string, ignoring the spaces.
        for(int i = 0 ; i < str.length(); i++)
            if(str.charAt(i) == ' ')
                length--;
        
        for(int i = 0 ; i < str.length(); i++)
        {
            // ignore the space.
            if(str.charAt(i) == ' ')
                continue;
            
            count = 0;
            ch = str.charAt(i);
            for(int j = 0; j < str.length(); j++)
            {
                // ignore the space.
                if(str.charAt(j) == ' ')
                    continue;
                
                //count the occurrence of the character in the string.
                if(str.charAt(i) == str.charAt(j))
                    count++;
            }
            
            // if the occurrence is even then its ok.
            // else check for other details
            if(count % 2 != 0)
            {
                // if length is even that means it cant
                // have any characters with odd occurrence.
                if(length % 2 == 0)
                    return false;
                
                // if the length is odd then it can have
                // only one character with odd occurrence.
                else if(oddChr && ch == str.charAt(i))
                    return false;
                else
                    oddChr = true;
            }
        }
        return true;
    }
}


/**
 * There are three types of edits that can be performed on strings: 
 * insert a character, remove a character, or replace a character. 
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * 
 */
class Question5 
{
    // Time Complexity : o(n), n the beger ogf the tow string 
    public boolean oneEditAway(String str1, String str2)
    {
        if(str1.length() == str2.length())
            return oneEditReplace(str1, str2);
        else if(str1.length() + 1 == str2.length())
            return oneEditinsert(str1, str2);
        else if(str1.length() == str2.length() + 1)
            return oneEditinsert(str2, str1);
        return false;
        
    }
    
    // Time Complexity : o(n), n the beger ogf the tow string 
    public boolean oneEditAway2(String str1, String str2)
    {
        //If difference between lengths is more than 1
        //then strings can't be at one distance
        if(Math.abs(str1.length() - str2.length()) > 1)
            return false;
        
        int count = 0; // Count of edits
        int i = 0, j = 0;
        for(; i < str1.length() && j < str2.length();)
        {
            // If current characters don't match
            if(str1.charAt(i) != str2.charAt(j)){
                
                if(count == 1)
                    return false;
                // If length of one string is
                // more, then only possible edit
                //is to remove a character
                if(str1.length() > str2.length())
                    i++;
                else if(str1.length() < str2.length())
                    j++;
                else //If lengths of both strings is same
                {
                    i++;
                    j++;
                }
                // Increment count of edits
                count++;
            }
            else // If current characters match
            {
                i++;
                j++;
            }
        }
        
        if(i < str1.length() || j < str2.length())
            count++;
        return  count == 1;
    }
    
    
    private boolean oneEditReplace(String str1, String str2)
    {
        boolean foundDifference = false;
        for(int i = 0 ; i < str1.length(); i++)
            if(str1.charAt(i) != str2.charAt(i)){
                if(foundDifference)
                    return false;
                
                foundDifference = true;
            }
        return foundDifference;
    }
    
    private boolean oneEditinsert(String str1, String str2)
    {
        int index1 = 0, index2 = 0;
        while (index2 < str2.length() && index1 <str1.length())
        {
            if(str1.charAt(index1) != str2.charAt(index2)){
                if(index1 != index2)
                    return false;
                index2++;
            }
            else
            {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
/**
 * implement a method to perform basic string compression using the counts
 * of repeated characters
 */
class Question6
{
    // Time Complexity : O(p + k^2 ), 
    //p is the size of the original string and k is the number of character sequences.
    public String compressBad(String str)
    {
        String compressedString = "";
        int countConsecutive = 0;
        for(int i = 0; i < str.length(); i++)
        {
            countConsecutive++;
            
            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1))
            {
                compressedString += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        return  compressedString.length() < str.length() ? compressedString : str;
    }
    
    //using StringBuilder
    public String compressBad2(String str)
    {
        StringBuilder compressed= new StringBuilder();
        int countConsecutive = 0;
        
         for(int i = 0; i < str.length(); i++)
        {
            countConsecutive++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) 
            {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
          return  compressed.length() < str.length() ? compressed.toString() : str;
    }
}


/**
 * Given an image represented by an NxN matrix, where each pixel in
 * the image is 4 bytes, write a method to rotate the image by 90
 * degrees. Can you do this in place?
 */
class Question7
{
    // With extra space.
    public int[][] rotate(int[][] matrix)
    {
        int[][] ret = new int[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix.length; j++)
                ret[i][j] = matrix[matrix.length - 1 - j][i];
        return ret;
    }
    
    public void rotateInPlace(int[][] matrix)
    {
        int tmp;
        for(int i = 0; i < matrix.length/2; i++)
            for(int j = i; j < matrix.length - 1 - i; j++)
            {
                // save top
                tmp =matrix[i][j];
                // left to top
                matrix[i][j] = matrix[matrix.length - 1- j][i];
                // bottom to left
                matrix[matrix.length - 1- j][i] = matrix[matrix.length - 1- i][matrix.length -1 -j];
                // right to bottom
                matrix[matrix.length - 1- i][matrix.length -1 -j] = matrix[j][matrix.length -1 -i];
                // top to right
                matrix[j][matrix.length -1 -i] = tmp ;
            }
    }
}
/**
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 */
class Question8 
{
    public void modifyMatrix(int[][] matrix)
    {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        
        //Store the rows and columns to be marked as 0 
        //in row[] and col[] arrays respectively 
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(matrix[i][j] == 0)
                {
                    row[i] = true;
                    col[j] = true;
                }
        // Nullify rows
        for(int i = 0; i < matrix.length; i++)
            if(row[i])
                nullifyRow(matrix, i);
        
        // Nullify columns
         for(int j = 0; j < matrix[0].length; j++)
             if(col[j])
                 nullifyColumn(matrix,j);
    }
    
    //using stack
    public void modifyMatrix2(int[][] matrix)
    {
        Stack<Integer> rowClm = new Stack<>();
        
        for (int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(matrix[i][j] == 0)
                {
                    rowClm.push(i);
                    rowClm.push(j);
                }
        int col, row; 
        while (!rowClm.isEmpty())
        {
            col = rowClm.pop();
            row = rowClm.pop();
            for(int i = 0; i < matrix.length; i++) 
            {
                if(i <matrix.length)
                    matrix[i][col] = 0;
                
                if(i< matrix[0].length)
                    matrix[row][i] = 0;
            }
        }
    }
    
    private void nullifyRow(int[][] matrix, int row)
    {
        for(int j = 0; j < matrix[0].length; j++)
            matrix[row][j] = 0;  
    }
    
    private void nullifyColumn(int[][] matrix, int col)
    {
         for(int i = 0; i < matrix.length; i++)
             matrix[i][col] = 0;
    }
}

/**
 * Assume you have a method isSubstring which checks 
 * if one word is a substring of another.
 * Given two strings, s1 and s2,
 * write code to check if s2 is a rotation of s1 
 * using only one call to isSubstring
 */
class Question9 
{
    
    public boolean isRotation(String str1, String str2)
    {
        if(str1.length() != str2.length())
            return false;
        // using the Contains method.
        return isSubstring(str1 + str1,str2);
    }
    
  private boolean isSubstring(String str1, String str2)
  {
      return str1.contains(str2);
  }
  
  //Implement the isSubString method without using the method of Contains
  private boolean isSubstring2(String str1, String str2)
  {
      for(int i = 0; i < str1.length(); i++)
          for(int j = i, k = 0; str2.charAt(k++) == str1.charAt(j++);)
              if(k == str2.length())
                  return true;
      return false;
  }
    
}
public class ArraysAndStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Question1 obj = new Question1();
        Question2 obj2 = new Question2();
        Question3 obj3 = new Question3();
        Question4 obj4 = new Question4();
        Question5 obj5 = new Question5();
        Question6 obj6 = new Question6();
        Question7 obj7 = new Question7();
        Question8 obj8 = new Question8();
         Question9 obj9 = new Question9();
        String input = "abcdefg";
        String input2 = "gfabcde";
         int[][] matrix = {{1, 2, 3, 4, 5}, 
                           {11, 22, 33, 44, 55},
                           {5, 4, 3, 2, 1},
                           {55, 44, 33, 22, 11},
                           {6, 7, 8, 9, 0}};
         
         int[][] matrix2 = {{1, 2, 3, 4},
                            {5, 6, 0, 8},
                            {9, 0, 1, 2},
                            {3, 4, 5, 6}};
        
        if(obj.uniqueCharacters2(input))
            System.out.println("The String " + input + " has all unique characters");
        else
             System.out.println("The String " + input + " has duplicate characters");
        
         if(obj2.permutation(input, input2))
             System.out.println("The two strings are anagram of each other" );
         else
            System.out.println("The two strings are not anagram of each other"); 
        
          System.out.println(obj3.replaceSpaceInString("Mr John Smith")); 
          
         System.out.println(obj4.IsPalindromePermutation("TAC TCC O CATT"));
         System.out.println("-------------------------------------");
         System.out.println(obj5.oneEditAway("geeks", "geek"));
         System.out.println(obj5.oneEditAway("geeks", "geeks"));
         System.out.println(obj5.oneEditAway("geaks", "geeks"));
         System.out.println(obj5.oneEditAway("peaks", "geeks"));
         System.out.println("-------------------------------------");
         System.out.println(obj6.compressBad("aabcccccaaa"));
         System.out.println("-------------------------------------");
         System.out.println(Arrays.deepToString(matrix));
         System.out.println(Arrays.deepToString(obj7.rotate(matrix)));
         System.out.println(Arrays.deepToString(matrix));
         obj7.rotateInPlace(matrix);
         System.out.println(Arrays.deepToString(matrix));
         System.out.println("-------------------------------------");
         System.out.println(Arrays.deepToString(matrix2));
         obj8.modifyMatrix2(matrix2);
         System.out.println(Arrays.deepToString(matrix2));
         System.out.println("-------------------------------------");
         System.out.println(obj9.isRotation("waterbottle", "erbottlewat"));
    }
    
}
