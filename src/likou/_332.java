package likou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :lhy
 * @description : 重新安排行程
 * @date :2023/04/23 下午 08:21
 */
public class _332 {
    static LinkedList<String> result;
    static LinkedList<String> path = new LinkedList<>();
    public static void main(String[] args) {

        List<List<String>> tickets =new ArrayList<>();
        for(int i=0;i<4;i++){
            tickets.add(new LinkedList<>());
        }
        tickets.get(0).add("MUC");
        tickets.get(0).add("LHR");
        tickets.get(1).add("JFK");
        tickets.get(1).add("MUC");
        tickets.get(2).add("SFO");
        tickets.get(2).add("SJC");
        tickets.get(3).add("LHR");
        tickets.get(3).add("SFO");

        List<String> itinerary = findItinerary(tickets);
        System.out.println(itinerary.toString());
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        path.add("JFK");
        boolean[] used = new boolean[tickets.size()];
        backtracking((ArrayList) tickets, used);
        return result;
    }

    public static boolean backtracking(ArrayList<List<String>> tickets, boolean[] used) {
        if (path.size() == tickets.size() + 1) {
            result = new LinkedList(path);
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if (!used[i] && tickets.get(i).get(0).equals(path.getLast())) {
                path.add(tickets.get(i).get(1));
                used[i] = true;

                if (backtracking(tickets, used)) {
                    return true;
                }

                used[i] = false;
                path.removeLast();
            }
        }
        return false;
    }
}
