package Stream;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollect {

	public static void main(String[] args) {
		List<String>ls=Stream.of("Abhijeet","Rahul","pankaj","rohan","Ahan").filter(ele-> ele.endsWith("n")).map(ele->ele.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls.get(0));
	}

}
