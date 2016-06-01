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
		}
	    } finally {
		br.close();
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}


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


	//sortArrayリストのなかの単語とsa(ソート後の入力された文字)の一部と
	//一致するか調べる

	//正解の候補の単語を保存するArrayList
	ArrayList<String> answerArray = new ArrayList<String>();
	for(int r = 0; r < sortArray.size(); r++){
	    String w = sortArray.get(r);
	    String x = array.get(r);
	    int count = 0;//一致している文字数を保存
	    int cindex = 0;//wのi一つ前の文字で一致したsaの隣の場所を保存
	    if(w.length() <= sa.length()){
		for(int i = 0; i < w.length(); i++){
		    for(int j = cindex; j < 16; j++){
			if(w.charAt(i) == sa.charAt(j)){
			    count = count + 1;
			    cindex = j + 1;
			    break;
			}
		    }    
		}
		if(count == w.length()){
		    answerArray.add(x);	    
		}
	    }
	}
	//答えの候補の中から答えを表示
	String answer = "";
	for(int ii = 0; ii < answerArray.size(); ii++){
	    String f = answerArray.get(ii);
	    if(f.length() > answer.length()){
		answer = f;
		System.out.println(answer);
	    }
	}
	if(answer == ""){
	    System.out.println("作れる単語は存在しない");
	}else{
	    System.out.println("一番長い単語は「" + answer +"」");
	}
	
	
	

    }

    //与えられた配列(文字列)を辞書式にソートするメソッド
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
