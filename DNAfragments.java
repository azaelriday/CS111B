// Author(s): Azael Riday, Shawn Luna, Ziky Z
// Date of Last Modification: 03/07/2024
// Course: CS111B
// Instructor: C. Conner 
// Programming Assignment: Arrays Part 2
// File Name: DNAfragments.java
// This program manages a collection of DNA fragments, supporting operations such as addition, display, and deletion of fragments.

import java.util.Scanner;

/**
 * DNAfragments --- This program manages a collection of DNA fragments, allowing the user to add fragments, 
 * display them in reverse order, find the longest fragment, and remove a specified fragment.
 * @author    Azael Riday
 * @version   1.0
 * @since     2024-02-26
 */

public class DNAfragments {
    
    /**
    * Manages DNA fragments through various operations like addition, reverse display, 
    * finding the longest fragment, and deletion of specified fragments based on user input.
    * @exception Returns exception if a non integer input is provided for the first user prompt.
    * @return Returns exit code 0 if successful and exit code 1 if exception occurs.
    */

    public static void main(String args[]) {
        
        Scanner scnr = new Scanner(System.in);
        int i;
        int dnaCount;

        // Step 1: Ask user for how count of data and fill array with user input

        System.out.println("Welcome to the DNA Fragment Helper!");
        System.out.println();
        System.out.print("How many DNA fragments: ");
        dnaCount = scnr.nextInt();
        String[] frags = new String[dnaCount];
        
        for (i = 0; i < dnaCount; i++) {
            
            System.out.print("Enter DNA fragment: ");
            frags[i] = scnr.next();
            
        }

        // Step 2: Display array in reverse
        
        System.out.println("\nHere is fragment sequence in reverse:");
        
        for (i = dnaCount - 1; i >= 0; i--) {
            
            System.out.print(frags[i] + " ");
            
        }
        
        System.out.println();

        // Step 3: Display longest fragment and the length
        
        String longestFrag = "";
        
        for (String fragment : frags) {
            
            if (fragment.length() > longestFrag.length()) {
                
                longestFrag = fragment;
                
            }
            
        }
        
        System.out.print("Longest fragment with " + longestFrag.length() + " letters:\n");
        System.out.print(longestFrag + "\n");

        // Step 4: Ask user for fragment to delete
        // Find the fragment to delete
        // If fragment is in in array
        // remove fragment shifting all remaining elements right
        // else tell user fragment not in list
        
        String removedFrag = "";
        System.out.println("Enter fragment to delete: ");
        removedFrag = scnr.next();

        boolean listedFrag = false;
        
        for (String fragment : frags) {
            
            if (fragment.equals(removedFrag)) {
                
                listedFrag = true;
                
            }
            
        }

        if (listedFrag) {
            
            String[] newFrag = new String[dnaCount - 1];
            int j = 0;
            
            for (i = 0; i < dnaCount; i++) {
                
                if (!frags[i].equals(removedFrag)) {
                    
                    newFrag[j] = frags[i];
                    j++;
                    
                }
                
            }

            System.out.println("Here is the updated sequence:");
            
            for (i = 0; i < newFrag.length; i++) {
                
                System.out.print(newFrag[i] + " ");
                
            }
            
            System.out.println();
            
        }
        
        else {
            
            System.out.println(removedFrag + " is not on the list.");
            
        }
        
    }
    
}
