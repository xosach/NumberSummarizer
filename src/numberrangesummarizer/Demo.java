/**
 * 
 */
package numberrangesummarizer;

import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.ArrayList;

/**
 * @author Sach
 *
 */
public class Demo implements NumberRangeSummarizer {
	
	/**
	Let’s break down this regex and see how it works:
	* > -? – this part identifies if the given number is negative,
	*  the dash “–” searches for dash literally 
	*  and the question mark “?” marks its presence as an optional one
	* > \d+ – this searches for one or more digits
	* > (\.\d+)? – this part of regex is to identify float numbers.
	* Here we're searching for one or more digits followed by a period. 
	* > The question mark, at the end, signifies that this complete group is optional
	**/
	
	//TODO(@sach): split this regex up into mulitple commented strings
	// TODO(@sach): combine all the regexes into one method (isNumeric(String input))
	
	private Pattern include_regex = Pattern.compile(
			"["
			// regex components
			+ "^" // include pattern that of the following: 
			+ "-?" // negative numbers
			+ "\\d+" // only digits
//			+ "(\\.\\d+)?" // float numbers
			+ "," // the comma as a delimiter
			+ "." // the comma as a decimal seperator
			+ "]");
	
	private Pattern exclude_regex =  Pattern.compile(
			"" // exclude patterns that are like the following
			+ "(\\d+)\\.(\\d+)" // decimal numbers
			+ "[\\s" // white spaces (trailing, leading, in-between)
//			+ "\\d+\\s+?\\d+" // white spaces in-between digits

			+ ",,+" // removes any hanging commas (in the middle)
			+ "]");

	// TODO(@sach): utilize this method and combine the other regexes 
//	public boolean isNumeric(String strNum) {
//	    if (strNum == null) {
//		@TODO(@sach): change == to .equals
//	        return false; 
//	    }
//	    return pattern.matcher(strNum).matches();
//	}
	
//	TODO(@sach): implement me
	public boolean sanitize_(String input) {
//		use methods:
//			isNumeric
//			isEscapeCharacter
		// sort in a
 		try {
 			// add sanitisation logic here
 		}
 		catch(Exception e){
 			return false;
 		}
 		return false;
 		
	}
	
//	TODO(@sach): implement me
	public String sanitize(String input) {
//		use methods:
//			isNumeric
//			isEscapeCharacter
		// sort in a
 		try {
 		// input sanitisation
 			
 			// check that the input is not null
 			if (input == null) {
// 				TODO(@sach): change == to .equals
 				System.out.println("Invalid Input: null input");
// 				System.exit(0); // fix these panics
 			}
 			
 		// check that the input is not null
 			if (input == null) {
// 				TODO(@sach): change == to .equals
 				System.out.println("Invalid Input: null input");
// 				System.exit(0); // fix these panics
 			}
 			
 		// removes any non digit from string
 			input = input.replaceAll(include_regex.pattern(), "");
 			
 			// removes any .. from string
 			// remove all white spaces (trailing, leading, in-between)
// 			input = input.replaceAll("\\s","");
 			input = input.replaceAll(exclude_regex.pattern(), "");
 			
 			// removes any hanging commas (in the middle)
 			input = input.replaceAll(",,+", ",");
 			
 			// remove leading hanging comma
 			// TODO(@sach): use regex
 			if (input.startsWith(",")) {
 				input = input.substring(1);
 			}
 			
 			// remove trailing hanging comma
 			//TODO(@sach): use regex
 			if (input.endsWith(",")) {
 				input = input.substring(0, input.length());
 			}
 			
 			return input;
 			
 		}
 		catch(Exception e){
 			return null;
 		}
 		// something happened, shouldnt get here, address this 
 		
	}

	/**
	 * collect method explanation
	 * returns
	 */
	@Override
	public Collection<Integer> collect(String input) {

		// initialise/declare/instantiate output data structure
		// used ArrayList but we wouldnt be expecting any further values right?
		Collection<Integer> result = new ArrayList<Integer>();
		Integer tempInt =  Integer.valueOf(0);
	
		// input sanitisation
		input = sanitize(input);
		
		// spilt the input based on the delimiter ","
		String [] split_input = input.split(",");
		// convert all the elements of the array to Integer values
		for(String num : split_input) {
			// convert to integer
			try {
				// convert to int
				tempInt = Integer.valueOf(num);
			}
			catch(NumberFormatException ex){
				System.out.println("Invalid Input");
				System.exit(0); // fix these panics
			}						
			// remove duplicates
			if (result.contains(tempInt)){
				continue;
			}
			
			result.add(tempInt);
		}
		System.out.println(result);
		return result;
	}

	/**
	 * summarizeCollection method explanation
	 * returns
	 */
	@Override
	public String summarizeCollection(Collection<Integer> input) {
			ArrayList<Integer> arr = new ArrayList<>(input);
			
			// create a sorted list
			Collections.sort(arr);
			
			ArrayList<String> result = new ArrayList<>();
			
//			can you use a lambda expression here?
			  for (int i = 0; i < arr.size(); i++) {
			   Integer j = arr.get(i);
			   
			   if (i == arr.size()-1){
				   // what about the other toString way for integers?
			     result.add(Integer.toString(j));
			   }
			 
			   if ((i + 1 < arr.size()) && (j+1 != arr.get(i + 1))) {
			   result.add(Integer.toString(j));
			   } else {
			     Integer last = 0;
			     for (int z = i+1; z < arr.size(); z++) {
			       if (z+1 < arr.size() && (arr.get(z)+1 == arr.get(z + 1))) {
			         continue;
			       } else {
			         last = arr.get(z);
			      // extend the range of the last element in the result set
			         result.add(String.format("%s-%s", j, last));
			         i = z ;
			         z = arr.size();
			       }
			     }
			   }
			  }
				String string_result = "";
				for(String num_range : result) {
					string_result = string_result + num_range + ", ";
				};
				
				// trim last comma
				// use regex for this
				string_result = string_result.substring(0, string_result.length()-2);
				
//				System.out.println(string_result);
				return string_result;
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		NumberRangeSummarizer obj = new Demo();
		String input = "-1,-2,-3,6,7,8,12.4,13,,,,14,15,21,22,23,24,31";
		System.out.println(input);
		Collection<Integer> actual = obj.collect(input);
		System.out.println(obj.summarizeCollection(actual));
		System.out.println("Done");
	}

}
