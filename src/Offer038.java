import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer038 {

    List<String> list;
    boolean[] vist;

    public String[] permutation(String s) {
        int n = s.length();
        list = new ArrayList<String>();
        vist = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        StringBuffer perm = new StringBuffer();
        backtrack(arr, 0, n, perm);
        int size = list.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = list.get(i);
        }
        return recArr;
    }


    public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        if(i == n){
            list.add(perm.toString());
            return;
        }

        for(int j = 0; j < n; j++){
            if(vist[j] == true|| (j > 0 &&!vist[j - 1] && arr[j - 1] == arr[j])){
                continue;
            }


            vist[j]= true;
            perm.append(arr[j]);
            backtrack(arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            vist[j] = false;

        }
    }

}
