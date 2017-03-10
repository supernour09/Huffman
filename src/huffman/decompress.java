package huffman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class decompress {
	
	String com;
	static HashMap<String,Character> dicec = new HashMap<String,Character>();
	public decompress() {

	}

	public void proccess(String adress, String name) {
		read(adress);
		String t = decomp();
		write(t, name);
		JOptionPane.showMessageDialog(null, "the file is decompressed");

	}

	public void write(String x, String name) {
		try {
			  BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(name)));
              bwr.write(x);
              bwr.flush();
              bwr.close();
            } catch (Exception ex) {

		}

	}

	public String decomp() {
		String tmp ="", ans ="";
		for(int i=0;i<com.length();i++){
			tmp+=com.charAt(i);
			if(dicec.containsKey(tmp)){
				ans+=dicec.get(tmp);
				tmp="";
			}
		}
		return ans;
	}

	public void read(String x) {
		File f = new File(x);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			try {
				com = br.readLine();
				String tmp ;
				while(br.ready()){
					tmp = br.readLine();
					dicec.put(tmp.substring(1), tmp.charAt(0));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			br.close();
			
		} catch (IOException e) {
			
			//e.printStackTrace();
		}
		
		
	}

}