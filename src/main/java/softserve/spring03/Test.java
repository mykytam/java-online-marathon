package softserve.spring03;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        //First task
        int[][] arr = {
                { 1, 4 },
                { 1, 2, 3 },
                { 1, 2 },
                { 1, 3, 5 },
                { 1 },
                { 1, 1, 3 },
                {1}
        };
        Spring03Task01 test = new Spring03Task01();
        test.arrSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        //Second task
        List<String> originList= new ArrayList<>();
        originList.add("zz");
        originList.add("abc");
        originList.add("aa");
        originList.add("aaa");

        System.out.println(originList);
        Spring03Task02 newSorting = new Spring03Task02();
        System.out.println(newSorting.strSort(originList));

        //Third task
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("aa");
        list.add("cc");
        Map<String, String> map = new HashMap();
        map.put("1", "cc");
        map.put("2", "bb");
        map.put("3", "cc");
        map.put("4", "aa");
        map.put("5", "cc");
        Spring03Task03 compare = new Spring03Task03();
        compare.listMapCompare(list, map);

        //Fourth task
        Map<String, String> phones = new HashMap();
        phones.put("0967654321", "Petro");
        phones.put("0677654321", null);
        phones.put("0501234567", "Ivan");
        phones.put("0970011223", "Stepan");
        phones.put("0631234567", "Ivan");

        Spring03Task04 newMap = new Spring03Task04();
        System.out.println(newMap.createNotebook(phones));

        //Fifth task
        List<Spring03Task05.Student> list1 = new ArrayList<Spring03Task05.Student>();
        list1.add(new Spring03Task05.Student(1, "Ivan"));
        list1.add(new Spring03Task05.Student(2, "Petro"));
        list1.add(new Spring03Task05.Student(3, "Stepan"));
        List<Spring03Task05.Student> list2 = new ArrayList<Spring03Task05.Student>();
        list2.add(new Spring03Task05.Student(1, "Ivan"));
        list2.add(new Spring03Task05.Student(3, "Stepan"));
        list2.add(new Spring03Task05.Student(4, "Andriy"));
        Spring03Task05 testCommon = new Spring03Task05();
        testCommon.commonStudents(list1, list2);
    }
}
