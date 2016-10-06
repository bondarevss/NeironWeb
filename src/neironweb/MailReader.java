
package neironweb;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.mail.*;
//import javax.mail.internet.MimeMultipart;


public class MailReader {
String to = "";
String from = "";
String username = "bondarev_bs";
String password = "westbam1411!";
String toEmail  = "bondarev_bs@mail.ru";
Properties props = new Properties();
 //   Map<String, int> map = new Map<String, int>;
HashMap<String, Integer> hmap = new HashMap<String, Integer>();
/*
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
*/
public static void analizator (String text){
    double weightWord=0;
    double weightV = 0;
 String [] maswords = {"бизнес", 
"деньги", 
"скидка",
"цена",
"недорого",
"выгодно",
"подробнее", 
"смотреть",
"заработать", 
"внимание",
"начните",
"получите",
"откройте",
"создайте",
"заработайте",
"ищем",
"акция",
"Реклама",
"Доступный",
"Подарок",
"Бонус",
"Скидка",
"Экономия",
"Заработок",
"Рубль",
"Доход",
"Дешёвый",
"Заказ",
"Кредит",
"Инвестиции",
"Свобода",
"Гарантия",
"Секрет",
"Новинка",
"Ограниченный",
"Сделка",
"Прайс",
"Цена",
"Счёт",
"Купите",
"Срочно",
"Доступ",
"Деньги",
"Выгода",
"Поздравляем",
"Конфиденциально",
"Работа",
"Присоединяйтесь",
"Специальный"};  
 String masv [] = {
"очень выгодно",
"получайте деньги",
"Выбирайте предложенные", 
"узнать больше",
"способ как заработать",
"как заработать",
"в день",
"стабильные выплаты",
"уникальный курс",
"с нами",
"100% бесплатно",
"Сто процентов бесплатно",
"Коммерческое предложение",
"Увеличение продаж",
"Эксклюзивное предложение",
"бизнес на дому",
"фриланс"
 };
 text = "Возможности есть, свой бизнес создать хочется, не хватает опыта и идей свежих?"
         + "Возможности есть, свой бизнес создать хочется, не можете найти своё?"
         + "Деньги есть, свой бизнес создать хочется, не хватает смелости и опыта?"
         + "Возможности есть, свой бизнес создать хочется, не можете найти своё?"
         + "Свой бизнес открыть хочется, возможности имеются, не хватает опыта "
         + "и идей свежих?Возможности есть, свой бизнес на дому создать хочется, не хватает опыта и идей свежих?" ;  
text = text.replaceAll("[ ]+", " ");
 String text2 = text.replaceAll("[^а-яА-Я]", " ");
text2 = text2.replaceAll("[ ]+", " ");
 String [] masString = text2.split(" ");
//    for (String masString1 : masString) {
//        System.out.println(masString1); 
//
//    }
 ///// Считаем кол-во спамовских слов
int countwd = 0;
    for (int i = 0; i < maswords.length; i++) {
        for (int j = 0; j < masString.length; j++) {
            if(maswords[i].equals(masString[j]))
                countwd++;
        }
    }
    weightWord=countwd/(double)masString.length;
    System.out.println(weightWord);
    System.out.println(countwd + " " + masString.length);

///// Кол-во словосочетаний
int countV=0;
    for (int i = 0; i < masv.length; i++) {
        int index = text.indexOf(masv[i]);
        if (index!=-1){
           countV++;
           while (text.indexOf(masv[i], index+1) !=-1){
               countV++;
               index = text.indexOf(masv[i],index);
           }
        }
    }
    weightV=countV/(((double)masString.length)/2);
    System.out.println("countV = " + countV);
    System.out.println("weightV = " + weightV);
}



}
