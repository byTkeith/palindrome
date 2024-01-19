
//author:Tendai K Nyevedzanai
import java.io.*;
import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        ArrayList<String> lineOfStringFromFile= new ArrayList<>();//takes the string values read from the file
        ArrayList<Character> clearCharValues=new ArrayList<>();// the char values without alphanaumeric characters after being removed
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter the name of the file:");
        String filename=scanner.nextLine();
        try{
            File file= new File(filename);
            scanner =new Scanner(file);//used the scanner to read through the file
            while(scanner.hasNextLine()){
                lineOfStringFromFile.add(scanner.nextLine());//so long as the file has lines continue reading

            }
        }catch(FileNotFoundException e){//used catch for error detection, if the file does not exist
            System.out.println("File not found ASKIES!!");
        }finally{
            if(scanner!=null){
                scanner.close();//closed the file after completing the reading process
            }
        }
        /*
         * loops through the lines read from file
         */
        for(String eachLine: lineOfStringFromFile){
            String lowerCaseEachLine=eachLine.toLowerCase();//convert all  the values to lowercase
            char[] charOfLine=lowerCaseEachLine.toCharArray();//all values in a line converted to char
            int i;
            for(i=0;i<charOfLine.length;i++){//loops through all char values
                if(charOfLine[i]!=' '&charOfLine[i]!=','&charOfLine[i]!='.'&charOfLine[i]!=':'){
                    clearCharValues.add(charOfLine[i]);

                }
                
                
            }
            System.out.println("the new list is as follows "+clearCharValues); 
            char emptyArray=' ';
            int matches=0;
            int arrayLength=clearCharValues.size();
            for(int a=0;a<clearCharValues.size();a++){
                //for(int z=clearCharValues.size();z>0;z--){
                if(clearCharValues.get(a)==clearCharValues.get(arrayLength-a-1)){
                    matches++;

                }
                //else if(lineOfStringFromFile.equals(emptyArray)){System.out.println("array empty , but still a palindrome");}
                //else{System.out.println("value is not a palindrome.");}

                //}

            }if(matches==clearCharValues.size()){
                System.out.println("The given string is a palindrome.");
            }
            else{System.out.println("The above given string is not a palindrome");}
            //System.out.println("the matches are "+matches);
        }
    }
    
}
