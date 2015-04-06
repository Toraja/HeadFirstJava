// the most recent full moon was on Jan 7th 2004
//
// output
// full moon on Fri Feb ....
// full moon on Sat Mar ....
// full moon on Mon Apr ....

import static java.lang.System.out;
import java.io.*;
import java.util.*;

class FullMoons{

	static int DAY_IN = 1000 * 60 * 60 * 24;
	
	public static void main(String[] args){
	
		Calendar c = Calendar.getInstance();
		c.set(2004,0,7,15,40);

		long day1 = c.getTimeInMillis();
				
		for(int x = 0; x < 60; x++){
			day1 += (DAY_IN * 29.52);
			c.setTimeInMillis(day1);
			out.println(String.format("full moon on %tc", c));		
		}
	}
}	
