package Entropy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*This class creates bigrams and calculates entropy*/
public class Bigram {

	public static void main(String[] args)throws IOException {
    
		try{
			
			File f=new File("MidFile.txt");
			
			
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			
			
            ArrayList<String> s = new ArrayList();
            ArrayList<String> bigrams = new ArrayList();
            HashMap<String, Integer>map = new HashMap<String, Integer>();
            
        	
			String str = null;
			
			while((str = br.readLine())!= null){
				
				
				      str = str.replaceAll("[^a-zA-Z ]", "");
				      str = str.replaceAll("\\[", "").replaceAll("\\]", "");
				      s.add(str);  
					                 }
				 
			          //System.out.println(s);
			          
			
			      
			StringBuilder build = new StringBuilder();
			
			for(String sb: s){
		    	   build.append(sb);
		       }
			
			
			//System.out.println(build.length());
			char p;
			int count = 0;
			
			for(int i=0;i<build.length()-1;i++){
				
				//if the previous or next character isnt space
				if(build.charAt(i)!= 32 && build.charAt(i+1)!= 32){
				
				String gram =Character.toString(build.charAt(i))+Character.toString(build.charAt(i+1));
				bigrams.add(gram);
				
                  				                                                    }
			                                   }
			System.out.println(bigrams);
			
			StringBuilder bd = new StringBuilder();
			for(String sb: bigrams){
		    	   build.append(sb);
			}
			
			//Store bigrams in map
			for(String word: bigrams) {
				  Integer counti = map.get(word);          
				  map.put(word, (counti==null) ? 1 : counti+1);
				}
		
			int sum = 0;
			for(int add:map.values()){
				sum+=add;
			}
			
			//Iterate over map values and store frequencies in frequency array
			int msize = map.size();
			double fin[] = new double[msize];
            Set entries = map.entrySet();
            Iterator ei  = entries.iterator();
            int i =0;
            
            while(ei.hasNext()){
            	
            	Map.Entry mapping = (Map.Entry) ei.next();
            	fin[i] = (int) mapping.getValue();
            	i++;
            }
            
            //probability array
            double pro[] = new double[msize];
            
            //entropy array
            double entrop[] = new double[msize];
            
           //calculate probability for all bigrams
          for(int m =0; m<fin.length;m++)
           {
        	  double prob = fin[m]/sum;
        	  pro[m] = prob;
        	 
           }
            
          //calculate all entropies
            for(int e=0; e<pro.length;e++){
            	
            	double ent =  (pro[e])*(-Math.log(pro[e])/Math.log(2.0));
            	entrop[e] = ent;
            }
            
            double entropy = 0.0;
            for(double l: entrop){
            	entropy+=l;
            }
            System.out.println("Entropy for all bigrams is:" +entropy+ " bits");
           
          
			br.close();
			
               }
      catch(IOException e){
			
			System.out.println(e.getMessage());
		                    }
	}
}
