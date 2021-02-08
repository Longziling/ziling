package com.ziling.goodlife.leetcode.simple;

public class SumItem {
    private Integer lSum;
    private Integer rSum;
    private Integer mSum;
    private Integer tSum;

    public SumItem(Integer lSum, Integer rSum, Integer mSum, Integer tSum) {
        this.lSum = lSum;
        this.rSum = rSum;
        this.mSum = mSum;
        this.tSum = tSum;
    }

    public Integer getlSum() {
        return lSum;
    }

    public void setlSum(Integer lSum) {
        this.lSum = lSum;
    }

    public Integer getrSum() {
        return rSum;
    }

    public void setrSum(Integer rSum) {
        this.rSum = rSum;
    }

    public Integer getmSum() {
        return mSum;
    }

    public void setmSum(Integer mSum) {
        this.mSum = mSum;
    }

    public Integer gettSum() {
        return tSum;
    }

    public void settSum(Integer tSum) {
        this.tSum = tSum;
    }
}
