package dsa.Graphs;/*
Breadth first search algorithm to solve snake ladder problem

Snake and ladder board is given as matrix, find the minimum number of dice throws required to reach the last cell from source cell in Space Complexity O(n) Asked in : Amazon, Flipkart

Example:

[Every cell is added and removed only once from queue so Space complexity O(n)]
[enqueue or dequeue operation takes O(1) time ]
Rules The game is played with a cubic die of  faces number 1 to 6

1.Starting from square , land on square  with the exact roll of the die. If moving the number rolled would place the player beyond square , no move is made.
2.If a player lands at the base of a ladder, the player must climb the ladder. Ladders go up only.
3.If a player lands at the mouth of a snake, the player must go down the snake and come out through the tail. Snakes go down only.
Input: [
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,35,-1,-1,13,-1],
[-1,-1,-1,-1,-1,-1],
[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation:
At the beginning, you start at square 1 [at row 5, column 0].
You decide to move to square 2, and must take the ladder to square 15.You then decide to move to square 17 (row 3, column 5), and must take the snake to square 13. You then decide to move to square 14, and must take the ladder to square 35.You then decide to move to square 36, ending the game. It can be shown that you need at least 4 moves to reach the N*N-th square, so the answer is 4.
Hint: Another BFS Application
 */

import java.util.LinkedList;
import java.util.Queue;

class SnakeLadderProblem {

    static class Cell {
        int vertex;
        int distance;
    }

    public static void main(String[] args) {
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;
        //Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        //Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " +
                minDiceThrown(moves, N));
    }

    private static String minDiceThrown(int[] moves, int n) {
        Queue<Cell> queue = new LinkedList<>();
        Cell c= new Cell();
        c.distance =0;
        c.vertex =0;
        queue.add(c);

        int visited[] = new int[n];
        visited[0] = 1;
        Cell cell = null;
        while(!queue.isEmpty()) {
           cell = queue.poll();
            int v = cell.vertex;
            if(cell.vertex==n-1) {
                break;
            }
            for(int i=v+1;i<v+6 && i<n; i++) {
                if (visited[i] == 0) {
                    visited[i]=1;
                    Cell cell2 = new Cell();
                    cell2.distance = cell.distance + 1;
                    if (moves[i] == 0) {
                        cell2.vertex = i;
                    } else {
                        cell2.vertex = moves[i];
                    }
                    queue.add(cell2);
                }
            }
        }
        return String.valueOf(cell.distance);
    }
}