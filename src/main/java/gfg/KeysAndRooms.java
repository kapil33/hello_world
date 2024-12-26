package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {
    private void dfs(List<List<Integer>> rooms, boolean[] visited, int i) {
        if(visited[i])
            return;
        visited[i] = true;

        for(int key: rooms.get(i)) {
            dfs(rooms, visited, key);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        dfs(rooms, visited, 0);

        for(int i=0; i<n; i++) {
            if(!visited[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        KeysAndRooms kr = new KeysAndRooms();
        List<List<Integer>> rooms = Arrays.asList(
                Arrays.asList(1,3), Arrays.asList(3,0,1), Arrays.asList(2), Arrays.asList(0));
        System.out.println(kr.canVisitAllRooms(rooms));
    }
}
