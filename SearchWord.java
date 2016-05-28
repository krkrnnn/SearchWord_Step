import java.util.*;
import java.io.*;

public class SearchWord{
    public static void main(String[] args){

	//辞書の単語を保存するArrayList
	ArrayList<String> array = new ArrayList<String>();
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

	try {
	    BufferedReader br = new BufferedReader(new FileReader("/usr/share/dict/words"));
	    try {
	    while (true) {
		    String line = br.readLine();
		    //listに辞書の単語を追加
		    array.add(line);
            if (line == null) {
                break;
            }
	    //System.out.println(line.toUpperCase());
		}
	    } finally {
		br.close();
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}

	//辞書を格納したリストの中身の確認
	/*for(int i = 0; i < array.size()-1; i++){
	    String country = array.get(i);
	    System.out.println(country);
	    }*/

	//リストの中身をアルファベット順にソートしたリスト
	ArrayList<String> sortArray = new ArrayList<String>();
	//String b = "";
	int l = 0;
	for(int i = 0; i < array.size()-1; i++){

	    //listの中身の文字列を取り出す
	    String word = array.get(i);
	    //取り出した単語の大きさ
	    l = word.length();
	    String[] wordArray = new String[l];
	    for (int p = 0; p < l; p++) {
		//lineの先頭から1文字ずつString型にして取り出す
		String m = String.valueOf(word.charAt(p));
		//配列に順番に格納する
		wordArray[p] = m;
	    }
	    sort(wordArray);
	    String sb = "";
	    for(int q = 0; q < l; q++){
		sb = sb + wordArray[q];
	    }
	    sortArray.add(sb);
	    
	}

	//辞書を格納したリストの中身の確認
	for(int h = 0; h < sortArray.size()-1; h++){
	    String country = sortArray.get(h);
	    System.out.println(country);
	}
	
	

    }

    //与えられた配列(文字列)を辞書式にソートするクラス
 public static void sort(String[] a){
	String tmp = "";
	for(int i = 0; i < a.length - 1; i++){
	    for(int j = a.length - 1; j > i; j--){
		if(a[j-1].compareTo(a[j]) > 0){
		    tmp = a[j];
		    a[j] = a[j - 1];
		    a[j - 1] =  tmp;
		}
	    }
	}
    }
}
