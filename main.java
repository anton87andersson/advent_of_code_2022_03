package aoc_template;
import java.io.*;
import java.util.*;

public class Aoc_template {
    public static void main(String[] args) {
        
        List<String> all_items = new ArrayList<>();
        List<Character> complete_list = new ArrayList<>();
        int total_prio = 0;
  
        try  
        {  
            File file=new File("C:/aoc_input/03/input.txt");
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            StringBuffer sb=new StringBuffer();
            String line;  
            
            while((line=br.readLine())!=null)  
            {  
                all_items.add(line); 
            }
            fr.close();
        }  
        catch(IOException e)  
        {  
            e.printStackTrace();
        }

        for (int i = 0; i<all_items.size();i++) {
            String original = all_items.get(i);
            String firsthalf = "";
            String secondhalf = "";
        
            if(original.length()%2 == 0)
            {
                firsthalf =original.substring(0, original.length()/2);
                secondhalf = original.substring(original.length()/2);
                char[] first_half = firsthalf.toCharArray();
                char[] second_half = secondhalf.toCharArray();
                boolean found = false;
                
                for (int j = 0; j<first_half.length;j++) {
                    for (int k = 0; k<second_half.length;k++) {                        
                        if (second_half[k] == first_half[j] && found == false) {
                            complete_list.add(first_half[j]);
                            found = true;
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i<complete_list.size();i++) {
            char val = complete_list.get(i);
            if (Character.isLowerCase(val)) {
                total_prio = total_prio + (complete_list.get(i).charValue() - 96);
            }
            else{
                total_prio = total_prio + (complete_list.get(i).charValue() - 38);                    
            }             
        }
        
        System.out.println("Total part 1 : " + total_prio);
        
        // End of part 1
        
        
        // Start of part 2
        String[] temp1 = new String[1];
        String[] temp2 = new String[1];
        String[] temp3 = new String[1];
        int total_score = 0;
        boolean reached_three = false;
        int counter = 0;
        boolean found = false;

        for (int a = 0;a<all_items.size();a++) {
                if (a % 3 == 0){
                found = false;
                temp1[0] = all_items.get(a);
                temp2[0] = all_items.get(a + 1);
                temp3[0] = all_items.get(a + 2);

                char[] temp1_char = temp1[0].toCharArray();
                char[] temp2_char = temp2[0].toCharArray();
                char[] temp3_char = temp3[0].toCharArray();
                
                for (char c : temp1_char) {
                    for (char d : temp2_char) {
                        for (char e : temp3_char) {
                            if (d == c) {
                                if (e == d && found == false) {
                                    char val = e;
                                    int test = e;
                                    if (Character.isLowerCase(val)) {
                                        total_score = total_score + test - 96;
                                        reached_three = false;
                                        found = true;
                                        break;
                                    }
                                    else{
                                        total_score = total_score + test - 38;
                                        reached_three = false;
                                        found = true;
                                        break;
                                    }    
                                }
                            }
                        }
                    }
                }  
            }
        }
        
        System.out.println("Total part 2 : " + total_score);
    }
}

