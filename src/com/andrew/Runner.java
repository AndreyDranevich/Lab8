package com.andrew;

import java.io.IOException;
import java.util.*;

/**
 * Created by Andrey on 03.12.2016.
 */

public class Runner {
    public static void main(String[] args) throws IOException {
        List<String> list = Reader.readFile("juice.in");
        List<Juice> listJuice = readInClass(list);
        List<String> listAllComponents = readAllComponents(list);
        onDifferentComponents(listAllComponents);
        countOfWashes(listJuice);

    }

    private static List<Juice> readInClass(List<String> list) throws IOException {
        List<Juice> listJuice = new ArrayList<>();

        for (String s : list) {
            Juice juice = new Juice();
            juice.setComponents(s);
            listJuice.add(juice);
        }

        return listJuice;
    }

    private static List<String> readAllComponents(List<String> list) {
        List<String> components = new ArrayList<>();
        for (String s : list) {
            StringTokenizer stringTokenizer = new StringTokenizer(s, " ,");
            while (stringTokenizer.hasMoreTokens()) {
                components.add(stringTokenizer.nextToken());
            }
        }
        return components;
    }

    private static void onDifferentComponents(List<String> list) throws IOException {
        Set<String> set = new LinkedHashSet<>(list);
        Reader.writeFileSet("juice1.out", set);
        Set<String> sortedSet = new TreeSet<String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        sortedSet.addAll(set);
        Reader.writeFileSet("juice2.out", sortedSet);
    }

    private static void countOfWashes(List<Juice> juiceList)throws IOException {
        int count = 0;

        Collections.sort(juiceList, new Comparator<Juice>() {
            @Override
            public int compare(Juice o1, Juice o2) {
                return -1*Arrays.toString(o1.getSortComponents()).compareTo(Arrays.toString(o2.getSortComponents()));
            }
        });
        for (int i = 0; i < juiceList.size() - 1; i++) {
            if (isNeedWashes(juiceList.get(i).getComponents(), juiceList.get(i + 1).getComponents())) {
                count++;
            }
        }
        count++;
        Reader.writeFileStr("juice3.out", count + "");
    }
    private static boolean isNeedWashes(String[] a, String[] b) {
        int count = 0;
        for (String A : a) {
            for (String B : b) {
                if (A.equals(B))
                    count++;
            }
        }
        return count != a.length;
    }


}
