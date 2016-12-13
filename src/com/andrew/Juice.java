package com.andrew;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Andrey on 03.12.2016.
 */
class Juice {
    private String[] components;

    public String[] getComponents() {
        return components;
    }

    public String[] getSortComponents() {
        Arrays.sort(components);
        return components;
    }

    void setComponents(String components) {
        StringTokenizer stringTokenizer = new StringTokenizer(components, " ,");
        this.components = new String[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            this.components[i] = stringTokenizer.nextToken();
            i++;
        }

    }

    void print() {
        for (String s : components)
            System.out.print(s + " ");
        System.out.println();
    }


}
