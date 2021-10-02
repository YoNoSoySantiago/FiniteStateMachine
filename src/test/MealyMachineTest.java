package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.MealyMachine;
import model.MealyMachine.State;

class MealyMachineTest {
	private MealyMachine mealyMachine;
	
	@Test
	void test1() {
		setUp();
		setUp2();
		MealyMachine otherMachine = mealyMachine.generateAutomataEquivalent();
//		ArrayList<State> allStates = otherMachine.getAllStates();
//		for(State state : allStates) {
//			System.out.println(state.getName());
//		}
		System.out.println(mealyMachine.toString());
		System.out.println("----------------------------------------------\n");
		System.out.println(otherMachine.toString());
	}
	void setUp() {
		mealyMachine = new MealyMachine("A");
		mealyMachine.addState("A");
		mealyMachine.addState("B");
		mealyMachine.addState("C");
		mealyMachine.addState("D");
		mealyMachine.addState("E");
		mealyMachine.addState("F");
	}
	
	void setUp2() {
		mealyMachine.addTransition("A", "1", "B", "1");
		mealyMachine.addTransition("A", "0", "A", "1");
		
		mealyMachine.addTransition("B", "1", "A", "1");
		mealyMachine.addTransition("B", "0", "C", "0");
		
		mealyMachine.addTransition("C", "1", "D", "0");
		mealyMachine.addTransition("C", "0", "D", "1");
		
		mealyMachine.addTransition("D", "1", "B", "0");
		mealyMachine.addTransition("D", "0", "C", "1");
		
		mealyMachine.addTransition("E", "1", "E", "1");
		mealyMachine.addTransition("E", "0", "C", "0");
		
		mealyMachine.addTransition("F", "1", "E", "1");
		mealyMachine.addTransition("F", "0", "A", "1");
	}
}
