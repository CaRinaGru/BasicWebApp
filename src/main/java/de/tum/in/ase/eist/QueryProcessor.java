package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
            return "CaRina";
        } else if (query.contains("chicken")) { // TODO extend the programm here
            return "I love nuggets!";
        } else if (query.contains("plus")) {
            String[] words = query.split(" ");
            int result = Integer.parseInt(words[2]) + Integer.parseInt(words[4]);
            return "" + result;
        } else if (query.contains("largest")) {
            String[] words = query.split(":");
            String[] words2 = words[1].split(",");
            int x = 0;
            for (int i = 0; i < words2.length; i++) {
                if (Integer.parseInt(words2[i].trim()) > x) {
                    x = Integer.parseInt(words2[i].trim());
                }
            }
            return "" + x;
        } else {
            return "";
        }
    }
}
