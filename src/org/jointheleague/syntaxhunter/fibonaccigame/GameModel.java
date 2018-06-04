package org.jointheleague.syntaxhunter.fibonaccigame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameModel {
	
	int total;
	int previousPlay;
	
	public GameModel() {
		total = new Random().nextInt(99) + 2;
	}
	
	// returns 1 if move was played, 0 if not
	public int play(int num) {
		if(checkValid(num)) {
			previousPlay = num;
			total -= num;
			return 1;
		}
		return 0;
	}
	
	public boolean checkValid(int num) {
		if(num <= 0) {
			return false;
		}
		if(previousPlay == 0) {
			return num < total;
		} else {
			return num <= previousPlay * 2;
		}
	}
	
	public boolean isFibonacci(int num) {
		int fibNum = 1;
		int prevNum = 1;
		int mid = 0;
		while(num < fibNum) {
			mid = fibNum;
			fibNum = fibNum + prevNum;
			prevNum = mid;
		}
		return num == fibNum;
	}
	
	public int closestFib(int num) {
		int fibNum = 1;
		int prevNum = 1;
		int mid = 0;
		while(num < fibNum) {
			mid = fibNum;
			fibNum = fibNum + prevNum;
			prevNum = mid;
		}
		return prevNum;
	}
	
	public List<Integer> split(int num, int previousPlay) {
		ArrayList<Integer> fibNums = new ArrayList<Integer>();
		fibNums.add(closestFib(num));
		int prevNum = fibNums.get(0);
		int toSplit = num - prevNum;
		while(toSplit * 2 >= prevNum && toSplit * 2 <= previousPlay) {
			prevNum = toSplit;
			fibNums.add(closestFib(toSplit));
			toSplit = prevNum - closestFib(toSplit);
		}
		return fibNums;
	}
	
}
