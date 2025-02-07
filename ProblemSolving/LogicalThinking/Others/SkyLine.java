package LogicalThinking.Others;

import java.util.*;

public class SkyLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().replaceAll("[\\[]", "").split("],");
        int[][] arr = new int[s.length][];
        for (int i = 0; i < s.length; i++) {
            String[] x = s[i].replaceAll("[^0-9]", " ").replaceAll("\\s+", " ").trim().split(" ");
            arr[i] = new int[x.length];
            for (int j = 0; j < x.length; j++) {
                arr[i][j] = Integer.parseInt(x[j].trim());
            }
        }

        List<List<Integer>> result = getSkyLine(arr);
        System.out.println(result.toString().replaceAll("\\s+", ""));

        sc.close();
    }

    public static List<List<Integer>> getSkyLine(int[][] arr) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> height = new ArrayList<>();

        for (int[] x : arr) {
            height.add(Arrays.asList(x[0], -x[2]));
            height.add(Arrays.asList(x[1], x[2]));
        }

        Collections.sort(height, (A, B) -> {
            if (!A.get(0).equals(B.get(0))) {
                return A.get(0) - B.get(0);
            }
            return A.get(1) - B.get(1);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(0);
        int prevHeight = 0;

        for (List<Integer> h : height) {
            int x = h.get(0);
            int y = h.get(1);

            if (y < 0) {
                pq.offer(-y); 
            } else {
                pq.remove(y);
            }

            int currentHeight = pq.peek();

            if (currentHeight != prevHeight) {
                result.add(Arrays.asList(x, currentHeight)); 
                prevHeight = currentHeight;
            }
        }

        return result;
    }
}
