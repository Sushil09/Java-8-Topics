package com.sjsushil09.coreJava.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {
    public static void main(String[] args) {
      List<Integer> l2 = List.of(1,2,3,4,5,6,7);

       List<Integer> list =  new ArrayList<>();
       list.add(2);
       list.add(3);
       list.add(4);
       list.add(5);

//       for(int x:l2){
//           if(x%2==0)
//               System.out.println(x);
//       }
System.exit(0);
        List<Integer> filteredList = l2.stream().filter(i -> i%2==0).toList();
//        System.out.println(filteredList);

//        list.forEach(System.out::println);

        Stream<Integer> stream=l2.stream().map(i->{
            return i*i;
        });
        System.out.println(stream.collect(Collectors.toList()));

    }
}
