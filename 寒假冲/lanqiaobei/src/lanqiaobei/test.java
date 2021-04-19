package lanqiaobei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class test {
	public static void main(String[] args) {
       Map<String,Integer> map = new HashMap();		
       map.put("United",1);
       map.put("Germany", 49);
       map.put("France",33);
       map.put("China",86);
       map.put("Pakistan",92);
//       
//       //∞¥’’º¸≈≈–Ú
//       Map<String,Integer> res = map.entrySet().stream()
//           .sorted(Map.Entry.comparingByValue())
//           .collect(
//        		   Collectors.toMap(
//        				   Map.Entry::getKey,
//        				   Map.Entry::getValue,
//        				   (oldVal,newVal) -> oldVal,
//        				   LinkedHashMap::new)
//        		   );
//       res.entrySet().forEach(System.out::println);
		Map<String,Integer> res = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(
						Collectors.toMap(
								Map.Entry::getKey,
								Map.Entry::getValue,
								(oldVal,newVal) -> oldVal,
								LinkedHashMap::new)
						);
		
//		map.merge("United", 2, (oldVal,newVal)->oldVal+newVal);
		
//		System.out.println(map.get("United"));
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "Mahesh", 12));
		list.add(new Student(2, "Suresh", 15));
		list.add(new Student(3, "Nilesh", 10));
//		list.sort((o1,o2)->o1.getAge()-o2.getAge());
//		list.sort(Comparator.comparing(Student::getAge));
		
		System.out.println(list);
//		List<Integer> list = new ArrayList();
//		list.add(1);
//		list.add(5);
//		list.add(3);
//		list.add(2);
//		Collections.sort(list,Comparator.comparingInt(Integer::intValue));
//		System.out.println(Arrays.toString(list.toArray()));
//		List<Student> res = list.stream().sorted(Comparator.comparing(
//				Student::getAge,(s1,s2)->{return s1-s2;}))
//		        .collect(Collectors.toList());
//		res.forEach(System.out::println);
//		list.stream().sorted(Comparator.comparing(
//				Student::getAge,(s1,s2)->{return s1-s2;}))
//		.collect(Collectors.toList());
		
		HashSet<String> set = new HashSet();
		set.add("aaaakk");
		set.add("eeee12212");
		set.add("bbbb");
	    List<String> qq= set.stream().sorted(Comparator.comparing(String::length))
	         .collect(
	        		 Collectors.toList());
	    for(String str:qq)
	    	System.out.println(str);
	}
}
