package com.sumedhbajra;

import java.util.HashMap;
import java.util.Map;

public class MapProgram  {

    public static void main(String[] args) {
        Map<String, String> languages = getStringStringMap();

        System.out.println(languages.get("Java"));



        if(languages.containsKey("Java")) {
            System.out.println("Java is already in the map.");
        }

        System.out.println("================================================");
        System.out.println(languages.keySet());

      boolean isReplaced = languages.replace("Lisp", "Therein lies madness", "New Definition");
      if(isReplaced) {
          System.out.println("Replacement successful.");
      } else {
          System.out.println("Replacement failed.");
      }

        if(languages.remove("Algol", "a family pf algorithmic languages")) {
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed, key/value pair not found");
        }
//        boolean lispRemoved = languages.remove("lisp", "");
        for(String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }

    private static Map<String, String> getStringStringMap() {
        Map<String, String> languages = new HashMap<>();

        languages.put("Java", "a compiled high level, " +
                "object-oriented, platform independent language");

        languages.put("Python", "an interpreted, object-oriented, " +
                "high-level programming language with dynamic semantics");

        languages.put("Algol", "ad algorithmic language");

        languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code");
        languages.put("Lisp", "Therein lies madness");
        return languages;
    }
}
