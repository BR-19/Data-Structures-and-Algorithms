package RedBlack;
import java.util.ArrayList;
import Util.RBNodeInterface;

import java.util.List;

public class RedBlackNode<T extends Comparable, E> implements RBNodeInterface<E> {

RedBlackNode left,right,parent;
boolean color;
int height;
public T key;
E value;
ArrayList<E> l=new ArrayList<E>();
public RedBlackNode(T key,E value,int size,RedBlackNode parent){
this.key=key;
this.value=value;
color=true;
height=size;
this.parent=parent;
}

public T GetKey(){
	return key;
}

public void set(E obj){
l.add(obj);

}
    @Override
    public E getValue() {
        return value;
    }

    @Override
    public List<E> getValues() {
        return l;
    }
}
