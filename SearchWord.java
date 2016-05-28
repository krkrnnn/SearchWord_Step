import java.util.*;
import java.io.*;

public class SearchWord{
    public static void main(String[] args){

	List<String> array = new ArrayList<String>();
	array.add("a");
	array.add("x");
	array.add("1");
	array.add("b");
	array.add("3");
	Collections.sort(array);
	for (String string : array) {
	    System.out.println(string);
	}

	try {
	    BufferedReader br = new BufferedReader(new FileReader("/usr/share/dict/words"));
	    try {
		while (true) {
		    String line = br.readLine();
            if (line == null) {
                break;
            }
            Collections.sort(line);
	    System.out.println(line.toUpperCase());
		}
	    } finally {
		br.close();
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	Scanner sc = new Scanner(System.in);
	System.out.println("16文字のアルファベットを入力してください");
	//入力された文字を配列に追加する
	String a[] = new String[16];

	for(int i = 0; i < 16; i++){
	    String n = sc.next();
	    a[i] = n;
	}
	//入力された文字列の配列を辞書順にソートする
	sort(a);
	//ソートした中身をStringにいれる
	String sa = "";
	for(int i = 0; i < 16; i++){
	    sa = sa + a[i];
	}
	System.out.println(sa);


	
    }

    //与えられた配列(文字列)を辞書式にソートするクラス
    public static void sort(String[] a){
	String tmp = "";
	for(int i = 0; i < 15; i++){
	    for(int j = 15; j > i; j--){
		if(a[j-1].compareTo(a[j]) > 0){
		    tmp = a[j];
		    a[j] = a[j - 1];
		    a[j - 1] =  tmp;
		}
	    }
	}
    }
}
