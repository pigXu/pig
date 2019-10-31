package com.xujm.leetcode;

/**
 * 贪心：一条路走到黑，就一次机会，只能哪边看着顺眼走哪边
 * 回溯：一条路走到黑，无数次重来的机会，还怕我走不出来 (Snapshot View)
 * 动态规划：拥有上帝视角，手握无数平行宇宙的历史存档，同时发展出无数个未来 (Versioned Archive View)
 * <p>
 * 背包问题
 *
 * @author xujm
 * @date 2019/10/30
 */
public class BackPack {

    public static void main(String[] args) {
        int[] weight = {2, 2, 4, 6, 3};
        int n = 5;
        int w = 9;
        System.out.println(knapsack(weight, n, w));

        f(0, 0);
        System.out.println(maxW);
    }

    /**
     * 动态规划
     * 时间复杂度O(n*w) 空间复杂度O(w)
     *
     * @param weight 物品重量
     * @param n      物品个数
     * @param w      背包可承重重量
     */
    public static int knapsack(int[] weight, int n, int w) {
        boolean[] states = new boolean[w + 1];
        //第一行数据特殊处理
        states[0] = true;
        if (weight[0] <= w) {
            states[weight[0]] = true;
        }
        //动态规划状态转移
        for (int i = 1; i < n; i++) {
            //把第i个物品放入背包
            for (int j = w - weight[i]; j > -1; j--) {
                if (states[j]) {
                    states[j + weight[i]] = true;
                }
            }
        }
        //输出结果
        for (int i = w; i > -1; i--) {
            if (states[i]) {
                return i;
            }
        }

        return 0;
    }

    static int[] weight = {2, 2, 4, 6, 3};
    static int n = 5;
    static int w = 9;
    static int maxW = Integer.MIN_VALUE;
    static boolean[][] mem = new boolean[5][10];

    /**
     * 回溯算法
     * 时间复杂度O(n*n)
     */
    public static void f(int i, int cw) {
        //i==n代表放满 cw=w代表考察完
        if (i == n || cw == w) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        if (mem[i][cw]) {
            return;
        }
        mem[i][cw] = true;
        //不把第i个物品放入背包
        f(i + 1, w);
        //把第i个物品放入背包
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]);
        }
    }
}
