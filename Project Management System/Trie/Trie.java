package Trie;

import java.util.ArrayList;
public class Trie<T> implements TrieInterface {
private TrieNode root=new TrieNode(0);

    @Override
    public boolean delete(String word) {

        if(word==null || root==null){
        
            return false;
        }
        TrieNode y=search(word);
if(y==null){
    return false;
}
boolean x=delrec(word,root,0);
  //  System.out.println(y!=null? "DELETED":"ERROR DELETING");
    return !x;
}


private boolean haschild(TrieNode node){
int x=node.a.length;
    for(int i=0;i<x;i++){
        if(node.a[i]!=null){
            return true;
        }
    } return false;
}

private boolean delrec(String word,TrieNode node,int level){
boolean d=false;
if(root==null){
    return d;
}


if(word.length()==level){

if(haschild(node)){
    node.isEndofWord=false;
    d=true;
}
else
{
        node=null;
        d=true;
}
}
else
{
    int index =word.charAt(level)-32;
TrieNode c=null;
if(node!=null)c=node.a[index];
if(c==null)return false;
boolean cd=delrec(word,c,level+1);
if(cd==true)
{
    node.a[index]=null;
    if(node.isEndofWord){
        d=false;
    }else if (haschild(node))
    {
        d=false;
    }else
     {
        node=null;
        d=true;
    }

}
else {
        d=false;
    }
}
 return d;
}

    @Override
    public TrieNode search(String word) {
     TrieNode p=root;
     for(int i=0;i<word.length();i++){
        int index=word.charAt(i)-32;
        if(p.a[index]==null){
            return null;
        }else 
        p=p.a[index];
     }if(p==root){
  return null;}
return p;    
}

    @Override
    public TrieNode startsWith(String prefix) {
         TrieNode p=root;
     for(int i=0;i<prefix.length();i++){
        int index=prefix.charAt(i)-32;
        if(p.a[index]==null){
            return null;
        }else 
        p=p.a[index];
     }
     if(p==root){
  return null;
}
        return p;    
    }

    @Override
    public void printTrie(TrieNode trieNode) {
        pt(trieNode);
    }

    public void pt(TrieNode node){
if(node.isEndofWord){
    System.out.println(node.getValue());
}

for(int i=0;i<94;i++){
    if(node.a[i]!=null){
    pt(node.a[i]);
    }
}

    }

    @Override
    public boolean insert(String word, Object value) {
     TrieNode p=root;
     int i=0;
     int index=0;
     //boolean x=false;
     int level=1;
     for(i=0;i<word.length();i++){
        index= word.charAt(i)-32;
        if(p.a[index]==null){
            p.a[index]=new TrieNode(level);
        }p=p.a[index];
level++;
     }if(p.isEndofWord){
        return false;
     } 
      if(i==word.length()){
            p.isEndofWord=true;
            p.setValue(value);
        }   
     return true;
    }


private  ArrayList<Character> a=new ArrayList<Character>();
    @Override
    public void printLevel(int level) {
      a.removeAll(a);
pl(root,a,level);
int n=a.size();
  for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
      if(a.get(i)>a.get(j)){
        char temp=a.get(i);
        a.set(i,a.get(j));
        a.set(j,temp);
        }
    }
    }
System.out.print("Level "+level+": ");
    for(int z=0;z<n;z++){
        char ch=a.get(z);
        if(ch!=' '){
        if(z!=n-1){
     System.out.print(ch+",");
    }else System.out.print(ch);
}
}System.out.println();
    }

public void pl(TrieNode node,ArrayList<Character> c,int level){
    if(node.index==level){
        return ;
    }
    if(node.index==level-1){
        for(int i=0;i<94;i++){
            if(node.a[i]!=null){
                c.add((char)(i+32));
            }
        }
    }
    for(int i=0;i<94;i++){
        if(node.a[i]!=null){
            pl(node.a[i],c,level);
        }
    }
}


    @Override
    public void print() {
int level=1;
System.out.println("-------------"+"\n"+"Printing Trie");
while(true){
    
    printLevel(level);
    if(a.isEmpty()){
    // System.out.println();
     break;
    }level++;
}System.out.println("-------------");
}

private void dfprint(TrieNode node,ArrayList<Character> s,int level){

    if(node.isEndofWord){
int j=level;
while(j<s.size()){
s.remove(s.size()-1);
level++;
}
        //CLEAR
    //      System.out.println("JIJI");
        for(int i=0;i<s.size();i++){
            System.out.print(s.get(i));
        }System.out.println();
    }
    for(int i=0;i<94;i++){
        if(node.a[i]!=null){
s.add(level,(char)(i+32));
dfprint(node.a[i],s,level+1);
        }
    }

}
}