package org.jointheleague.syntaxhunter.fibonaccigame;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestGameModel {

	@Test
	public void testClosestFib() { 
		
	}
	
	@Test
	public void testSplit() {
		GameModel model = new GameModel();
		List<Integer> nums = model.split(88, 3);
		assertEquals(Arrays.asList(55,21,8,3,1), nums);
	}
	
	
}
