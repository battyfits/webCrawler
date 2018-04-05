import com.jaunt.*;
import com.jaunt.Element;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import com.jaunt.NotFound;

public class crawlData {
        public static void main(String[] args) {
            UserAgent userAgent = new UserAgent();//create new userAgent (headless browser)
            try {
                userAgent.visit("https://pantip.com/forum/library"); //visit pantip page
                Elements elements = userAgent.doc.findEach("<div class=\"post-item-title\">");
                for(Element element : elements){
                    String title = element.findFirst("<a>").getText().trim();
                    System.out.println(title);
                }
            } catch (ResponseException e) {
                e.printStackTrace();
            } catch (NotFound notFound) {
                notFound.printStackTrace();
            }
        }
    }

