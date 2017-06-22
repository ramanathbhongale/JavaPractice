/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.util.Arrays;

/**
 *
 * @author Raksha
 */
public class UniqueFinder {
    public static boolean uniqueFind(String str){
        int charset = 0;
        
        for(int i=0;i<str.length();i++){
            int val = str.charAt(i) ;
            if((charset & (1<<val))>0)
                return false;
            charset |= (1<<val);
        }
        return true;
    }
    public static String removeDuplicates(String str){
        if(str!=null){
        char chars[] = str.toCharArray();
        if(chars==null || chars.length<2)
            return str;
        int i=0;
        for(char ch: chars){
            int count = findDuplicate(ch, i, str);
            if(count>0){
                str = str.replaceAll(""+ch, "");
                i-=count;
                
            }
            if(str.length()==0)
                    return "";
            i++;
        }
        
        
       }
        return str;
    }
    
    public static void main(String arg[]){
//        System.out.println(uniqueFind("asdfghke"));
//        System.out.println(removeDuplicates("abababab"));
//        System.out.println(anagram("ababab","bababb"));
//        System.out.println(replace("ababab bababb abjdc"));
        System.out.println(removeDuplicates("aaaa".toCharArray()));
    }
    public static String replace(String str){
        StringBuilder str1 =new StringBuilder();
        String words[] = str.split(" ");
        for(String word: words){
            str1.append(word).append("%20");
        }
        return str1.toString().replaceFirst("%20$", "");
//        return str1.toString();
    }
    public static boolean anagram(String s1, String s2){
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        String t1 = new String(c1);
        String t2 = new String(c1);
        return t1.equalsIgnoreCase(t2);
    }
    private static int findDuplicate(char ch, int i, String str) {
        int count=0;
       
        for(int j=i+1;j>0 && j<str.length();j++){
            if(ch==str.charAt(j))
                count++;
        }
        return count;
    }
    private static String removeDuplicates(char []str){
        if(str==null) return "";
        int len=str.length;
        if(len<2) return "";
        boolean []hit = new boolean[256];
        hit[str[0]]=true;
        int tail =1;
        int count=0;
        for(int i=1;i<len;i++){
            if(!hit[str[i]]){
                str[tail] = str[i];
                ++tail;
                hit[str[i]]  = true;
            }
            
        }
        if(tail<=len-1)
            str[tail] =0;
        return new String(str).substring(0, len-tail );
    }
    
}
