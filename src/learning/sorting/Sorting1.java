package learning.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting1 {

    public static void main(String[] args){
        List<Person> listPerson = new ArrayList<>();
        Person person1 = new Person("Britta", 11);
        Person person2 = new Person("Hilke", 11);
        Person person3 = new Person("Thomas",11);
        Person person4 = new Person("Andres", 11);

        listPerson.add(person1);
        listPerson.add(person2);
        listPerson.add(person3);
        listPerson.add(person4);

        System.out.println("List persons");
        System.out.println(listPerson);

        List<Person> listSorted = listPerson.stream().sorted(Comparator.comparing(p->p.getName())).collect(Collectors.toList());

        System.out.println("List sorted");
        System.out.println(listSorted);

        System.out.println("original");
        System.out.println(listPerson);

        Collections.sort(listPerson,(name1, name2)->{
            return name1.getName().compareTo(name2.getName());
        });

        System.out.println("List person modified");
        System.out.println(listPerson);


    }
}
