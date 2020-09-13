package com.qa.quickfixsolutions;

public class ReplaceCurlyBraces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str= "Hi Sample {{ Automation }} group";
		System.out.println(str.replaceAll("\\{\\{ Automation \\}\\}", "VLearn"));
	}

}
