
package neironweb;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.MimeMultipart;


public class MailReader {
String to = "";
String from = "";
String username = "bondarev_bs";
String password = "westbam1411!";
String toEmail  = "bondarev_bs@mail.ru";
Properties props = new Properties();
 //   Map<String, int> map = new Map<String, int>;
HashMap<String, Integer> hmap = new HashMap<String, Integer>();
public void GetMail(){
    try {
        props.setProperty("mail.store.protocol", "imaps");
        Session session = Session.getInstance(props,null);
        Store store = session.getStore();
        store.connect("imap.mail.ru", toEmail, password);
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
        Message [] msg = inbox.getMessages();
        System.out.println("Мы получили" + msg.length);
        for (int i = 0; i < 10; i++) {
         System.out.println("Дата: " + msg[i].getReceivedDate() + "Тема: " +msg[i].getSubject() + "Сообщение: " + getTextFromMessage(msg[i]));   
        }
        
    } catch (NoSuchProviderException ex) {
        Logger.getLogger(MailReader.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MessagingException ex) {
        Logger.getLogger(MailReader.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(MailReader.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(MailReader.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private static String getTextFromMessage(Message message) throws Exception {
String result = "";

if (message.isMimeType("text/plain")) {
result = message.getContent().toString();
} else if (message.isMimeType("multipart/*")) {
MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
result = getTextFromMimeMultipart(mimeMultipart);
}
return result;
}

private static String getTextFromMimeMultipart(
MimeMultipart mimeMultipart) throws Exception{
String result = "";
int count = mimeMultipart.getCount();
for (int i = 0; i < count; i++) {
BodyPart bodyPart = mimeMultipart.getBodyPart(i);
if (bodyPart.isMimeType("text/plain")) {
result = result + "\n" + bodyPart.getContent();
break; // without break same text appears twice in my tests
} else if (bodyPart.isMimeType("text/html")) {
String html = (String) bodyPart.getContent();
result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
} else if (bodyPart.getContent() instanceof MimeMultipart){
result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
}
}
return result;
}
}
