	package RedBlack;


public class RBTree<T extends Comparable, E> implements RBTreeInterface<T, E>  {

private RedBlackNode root;
   public boolean nodecolor(RedBlackNode n){
   	if(n==null){
   		return false;
   	} return n.color;
   }

    @Override
    public void insert(T key, E value) {
	root=RBinsert(root,key,value,null);
	 RedBlackNode<T,E> n= search(key);
	 fix(n);
	root.color=false;
	}    

private RedBlackNode RBinsert(RedBlackNode node,T key,E value,RedBlackNode parent){
		
	if(node==null){
RedBlackNode<T,E> nn=new RedBlackNode<T,E>(key,value,1,parent);
nn.set(value);
nn.parent=parent;
		return nn;
	}
	if(node.GetKey().toString().compareTo(key.toString())>0){
		node.left=RBinsert(node.left,key,value,node);

	}else if(node.GetKey().toString().compareTo(key.toString())<0){
		node.right=RBinsert(node.right,key,value,node);
	}else if(node.GetKey().toString().compareTo(key.toString())==0){
		node.set(value);
		}
	
	return node;
	}

private void fix(RedBlackNode node){
	while(node!=root && node.parent.color&&node.color){
	RedBlackNode uncle=null;
	if(node.parent==node.parent.parent.left){
uncle=node.parent.parent.right;
	
	if(uncle!=null&&uncle.color){
		uncle.color=false;
		node.parent.color=false;
		node.parent.parent.color=true;
		node=node.parent.parent;
	}else {

	if(node==node.parent.right){
		node=node.parent;
		Leftrotate(node);
	}
	node.parent.color=false;
	node.parent.parent.color=true;
	Rightrotate(node.parent.parent);

	}
}
else 
{
	uncle=node.parent.parent.right;
	
	if(uncle!=null&&uncle.color){
		uncle.color=false;
		node.parent.color=false;
		node.parent.parent.color=true;
		node=node.parent.parent;
	}else {

	if(node==node.parent.left){
		node=node.parent;
		Rightrotate(node);
	}
	node.parent.color=false;
	node.parent.parent.color=true;
	Leftrotate(node.parent.parent);

	}
}
} root.color=false;
}
		



public int height(RedBlackNode x){
	if(x==null)
		return 0;
	return x.height;
}

private int maximum(int x,int y){
	if(x>y){
		return x;
	}else return y;
}
private void Rightrotate(RedBlackNode x){
	RedBlackNode y=x.left;
RedBlackNode z=y.right;
RedBlackNode k=x.parent;
	if(k==null){
y.right=x;
x.parent=y;
x.left=z;
if(x.left!=null){
x.left.parent=x;
}	y.parent=null;
root=y;
	}else {
		if(x==x.parent.right){
			x.parent.right=x.left;
		}else {
			x.parent.left=x.left;
		}
	if(x.left!=null){
		x.left.parent=x.parent;
	}
	x.parent=x.left;
	if(x.left!=null && x.left.right!=null){
		x.left.right.parent=x;
	}if(x.left!=null){
		x.left=x.left.right;
	}	x.parent.right=x;
}
x.height=maximum(height(x.left),height(x.right))+1;
y.height=maximum(height(y.left),height(y.right))+1;

}
private void Leftrotate(RedBlackNode x){
		RedBlackNode y=x.right;
RedBlackNode z=y.left;
RedBlackNode k=x.parent;
	if(k==null){
y.left=x;
x.parent=y;
x.right=z;
if(x.right!=null){
x.right.parent=x;
}	y.parent=null;
root=y;
	}else {
		if(x==x.parent.left){
			x.parent.left=x.right;
		}else {
			x.parent.right=x.right;
		}
	if(x.right!=null){
		x.right.parent=x.parent;
	}
	x.parent=x.right;
	if(x.right!=null && x.right.left!=null){
		x.right.left.parent=x;
	}if(x.right!=null){
		x.right=x.right.left;
	}	x.parent.left=x;
}
x.height=maximum(height(x.left),height(x.right))+1;
y.height=maximum(height(y.left),height(y.right))+1;

}

    @Override
    public RedBlackNode<T, E> search(T key) {
  
       RedBlackNode<T,E> p=root;
       while(p!=null){
       	if(p.GetKey().toString().compareTo(key.toString())>0){
       		p=p.left;
       	}else if(p.GetKey().toString().compareTo(key.toString())<0){
       		p=p.right;
       	}else return p;
       }RedBlackNode<T,E> nul=new RedBlackNode<T,E>(null,null,0,null);
       nul.l=null;
       return nul; 


    }


   }