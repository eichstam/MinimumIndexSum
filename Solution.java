import java.util.ArrayList;

/**
 * 
 * 599. Minimum Index Sum of Two Lists

Suppose Andy and Doris want to choose a restaurant for dinner, and they
both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least
list index sum. If there is a choice tie between answers, output all
of them with no order requirement. You could assume there always
exists an answer.

Example 1:

Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:

Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is
"Shogun" with index sum 1 (0+1).

Note:

    The length of both lists will be in the range of [1, 1000].
    The length of strings in both lists will be in the range of [1, 30].
    The index is starting from 0 to the list length minus 1.
    No duplicates in both lists.

 * 
 *
 */


public class Solution {
  public String[] findRestaurant(String[] list1, String[] list2) {
    int i = 0;
    int j = 0;
    int minIndexSum = Integer.MAX_VALUE;
    ArrayList<String> retList = new ArrayList<>();
    String[] retArray = {};

    for(i = 0; (i < list1.length) && (i+j <= minIndexSum); i++) {
      for(j = 0; (j < list2.length) && (i+j <= minIndexSum); j++) {
        if(list1[i].equals(list2[j])) {
          // found common string
          if((i + j) < minIndexSum) {
            minIndexSum = i + j;
            retList.clear();
            retList.add(list1[i]);
          } else if((i + j) == minIndexSum) {
            retList.add(list1[i]);
          }
        }
      }
      j = 0;
    }
    retArray = retList.toArray(retArray);
    return retArray;
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
    String[] list2 = {"KFC", "Shogun", "Burger King"};

    String[] result = s.findRestaurant(list1, list2);
    System.out.print("Out:");
    for(int i = 0; i < result.length; i++) {
      System.out.print(" " + result[i]);
    }
    System.out.println();
    
    list1 = new String[] {"Shogun","Tapioca Express","Burger King","KFC"};
    list2 = new String[] {"KFC","Burger King","Tapioca Express","Shogun"};
    result = s.findRestaurant(list1, list2);
    System.out.print("Out:");
    for(int i = 0; i < result.length; i++) {
      System.out.print(" " + result[i]);
    }
    System.out.println();
  }
}
