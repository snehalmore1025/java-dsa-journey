
class GuessGame {
    private int pickedNumber = 6;

    public int guess(int num) {
        if (num > pickedNumber) {
            return -1;
        } else if (num < pickedNumber) {
            return 1;
        } else {
            return 0;
        }
    }
}

 class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.guessNumber(10);

        System.out.println("Guessed number: " + answer);
    }
}
