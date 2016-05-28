import java.util.*;

public class SearchWord{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.println("16文字のアルファベットを入力してください");
	//入力された文字を配列に追加する
	String a[] = new String[16];
	//ソート後を保存する文字列
	//String b[] = new Stirng[16];
	for(int i = 0; i < 16; i++){
	    String n = sc.next();
	    a[i] = n;
	    System.out.println(a[i]);
	}
	//入力された文字列の配列を辞書順にソートする
	sort(a);

	//ソート後の中身を確認
	System.out.println("ソート後の中身は");
	for(int i = 0; i < 16; i++){
	    System.out.println(a[i]);
	}
	
	
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
