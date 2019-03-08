package com.season1.concurrency.chapter1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Main
{
    public static void main(String[] args) {
    /*   Bean a=new Bean();
        Bean b=new Bean();
        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println(-2&-6);*/
     Map a=new HashMap();
        a.put("a","1");
        a.put("b","2");
        a.put("c","2");
        a.put("d","3");
        List<Map> flist=new ArrayList<>();
        flist.add(a);
        flist.add(a);
        get(flist,"a,1");



        Map<String, String> m1 = new HashMap<String, String>()
        {
            {
                put("x", "x");
                put("y", "y");
                put("z", "z");
            }
        };

        Map<String, String> m2 = new HashMap<String, String>()
        {
            {
                put("x", "x1");
                put("y", "y1");
                put("z", "z1");

            }
        };
        Map<String, String> m3 = new HashMap<String, String>()
        {
            {
                put("x", "x1");
                put("y", "y1");
                put("z", "z1");
            }
        };

/*        Map<String, String> a=new HashMap<String, String>();
        a.put("a","1");
        a.put("b","2");
        a.put("c","2");
        a.put("d","3");
        List<Map<String, String>> list=new ArrayList<>();
        list.add(a);
        list.add(a);*/
        String t="x";
        List<Map<String, String>> list = Arrays.asList(m1,m2,m3);
        List<Map.Entry<String,String>> keys = new ArrayList<>();

      //  list.stream().map(Map::entrySet).forEach(keys::addAll);
        list.stream().map(Map::entrySet).forEach(keys::addAll);
        System.out.println(keys);
        System.out.println(keys.stream()
                .collect(Collectors.groupingBy(e -> e.getKey(), toList())));
        final List<Map.Entry<String, String>> x = keys.stream()
                .collect(Collectors.groupingBy(e -> e.getKey(), toList())).get(t);
        System.out.println(x);
       /* Map<String, Long> result = x
                .stream().map(Map.Entry::getValue).collect(Collectors.groupingBy(Function.identity(), counting()));*/

      /* Map<String, Long> result = list.stream().map(Map::entrySet)
                .collect(ArrayList<Map.Entry<String, String>>::new, ArrayList::addAll, ArrayList::addAll)
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getKey, toList())).get("a")
                .stream().map(Map.Entry::getValue).collect(Collectors.groupingBy(Function.identity(), counting()));*/




      //  System.out.println(result);

    }

    private static void get(List<Map> flist, String ...s)
    {
        List<Map> result=new ArrayList<>();

        for (String st:s)
        {
            String starr[]=st.split(",");
            result= flist.stream().filter(map -> map.get(starr[0]).equals(starr[1]) ).collect(Collectors.toList());

        }
        System.out.println(result);
    }
}
