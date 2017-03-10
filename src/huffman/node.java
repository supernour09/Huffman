package huffman;

public class node {
	String val;
	long ocu;
	node left , right ;
	public node() {
		// TODO Auto-generated constructor stub
	}
	public node(String x , long y  , node l , node r) {
		val = x ;
		ocu = y;
		left = l;
		right = r;
	}
	public node(String string, long y) {
		val = string ;
		ocu = y;
		left = null;
		right = null;
		
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public long getOcu() {
		return ocu;
	}
	public void setOcu(long ocu) {
		this.ocu = ocu;
	}
	public node getLeft() {
		return left;
	}
	public void setLeft(node left) {
		this.left = left;
	}
	public node getRight() {
		return right;
	}
	public void setRight(node right) {
		this.right = right;
	}
	
	
}
