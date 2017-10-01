//Main Class

package Entropy;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/*This class cleans text file from
 *  non Alphabetic characters and calculates entropy
 *  */

public class UniCEntropy {

	public static void main(String[] args) throws IOException {

		
		try{
			
			File f=new File("MidFile.txt");
			
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			ArrayList<String> s = new ArrayList();
			
			String str = null;
			
			while((str = br.readLine())!= null){
				
				//regex to check for alphabetic characters only anything except that is deleted
				      str = str.replaceAll("[^a-zA-Z]", "");
				      str = str.replaceAll("\\[", "").replaceAll("\\]", "");
				      s.add(str);  
					                 }
				 
				
		       StringBuilder build = new StringBuilder();
		     
		       for(String sb: s){
		    	   build.append(sb);
		       }
			    
		       
               //Hashmap stores alphabets and their frequencies
		       HashMap<Character, Integer> map = new HashMap<>();
				for (char ch : build.toString().toCharArray()) {
					
					if(Character.isLetter(ch)&& Character.isUpperCase(ch)){
						ch = Character.toLowerCase(ch);
					}
				
				if (map.containsKey(ch)) {
					int val = map.get(ch);
					map.put(ch, val + 1);
				} else {
					map.put(ch, 1);
				}
			}
			
			System.out.println(map);	
				
				int sum = 0;
				for(int add:map.values()){
					sum+=add;
				}
				
				
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
               
                double pro[] = new double[msize];
                double entrop[] = new double[msize];
                
              for(int m =0; m<fin.length;m++)
               {
            	  double prob = fin[m]/sum;
            	  pro[m] = prob;
            	 
               }
                
              //calculate entropies and store in entropy array
                for(int e=0; e<pro.length;e++){
                	
                	double ent =  (pro[e])*(-Math.log(pro[e])/Math.log(2.0));
                	entrop[e] = ent;
                }
                
                double entropy = 0.0;
                for(double l: entrop){
                	entropy+=l;
                }
                System.out.println("Entropy is:" +entropy+ " bits" );
               
                br.close();
	}
		
		
		catch(IOException e){
			
			System.out.println(e.getMessage());
		                    }
		
		
	                                                         }

                    }
