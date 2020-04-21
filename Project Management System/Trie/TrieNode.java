package Trie;
import java.util.ArrayList;
import Util.NodeInterface;


public class TrieNode<T>  {
public	TrieNode[] a;
	public boolean isEndofWord;
	private T value;
public int index;
public TrieNode(int index){
	this.a=new TrieNode[94];
	/*for(int i=0;i<94;i++){
		a[i]=null;
	}*/
	this.index=index;
	isEndofWord=false;
}

public TrieNode(T value){
	this.a=new TrieNode[94];
	isEndofWord=false;
	this.value=value;
}
public void setValue(T value){
	this.value=value;
}


/*public void printArray(){
for(int i=0;i<a.size();i++){
if(a[i]!=null){
	int j=32+i;
	char c=(char)(j+'0');
}
}
}*/

    public T getValue() {
        return value;
    }


}