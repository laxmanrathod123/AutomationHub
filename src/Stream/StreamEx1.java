package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class StreamEx1 {
	
	public void Streamex() {
		// Requirement
		// print the count of the letter start with Alphabet A

		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Jeetu");
		names.add("Akash");
		names.add("Alok");
		names.add("Nivan");
		names.add("Rani");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			if (name.startsWith("A")) {
				count++;
			}
        }
		System.out.println("count of the letter A :" + count);
       }
	
	public void StreamMethod() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Jeetu");
		names.add("Akash");
		names.add("Alok");
		names.add("Nivan");
		names.add("Rani");
		
		Long l=names.stream().filter(ele-> ele.startsWith("A")).count();
		System.out.println(l);
		System.out.println();
		
		Long d=Stream.of("Abhijeet","Rahul","pankaj").filter(ele->{
			ele.startsWith("A");
			return true;
		}).count();
		System.out.println(d);
		
		Stream.of("Abhijeet","Rahul","pankaj","rohan","Ahan").filter(ele->ele.length()>4).forEach(ele->System.out.println(ele));
	}
	
	public void streamwithUppercase() {
		// Requirement print the name which end with letter n and map with uppercase
		Stream.of("Abhijeet","Rahul","pankaj","rohan","Ahan").filter(ele-> ele.endsWith("n")).map(ele->ele.toUpperCase())
		.forEach(ele->System.out.println(ele));
	}
		
	public void streamwithSortedUppercase() {
		//Requirement: print the name start with letter A do the sorting and map with uppercase
		List<String>names=Arrays.asList("Abhijeet","Rahul","pankaj","rohan","Ahan");
		names.stream().filter(ele->ele.startsWith("A")).sorted().map(ele->ele.toUpperCase()).
		forEach(ele-> System.out.println(ele));
	}
	

	public static void main(String[] args) {
		StreamEx1 obj= new StreamEx1();
		obj.Streamex();
		obj.StreamMethod();
		obj.streamwithUppercase();
		obj.streamwithSortedUppercase();
	}
}
