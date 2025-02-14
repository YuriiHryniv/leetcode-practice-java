package product_of_last_k_numbers;

import java.util.*;

class Solution {
    class ProductOfNumbers {
        Stack<Integer> stack;
        List<Integer> kList;

        public ProductOfNumbers() {
            stack = new Stack<>();
            stack.push(1);
            kList = new ArrayList<>();
            kList.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                kList.clear();
                kList.add(1);
                stack.clear();
                stack.push(1);
                return;
            }
            int peeked = stack.peek();
            stack.push(peeked * num);
            kList.add(peeked * num);
        }

        public int getProduct(int k) {
            if (k > kList.size()) {
                return 0;
            }
            if (kList.size() - 1 - k < 0) return 0;

            return kList.get(kList.size() - 1) / kList.get(kList.size() - 1 - k);
        }
    }

    public static void main(String[] args) {
        Solution.ProductOfNumbers productOfNumbers = new Solution().new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32
    }
}