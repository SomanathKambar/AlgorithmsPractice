package HackerEarth;

import java.util.HashMap;
import java.util.Scanner;

public class FindFavouriteSinger {

    public static void main(String[] args) {
        findFav();
    }

    public static void findFav() {
        Scanner sc = new Scanner(System.in);
        HashMap<Long,Integer> map = new HashMap<>();
        int n = sc.nextInt();
        long maxo=0,result=0;
        for(int i=0;i<n;i++){
            long a = sc.nextLong();
            map.put(a,map.getOrDefault(a,0)+1);
            maxo = Math.max(maxo,map.get(a));
        }
        for(Long i:map.keySet()){
            if(map.get(i)==maxo){
                result++;             }
        }
        System.out.println(result);
    }

    public static void findMaxBoarder(){
        String s = "";

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next().toCharArray();
            }
            System.out.println(maxBorder(n, m, arr));
        }
        sc.close();
    }
    private static int maxBorder(int n, int m, char[][] arr) {
        int[] rowMax = new int[n]; int[] colMax = new int[m];
        for (int i = 0; i < n; i++) { int curr = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '#') {
                    curr += 1;
                } else {
                    curr = 0;
                }
                rowMax[i] = Math.max(rowMax[i], curr);
            }
        }
        for (int j = 0; j < m; j++) {
            int curr = 0; for (int i = 0; i < n; i++) {
                if (arr[i][j] == '#') {
                    curr += 1;
                } else {
                    curr = 0;
                }
                colMax[j] = Math.max(colMax[j], curr);
            }
        }
        int max = 0,max1=rowMax[0],max2=colMax[0];
        for (int x = 1; x < n; x++){
            if(rowMax[x]>max1){
                max1=rowMax[x];
            }
        }
        for (int y = 1; y < m; y++){
            if(colMax[y]>max2){
                max2=colMax[y];
            }
        }
        max=Math.max(max1,max2);
        return max;
    }
}
