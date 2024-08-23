package LogicalThinking;

import java.util.*;
public class ContainVirus {
    static int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    static class Region {
        Set<Integer> infected = new HashSet<>();
        Set<Integer> unInfected = new HashSet<>();
        
        int walls = 0;
    }
    
    public static int containVirus(int[][] isInfected) {
        int ans = 0;
        int row = isInfected.length;
        int col = isInfected[0].length;
        
        while(true) {
            List<Region> holder = new ArrayList<>();
            boolean[][] visited = new boolean[row][col];
            
            for(int i=0;i<row;i++) {
                for(int j=0;j<col;j++) {
                    if(isInfected[i][j] == 1 && !visited[i][j]) {
                        Region region = new Region();
                        getRegion(isInfected, region, row, col, visited, i, j);
                        holder.add(region);
                    }
                }
            }
            
            int indexOfMaxUnInfected = 0;
            int sizeofMaxUnInfected = 0;
            
            for(int i=0;i<holder.size();i++) {
                Region region = holder.get(i);
                if(region.unInfected.size() > sizeofMaxUnInfected) {
                    sizeofMaxUnInfected = region.unInfected.size();
                    indexOfMaxUnInfected = i;
                }
            }
            
            if(holder.size() == 0) break;
            
            Set<Integer> maxSet = holder.get(indexOfMaxUnInfected).infected;
            for(int rowCol : maxSet) {
                int r = rowCol / col;
                int c = rowCol % col;
                isInfected[r][c] = 2;
            }
            
            ans += holder.get(indexOfMaxUnInfected).walls;
            for(int i=0;i<holder.size();i++) {
                
                if(i == indexOfMaxUnInfected) {
                    continue;
                }
                
                Region region = holder.get(i);
                Set<Integer> unInfected = region.unInfected;
                
                for(int rowCol : unInfected) {
                    int r = rowCol / col;
                    int c = rowCol % col;
                    
                    isInfected[r][c] = 1;
                }
            }
        }
        
        return ans;
    }
    
    public static void getRegion(int[][] isInfected, Region region, int row, int col, boolean[][] visited, int i, int j) {
        if(i < 0 || j < 0 || i == row || j == col || isInfected[i][j] == 2) return;
        
        if(isInfected[i][j] == 1) {
            if(visited[i][j]) return;
            region.infected.add(i * col + j);
        }
        
        if(isInfected[i][j] == 0) {
            region.unInfected.add(i * col + j);
            region.walls++;
            return;
        }
        
        visited[i][j] = true;
        for(int[] dir : dirs) {
            getRegion(isInfected, region, row, col, visited, i + dir[0], j + dir[1]);
        }
    }
    
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().replaceAll("[\\[\\[]", "").split("],");
        int[][] arr = new int[s.length][];
        for(int i=0;i<s.length;i++) {
            String x[] = s[i].replaceAll("[\\[\\]]", "").split(",");
            arr[i] = new int[x.length];
            for(int j=0;j<x.length;j++)
                arr[i][j] = Integer.parseInt(x[j].trim());
            // System.out.println(Arrays.toString(arr[i]));
        }
        
        int walls = containVirus(arr);
        System.out.println(walls);

        sc.close();
    }
}