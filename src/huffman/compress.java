package huffman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class compress {
	static String comp;
	static HashMap<Character,String> dicec = new HashMap<Character,String>();

	public compress() {
		
	}

	
	public void proccess(String address , String name){
		String tmp = read(address);
		comp = tmp;
		String c = com();
		write(c,name);
		JOptionPane.showMessageDialog(null, "the file is compressed");
	}

	@SuppressWarnings("resource")
	public String read(String address){
		String content = null;
		
		try {
			content = new Scanner(new File(address)).useDelimiter("\\Z").next();			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
	public void write(String c , String name) {
		File fl = new File(name+".txt");
		try {
			@SuppressWarnings("resource")
			PrintStream ps = new PrintStream(fl);
			ps.println(c);
			for (Character key : dicec.keySet()) {
				ps.println(key+dicec.get(key));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static String com() {
		PriorityQueue<node> minHeap=new PriorityQueue<node>(new Comparator<node>() {
			public int compare(node a, node b){
				if(a.getOcu() <= b.getOcu())return -1;
				else return 1;
			}
		});
		
		
		HashMap<Character,Long> map = new HashMap<Character,Long>();
		
		for(int i = 0; i < comp.length(); i++){
		   char c = comp.charAt(i);
		   Long val = map.get(new Character(c));
		   if(val != null){
		     map.put(c, new Long(val + 1));
		   }else{
		     map.put(c,new Long(1));
		   }
		}
		
		for (Character key : map.keySet()) {
			node e = new node(Character.toString(key),map.get(key));
			minHeap.add(e);
		}
		
//		while(!minHeap.isEmpty()){
//			System.out.println(minHeap.peek().getVal()+" "+minHeap.peek().getOcu());
//			minHeap.poll();
//		}
		while(minHeap.size()>1){
			node f = minHeap.poll();
			node s = minHeap.poll();
			String newS = f.getVal() + s.getVal();
			Long newoc = f.getOcu() +  s.getOcu();
			node par = new node(newS, newoc, f, s);
			minHeap.add(par);
		}
		//System.out.println(minHeap.peek().getVal() + " " + minHeap.peek().getOcu());
		dfs(minHeap.peek(),"");
		String ret = "";
		for(int i=0;i<comp.length();i++){
			ret+=dicec.get(comp.charAt(i));
		}
		return ret;
    }
	public static void dfs(node root,String x){
		if(root.getLeft() == null && root.getRight() == null){
			System.out.println(root.getVal() + " " + x);
			dicec.put(root.getVal().charAt(0), x);
			return ;
		}else{
			dfs(root.getLeft() , x+"1");
			dfs(root.getRight() , x+"0");
		}
		
	}

}
