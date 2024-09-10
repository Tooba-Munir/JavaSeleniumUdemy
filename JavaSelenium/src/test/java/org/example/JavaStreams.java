package org.example;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

public class JavaStreams {
    @Test
    public void testStream(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Apricot");
        list.add("Egg");
        list.stream().filter(a->a.startsWith("A")).forEach(a-> {
            System.out.println(a);
        });
        Stream<String> modifiedList = list.stream().sorted().map(s -> s.toUpperCase());
        modifiedList.forEach(a->System.out.println(a));

    }

}
