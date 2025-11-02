package Leetcode.Medium;

public class LCMinimumTimeToCompleteAllDeliveries {
    public long minimumTime(int[] d, int[] r) {
        long left = 0, right = 1000000000000L;
        long ans = right;
        long d1=d[0];
        long d2=d[1];
        long r1=r[0];
        long r2=r[1];
        long lcm = lcm(r1, r2);

        while (left <= right) {
            long mid = left + ((right - left) >>> 1);

            long w1 = mid - mid / r1;
            long w2 = mid - mid / r2;
            long bothR = mid / lcm;
            long tA = mid - bothR;

            if (w1 >= d1 && w2 >= d2 && tA >= d1 + d2) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
