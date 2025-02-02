package Sheet2;

import java.security.KeyStore;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class SlidingPuzzle {
    public int[][] puzzle;
    public HashSet<Integer> visited;
    public boolean sorted;

    public SlidingPuzzle() {
        puzzle = new int[][]{{1, 6, 5}, {4, 2, 7}, {8, 3, 0}};
        visited = new HashSet<>();
        sorted = false;
    }

    public int convertPuzzIntoNum(int[][] puzz) {
        int[] flat = this.flatten(puzz);
        int acc = 0;
        for (int i = 0; i < flat.length; i++) {
            acc += (int) Math.pow(10, i) * flat[flat.length - 1 - i];
        }
        return acc;
    }

    public int[] flatten(int[][] puzz) {
        int[] acc = new int[puzz.length * puzz[0].length];
        for (int y = 0; y < puzz.length; y++) {
            for (int x = 0; x < puzz[0].length; x++) {
                acc[y * puzz.length + x] = puzz[y][x];
            }
        }
        return acc;
    }

    public int[][] getNeighbours(int[][] puzz, int x, int y) {
        int[][] neighbours = new int[4][2];
        int index = 0;

        if (y > 0) {
            neighbours[index][0] = x;
            neighbours[index][1] = y - 1;
            index++;
        }
        if (y < puzz.length - 1) {
            neighbours[index][0] = x;
            neighbours[index][1] = y + 1;
            index++;
        }
        if (x > 0) {
            neighbours[index][0] = x - 1;
            neighbours[index][1] = y;
            index++;
        }
        if (x < puzz[0].length - 1) {
            neighbours[index][0] = x + 1;
            neighbours[index][1] = y;
            index++;
        }

        return Arrays.copyOf(neighbours, index);
    }

    public boolean isSorted(int[][] puzz) {
        return convertPuzzIntoNum(puzz) == 12345678;
    }

    public int[][] puzzCopy(int[][] puzz) {
        int[][] newPuz = new int[puzz.length][puzz[0].length];
        for (int y = 0; y < puzz.length; y++)
            for (int x = 0; x < puzz[0].length; x++)
                newPuz[y][x] = puzz[y][x];
        return newPuz;
    }

    public void dfs(int[][] puzz, int x, int y) {
        int puzzNum = convertPuzzIntoNum(puzz);
        if (visited.contains(puzzNum) || this.sorted) return;
        visited.add(puzzNum);
        printPuzz(puzz);
        if (isSorted(puzz)) {
            this.sorted = true;
            return;
        }
        int[][] neighbours = getNeighbours(puzz, x, y);
        printPuzz(neighbours);
        for (int[] n : neighbours) {
            int[][] newPuzz = puzzCopy(puzz);
            newPuzz[y][x] = puzz[n[1]][n[0]];
            newPuzz[n[1]][n[0]] = 0;
            dfs(newPuzz, n[0], n[1]);
        }
    }

    public void printPuzz(int[][] puzz) {
        for (int[] a : puzz)
            System.out.println(Arrays.toString(a));
        System.out.println();
    }

    public static void main(String[] args) {
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
        int[] flat = slidingPuzzle.flatten(slidingPuzzle.puzzle);
        slidingPuzzle.dfs(slidingPuzzle.puzzle, 2, 2);
    }
}
