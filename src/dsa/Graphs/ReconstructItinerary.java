package dsa.Graphs;/*
Reconstruct Itinerary

You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]
 */

import java.util.*;

public class ReconstructItinerary {

    static public List<String> findItinerary(List<List<String>> tickets, HashMap<String, PriorityQueue<String>> map,
                                             LinkedList<String> result) {
        for(List<String> list: tickets) {
            if(!map.containsKey(list.get(0))) {
                PriorityQueue q = new PriorityQueue<>();
                map.put(list.get(0), q);
            }
            map.get(list.get(0)).offer(list.get(1));
        }
        dfs("JFK", map, result);
        return result;
    }

    static void dfs(String s,HashMap<String, PriorityQueue<String>> map,
                    LinkedList<String> result) {
        PriorityQueue<String> q = map.get(s);
        while (q != null && !q.isEmpty()) {
            dfs(q.poll(), map, result);
        }
        result.addFirst(s);
    }

    public static void main(String[] args) {
        HashMap<String, PriorityQueue<String>> map1 = new HashMap<>();
        LinkedList<String> result1 = new LinkedList<>();
        List<List<String>> tickets = new ArrayList<>(){{
                                  add(new ArrayList(){{add("MUC");add("LHR");}});
                                  add(new ArrayList(){{add("JFK");add("MUC");}});
                                  add(new ArrayList(){{add("SFO");add("SJC");}});
                                  add(new ArrayList(){{add("LHR");add("SFO");}});}};
        System.out.println(findItinerary(tickets, map1, result1).toString());

        HashMap<String, PriorityQueue<String>> map2 = new HashMap<>();
        LinkedList<String> result2 = new LinkedList<>();
        List<List<String>> tickets2 = new ArrayList<>(){{
            add(new ArrayList(){{add("JFK");add("SFO");}});
            add(new ArrayList(){{add("JFK");add("ATL");}});
            add(new ArrayList(){{add("SFO");add("ATL");}});
            add(new ArrayList(){{add("ATL");add("JFK");}});
            add(new ArrayList(){{add("ATL");add("SFO");}});}};
        System.out.println(findItinerary(tickets2, map2, result2).toString());
    }
}