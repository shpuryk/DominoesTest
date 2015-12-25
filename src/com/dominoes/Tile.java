package com.dominoes;

/**
 * Created by vlad on 12/25/15.
 */
public class Tile {

    private int first;
    private int second;

    Tile(int first, int second) {
        if (isValid(first, second)) {
            this.first = first;
            this.second = second;
        } else {
            throw new IllegalArgumentException("Tile has invalid values");
        }
    }

    public static boolean isValid(int first, int second) {
        return (first >= 0 && first <= 6 && second >= 0 && second <= 6);
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void revert() {
        int tmp = first;
        first = second;
        second = tmp;
    }

    @Override
    public boolean equals(Object obj) {
        Tile nObj = (Tile) obj;

        return ((this.first == nObj.first && this.second == nObj.second) ||
                (this.first == nObj.second && this.second == nObj.first));
    }

    @Override
    public String toString() {
        return first + "" +  second + " ";
    }
}
