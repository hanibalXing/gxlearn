package com.gx.equals;

import java.util.Objects;

/**
 * @author gx
 * @ClassName: Test
 * @Description: java类作用描述
 * @date 2019/2/11 15:37
 * @Version: 1.0
 * @since
 */
public class Test {
    public static void main(String[] args) {
        Person a=new Person(12,"gx");
        Person b=new Person(12,"gx");
        Person c=new Person(13,"gzh");
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a==b);
        a=c;
        b=c;
        System.out.println(a==b);

        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
        String str3 ="gx";
        String str4 ="gx";
        System.out.println(str3==str4);
        System.out.println(str3.equals(str4));



    }
    private static class Person{
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {

            return Objects.hash(age, name);
        }
    }
}
