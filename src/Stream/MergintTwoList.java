package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;

public class MergintTwoList {

	public static void main(String[] args) {
		// Requirement : merger two list
		List<String>names=Arrays.asList("Abhijeet","Rahul","pankaj","rohan","Ahan");
		
		List<String>name=Arrays.asList("Alok","mani","Jain","panku","joshep");
		
		Stream newstream=Stream.concat(names.stream(),name.stream());
		newstream.sorted().forEach(ele-> System.out.println(ele));
		// Requirement : see anymatch name present in the list
		
	boolean flag=newstream.anyMatch(ele->ele.equals("mani"));
		Assert.assertTrue(flag);
	}
}
