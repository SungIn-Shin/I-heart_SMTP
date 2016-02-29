package com.iheart.ssi.ies.server;

public class Test {
	public static void main(String[] args) {
//			String g ="zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
			String[] strArr = {"hello", "java", "code"};
			String result = "";
			for(int i = 0; i<strArr.length; i++)
			{
				if(i == strArr.length -1){
					result += strArr[i];
					break;
				}else{
					result += strArr[i] + ",";
				}
				
			}
			System.out.println(result);
	}
}
