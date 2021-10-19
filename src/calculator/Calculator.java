package calculator;
import java.util.ArrayList;

public class Calculator implements java.io.Serializable {
	private Double OperandOne = Double.NaN;
	private Double OperandTwo = Double.NaN;
	private Double Result = Double.NaN;
	private String Operation;
	private ArrayList<String> Operations = new ArrayList<String>();
	private ArrayList<Double> Operands = new ArrayList<Double>();
	
	public Calculator() {
		
	}
	
	public double getOperandOne() {
		return OperandOne;
	}
	public void setOperandOne(double operandOne) {
		OperandOne = operandOne;
	}
	public String getOperation() {
		return Operation;
	}
	public void setOperation(String operation) {
		Operation = operation;
	}
	public double getOperandTwo() {
		return OperandTwo;
	}
	public void setOperandTwo(double operandTwo) {
		OperandTwo = operandTwo;
	}
	
	public void performOperation(String input){
		if(input != "=") {
		Operations.add(input);}
	}
	
	public void performOperation(double input) {
		Operands.add(input);
	}
	
	
	public double getResults() {
		
		for (int j=0;j<Operations.size();j++) {
			if(Operations.get(j) == "*"| Operations.get(j) == "/") {
				InsertOperation(Operands.get(j), Operands.get(j+1), Operations.get(j));
				Operands.remove(j); //removes first operand
				Operands.remove(j); //removes second operand
				Operations.remove(j); //removes operator
				Operands.add(j, Result); //add result
				System.out.println(Result);
			}
		}
		
		for (int i=0;i<Operations.size();i++) {
				
				InsertOperation(Operands.get(i), Operands.get(i+1), Operations.get(i));
				Operands.remove(i); //removes first operand
				Operands.remove(i); //removes second operand
				Operations.remove(i); //removes operator
				Operands.add(i, Result); //add result
				System.out.println(Result);
		}
		
		
		return Result;
	}
	
	
	
	
	public void InsertOperation(double num1, double num2, String op) {
		
		OperandOne= num1;
		OperandTwo = num2;
		Operation = op;
		Calculate();
		
	}
	
	
	
	public void Calculate() {
		 
		
		
		switch(Operation) {
		
		case "+": 
			Result = OperandOne + OperandTwo;
			break;
		case "-":
			Result = OperandOne - OperandTwo;
			break;
		case "*":
			Result = OperandOne * OperandTwo;
			break;
		case "/":
			Result = OperandOne / OperandTwo;
			break;
		
			
		}
		
		Operation = "";
		OperandOne = Double.NaN;
		OperandTwo = Double.NaN;
	}
	

}
