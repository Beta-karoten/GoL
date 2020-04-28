package com.company;

import java.util.InputMismatchException;

public class Board {
    private int N;
    private boolean[][] board,newboard;
    private boolean isUpgrade=true;

    public Board(int n) {
        N = n;
        board=new boolean[N][N];
        newboard=new boolean[N][N];
    }


    public void reset(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j]=false;
                newboard[i][j]=false;
            }
        }
    }

    public void setlife(int row,int cow)throws InputMismatchException {
        try {
            newboard[row][cow] = true;
            board[row][cow] = true;
            isUpgrade = true;
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Podano wspolrzedne wykraczajace poza zakres tablicy!");
        }
    }

    public int neighbourscount(int row, int col) {
        int count = 0;
        int fromi = row - 1, toi = row + 1, fromj = col - 1, toj = col + 1;
        if (row == 0) {
            fromi = row;
        }
        if (row == N - 1) {
            toi = row;
        }
        if (col == 0) {
            fromj = col;
        }
        if (col == N - 1) {
            toj = col;
        }
        for (int i = fromi; i <= toi; i++) {
            for (int j = fromj; j <= toj; j++) {
                if (board[i][j]) {
                    if(i==row && j==col){
                        continue;
                    }else {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public boolean update(int row, int col) {
        if(board[row][col]){
            if(neighbourscount(row, col)<2 || neighbourscount(row, col)>3){
                return false;
            }else if(neighbourscount(row,col)==2 || neighbourscount(row, col)==3)
            {
                return true;
            }
        }else if(!board[row][col] && neighbourscount(row, col)==3)
        {
            return true;
        }
        return false;
    }
    public void nextgen(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                newboard[i][j]=update(i,j);
            }
        }
        isUpgrade=true;
    }
    public void play(){
        while(isUpgrade==false) {
            nextgen();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (newboard[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = newboard[i][j];
            }
        }
        isUpgrade = false;
    }
}
