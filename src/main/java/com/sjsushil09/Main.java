package com.sjsushil09;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "ffffffccccaaa";
        char[] ans = new char[s.length()];
        Arrays.fill(ans, '1');  // Temporary filling with '1' to mark empty positions

        int[] freq = new int[26];

        // Frequency count of characters
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int global = 0;
        int n = s.length();

        // While there are still characters left to place
        while (global < n) {
            // Find the character with maximum frequency
            int idx = findMaxFreqEle(freq);

            // Try to place the character in alternate positions
            boolean placed = false;
            for (int i = 0; i < n; i++) {
                if (i == 0 || ans[i - 1] != (char)(idx + 'a')) {
                    if (ans[i] == '1') { // Place if the position is empty
                        ans[i] = (char) (idx + 'a');
                        freq[idx]--;
                        placed = true;
                        break;
                    }
                }
            }

            // If we cannot place the character, it's impossible to complete
            if (!placed) {
                System.out.println("Not possible to rearrange the string");
                return;
            }

            global++;
        }

        System.out.println(new String(ans));
    }

    // Helper function to find index of maximum frequency element
    private static int findMaxFreqEle(int[] freq) {
        int maxIdx = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] > freq[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
