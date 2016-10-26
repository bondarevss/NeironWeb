
package neironweb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static neironweb.MatrixWeight.path;
import javax.mail.*;
import javax.mail.internet.MimeMultipart;


public class MailReader {

String to = "";
String from = "";
String username = "bondarev_bs";
String password = "warmday1411!";
//String toEmail  = "smolyakav@mail.ru";
String toEmail  = "bs_project_88@mail.ru";
Properties props = new Properties();
 //   Map<String, int> map = new Map<String, int>;
HashMap<String, Integer> hmap = new HashMap<String, Integer>();
//static String path = "C:\\Users\\BS\\Desktop\\";
 int cnt;
String path = "resources//";
FileWriter out;
FileReader fr;
BufferedReader br;
StringBuilder resultText = new StringBuilder();





public void GetMail()  {
    
    //saving properties
//    Properties properties = new Properties();
//    
//    try {
//        OutputStream outst = new FileOutputStream("propertiesfile");
//        properties.setProperty("email", "bs_project_88@mail.ru");
//        properties.setProperty("password", "warmday1411!");
//        properties.setProperty("spam", "true");
//        
//         properties.store(outst, null); 
//        
//         } catch (Exception ex) {
//        Logger.getLogger(MailReader.class.getName()).log(Level.SEVERE, null, ex);
//    } 
         
         
        
        try {
            props.setProperty("mail.store.protocol", "imaps");
            Session session = Session.getInstance(props,null);
            Store store = session.getStore();
            store.connect("imap.mail.ru", toEmail, password);
            Folder inbox = store.getFolder("SpamForExperiments");
            inbox.open(Folder.READ_ONLY);
            Message [] msg = inbox.getMessages();
            System.out.println("Мы получили" + msg.length);
            
            for (int i = 0; i < msg.length; i++) {
                System.out.println("Дата: " + msg[i].getReceivedDate() + "Тема: " +msg[i].getSubject() + "Сообщение: " + getTextFromMessage(msg[i]));
                
                //true if spam
                analizator(msg[i].getSubject(), getTextFromMessage(msg[i]), true);
            }
            
            saveInformation(resultText.toString(), "parameters");
            
            System.out.println("parameters was saved");
            
        } catch (Exception ex){
            Logger.getLogger(MailReader.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
}

private String getTextFromMessage(Message message) throws Exception {
String result = "";

if (message.isMimeType("text/plain")) {
result = message.getContent().toString();
} else if (message.isMimeType("multipart/*")) {
MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
result = getTextFromMimeMultipart(mimeMultipart);
}
else if (message.isMimeType("text/html")) {
result = message.getContent().toString();
}
return result;
}

private String getTextFromMimeMultipart(
MimeMultipart mimeMultipart) throws Exception{
String result = "";
int count = mimeMultipart.getCount();
for (int i = 0; i < count; i++) {
BodyPart bodyPart = mimeMultipart.getBodyPart(i);
if (bodyPart.isMimeType("text/plain")) {
result = result + "\n" + bodyPart.getContent();
break; // without break same text appears twice in my tests
} 
else if (bodyPart.isMimeType("text/html")) {
String html = (String) bodyPart.getContent();
result = result + "\n" + html; //org.jsoup.Jsoup.parse(html).text();
} 
else if (bodyPart.getContent() instanceof MimeMultipart){
result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
}
}
return result;
}


static double log(int x, int base)
{
    return (double) (Math.log(x) / Math.log(base));
}


public void analizator (String topic, String text, boolean spam ){
    double weightWord=0;
    double weightV = 0;
    

 // Переведём наши масивы в Файл 
// saveInformation(massToStringLn(maswords),"maswords");
 //saveInformation(massToStringLn(masv),"masv");
 //updutefdcile(maswords, "maswords");

     
 String [] maswords = (readInformation("words")).split("\n"); 
 String masv [] = (readInformation("collacations")).split("\n");
 
 


 text = text.replaceAll("[ ]+", " ");
 String text2 = text.replaceAll("[^а-яА-Я]", " ");
text2 = text2.replaceAll("[ ]+", " ");
 String [] masString = text2.split(" ");

 ///// Считаем кол-во спамовских слов
int countwd = 0;
    for (int i = 0; i < maswords.length; i++) {
        for (int j = 0; j < masString.length; j++) {
            if(maswords[i].equals(masString[j]))
                countwd++;
        }
    }
    
   
    //countwd = 10;
    //weightWord = masString.length!=0 ? countwd/(double)masString.length : 0;
    //System.out.println("weightWord value " + weightWord + " countwd value " + countwd);    
   // weightWord =  (1 / (1 + Math.pow(Math.E, - weightWord))) - 0.5; 
    //weightWord = 20;
    weightWord =  log((int)countwd + 1, 12); 
    
    weightWord = weightWord > 1 ?  1 : weightWord;
    
    System.out.println(" value " + weightWord);
    System.out.println(" count " + countwd + " " + " coutn all " + masString.length);

    
    
    
///// Кол-во словосочетаний
int countV=0;
    for (int i = 0; i < masv.length; i++) {
        int index = text.indexOf(masv[i]);
        
        if (index!=-1){
           countV++;
           while (text.indexOf(masv[i], index + 1) !=-1){
               countV++;
               index = text.indexOf(masv[i],index + 1);
           }
        }
    }
   // weightV=masString.length!=0?countV/(((double)masString.length)/2):0;
   // weightV = 1/(1+Math.pow(Math.E,-weightV));
    
    weightV =  log((int)countV + 1, 12);     
    weightV = weightV > 1 ?  1 : weightV;
    
    System.out.println("countwd = " + weightWord);
    System.out.println("countV = " + weightV);
    System.out.println("Link = " + foundlink(text));
    System.out.println("Topic = "+ analizTopic(topic));
    
    if ((weightWord == 0.0)  && (weightV == 0.0)
            &&  (foundlink(text) == 0.0) &&  (analizTopic(topic) == 0.0))
        return;
    
    int param1Normal; 
    int param2Spam;         
    if (spam)
    {
        param1Normal = 0;
        param2Spam = 1;
    }
    else
    {
        param1Normal = 1;
        param2Spam = 0;
    }
    
    resultText.append(weightWord + "_" +weightV + "_" +foundlink(text)
            + "_" +analizTopic(topic)+ "_"+param1Normal+ "_"+ param2Spam + "\n");
}



//сохраняем в файл с указанным названием 
public void saveInformation(String stp, String filename){
   // filename = "countWordandV.txt";
   // path = path + filename+".txt";
    try {
        out = new FileWriter(path + filename+".txt");
        out.write(stp);
        out.close();
    } catch (IOException ex) {
        Logger.getLogger(MailReader.class.getName()).log(Level.SEVERE, null, ex);
    }
}

//читает информацию с файла с указанным названием 
 public  String readInformation(String filename){
    String temp = ""; 

    String s = "";
    //path = path + filename+".txt";
    try {
        fr = new FileReader(path + filename + ".txt");
         br = new BufferedReader(fr); 
         s = br.readLine();
          
         while (s !=  null)
            {
               temp += s + "\n"; 
               s = br.readLine();               
            }
        //System.out.println("Прочитали : " + temp); 

        
    } catch (FileNotFoundException ex) {
      //  Logger.getLogger(MatrixWeight.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      //  Logger.getLogger(MailReader.class.getName()).log(Level.SEVERE, null, ex);
    }
     return temp;
    }

 // Переводит массив в строку с переводом карретки 
 public String massToStringLn(String [] mas){
    String masString = ""; 
     for (int i = 0; i < mas.length; i++) {
       masString=masString+mas[i]+'\n'; 
     }
     return masString;
 }

 //Переводит строку в масив. Бьёт по '\n'
 public String [] StringToMasKaretka(String str){
  String [] StringMas = str.split("\n");
  return StringMas;
 }
 
 public static double foundlink(String message){
  if(message.indexOf("href")!=-1) return 1.0;
  else return 0.0;
 }
 
public static double analizTopic(String message){
 if (message!=null) 
        return message.length()/100.0;
 else return 0.0;
}

//Добавление инфы в Файл !!! Внимание копит пустые строки из-за newtext.append(oldinfa +"\n")
public void updutefdcile (String [] mas,String filename)
{
  //if(readInformation(filename).matches("[^а-яА-Я]")==true){
    String oldinfa = readInformation(filename);
    if(oldinfa.isEmpty()==false){
      System.out.println("ЕСТЬ инфа в файле");
      String [] masoldinfa = StringToMasKaretka(oldinfa);
      StringBuilder newtext = new StringBuilder();
      newtext.append(oldinfa +"\n");
        for (int i = 0; i < mas.length; i++) {
            int cnt = 0;
            for (int j = 0; j < masoldinfa.length; j++) {
               if (mas[i].equals(masoldinfa[j])==true){
                    System.out.println(mas[i] + " | " + masoldinfa[j] + " Если сделать indexof: " +mas[i].indexOf(masoldinfa[j]) +" Если Equals: = "+mas[i].equals(masoldinfa[j]));
                   cnt++;
               }
            }
            System.out.println("i = " + i + " cnt = " + cnt);
           if (cnt == 0)
              newtext.append(mas[i]+"\n");
        }
      saveInformation(newtext.toString(),filename);
  }
    else {
         saveInformation(massToStringLn(mas),filename);
    }
 
}
}
