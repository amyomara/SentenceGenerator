import java.util.*;
import java.security.*;
import java.io.*;

public class Tester extends Dictionary{
    public static void main (String[] args){
        String s1 = randomSentence();
        System.out.println(s1);
    }
    public static String randomSentence(){
        Dictionary d = new Dictionary();
        Random rand = new Random();
        String s = "";
        int w1,w2,w3,w4,w5,w6,w7,w8;
        //first word
        w1 = rand.nextInt(4);
        s=s+d.getWord(w1);
        s=s.substring(0, 1).toUpperCase() + s.substring(1); 
        //second word - person adjective
        //if w1 = 'a'
        if(w1==2){
            w2 = rand.nextInt(51)+810;
        }
        //if w1 = 'an'
        else if(w1==1){
            w2 = rand.nextInt(15)+790;
        }
        //if w1 = 'some'/'the'
        else{
            int event = rand.nextInt(2);
            if(event==0){
                w2 = rand.nextInt(51)+810;
            }
            else{
                w2 = rand.nextInt(15)+790;
            }
        }
        s=s+d.getWord(w2);
        
        //third word - human noun
        //'the'
        if(w1==0){
            int event2 = rand.nextInt(2);
            if(event2==0){
                w3 = rand.nextInt(80)+10;
            }
            else{
                w3 = rand.nextInt(86)+100;
            }
        }
        //'an' or'a'
        else if(w1==1||w1==2){
            w3 = rand.nextInt(80)+10;
        }
        //'some'
        else{
            w3 = rand.nextInt(86)+100;
        }
        s=s+d.getWord(w3);
        
        //forth word - movement verb OR interaction verb
        int event3 = rand.nextInt(2);
        //movement verb
        if(event3==0){
            w4 = rand.nextInt(11)+720;
            s=s+d.getWord(w4)+"to ";
        }
        //interaction verb
        else{
            w4 = rand.nextInt(48)+740;
            s=s+d.getWord(w4);
        }
        
        //fifth word
        w5 = rand.nextInt(4);
        s=s+d.getWord(w5);
        
        //sixth word - location adjective OR animal adjecive OR object
        //if verb was movement verb - location adjective
        if(w4<731){
            //if w5 = 'a'
            if(w5==2){
                w6 = rand.nextInt(20)+940;
            }
            //if w5 = 'an'
            else if(w5==1){
                w6 = rand.nextInt(6)+930;
            }
            //if w5 = 'some'/'the'
            else{
                int event4 = rand.nextInt(2);
                if(event4==0){
                    w6 = rand.nextInt(20)+940;
                }
                else{
                    w6 = rand.nextInt(6)+930;
                }
            }
        }
        
        //if verb was interaction verb - animal adjective OR object
        else{
            int event5 = rand.nextInt(2);
            //animal adjective
            if(event5 == 0){
                //if w5 = 'a'
                if(w5==2){
                    w6 = rand.nextInt(40)+880;
                }
                //if w5 = 'an'
                else if(w5==1){
                    w6 = rand.nextInt(6)+870;
                }
                //if w5 = 'some'/'the'
                else{
                    int event6 = rand.nextInt(2);
                    if(event6==0){
                        w6 = rand.nextInt(40)+880;
                    }
                    else{
                        w6 = rand.nextInt(6)+870;
                    }
                }
            }
            //object
            else{
                //'the'
                if(w5==0){
                    int event7 = rand.nextInt(3);
                    if(event7==0){
                        w6 = rand.nextInt(161)+310;
                    }
                    else if(event7==1){
                        w6 = rand.nextInt(10)+480;
                    }
                    else{
                        w6 = rand.nextInt(210)+500;
                    }
                }
                //'an'
                else if(w5==1){
                    w6 = rand.nextInt(10)+480;
                }
                //'a'
                else if(w5==2){
                    w6 = rand.nextInt(161)+310;
                }
                //'some'
                else{
                    w6 = rand.nextInt(210)+500;
                }
            }
        }
        s=s+d.getWord(w6);
        
        //seventh word
        //location
        if(w4<731){
            //'the'
            if(w5==0){
                int event8 = rand.nextInt(2);
                if(event8==0){
                    w7 = rand.nextInt(29)+250;
                }
                else{
                    w7 = rand.nextInt(27)+280;
                }
            }
            //'an' or'a'
            else if(w5==1||w5==2){
                w7 = rand.nextInt(29)+250;
            }
            //'some'
            else{
                w7 = rand.nextInt(27)+280;
            }
            s=s+d.getWord(w7);
        }
        
        //animal
        else if(w6>710 && w6<920){
            if(w5==0){
                int event9 = rand.nextInt(2);
                if(event9==0){
                    w7 = rand.nextInt(24)+190;
                }
                else{
                    w7 = rand.nextInt(24)+220;
                }
            }
            //'an' or'a'
            else if(w5==1||w5==2){
                w7 = rand.nextInt(24)+190;
            }
            //'some'
            else{
                w7 = rand.nextInt(24)+220;
            }
            s=s+d.getWord(w7);
        }
        
        //eighth word - '.' or '!'
        w8 = rand.nextInt(10)+970;
        s=s+d.getWord(w8);
        s=s.replaceAll("\\n|\\r|\\n\\r", " ");
        s=s.substring(0,s.length()-3)+s.substring(s.length()-2,s.length()-1);
        return s;
    }
}