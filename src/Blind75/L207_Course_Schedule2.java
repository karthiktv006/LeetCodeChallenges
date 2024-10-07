package Blind75;

import Helper.L207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class L207_Course_Schedule2 {
    static HashMap<Integer, ArrayList<Integer>> map;
    static HashSet<Integer> visited = new HashSet<>();
    public static void main(String[] args) {
        int[][] prerequisites = L207.tc5();

        System.out.println("res: " + canFinish(8, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int numCourse = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            if (map.get(numCourse) == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(preCourse);
                map.put(numCourse, list);
            } else {
                ArrayList<Integer> list = map.get(numCourse);
                list.add(preCourse);
            }
        }

        System.out.println(map);

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;

    }

    public static boolean dfs(int course) {
        if (map.get(course) == null) return true;
        if (!visited.isEmpty() && visited.contains(course)) return false;
        visited.add(course);
        for (int pre : map.get(course)) {
            if (dfs(pre)) {
                map.put(pre, null);
            } else {
                return false;
            }
        }
        visited.remove(course);
        map.put(course, null);
        return true;
    }
}
