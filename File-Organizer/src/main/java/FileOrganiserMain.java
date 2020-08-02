import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.Scanner;

public class FileOrganiserMain {
    public static void main(String[] args) {
        CamelContext context = new DefaultCamelContext();

        try {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter the path :");
                    String path = sc.next();
                    System.out.println(path);
                    from("file:" + path + "?noop=true")
                            .log("The header is ${headers}")
                            .choice()
                            .when(header("CamelFileNameConsumed").endsWith(".html"))
                            .to("file:" + path + "\\Arranged Files\\HTML files")

                            .when(header("CamelFileNameConsumed").endsWith(".txt"))
                            .to("file:" + path + "\\Arranged Files\\Text Files")

                            .when(header("CamelFileNameConsumed").endsWith(".cpp"))
                            .to("file:" + path + "\\Arranged Files\\Codes")

                            .when(header("CamelFileNameConsumed").endsWith(".py"))
                            .to("file:" + path + "\\Arranged Files\\Codes")

                            .when(header("CamelFileNameConsumed").endsWith(".java"))
                            .to("file:" + path + "\\Arranged Files\\Codes")

                            .when(header("CamelFileNameConsumed").endsWith(".ppt"))
                            .to("file:" + path + "\\Arranged Files\\PowerPoint")

                            .when(header("CamelFileNameConsumed").endsWith(".xlsx"))
                            .to("file:" + path + "\\Arranged Files\\Excel Files")

                            .when(header("CamelFileNameConsumed").endsWith(".pdf"))
                            .to("file:" + path + "\\Arranged Files\\PDF files")

                            .when(header("CamelFileNameConsumed").endsWith(".docx"))
                            .to("file:" + path + "\\Arranged Files\\Word Doc files")

                            .when(header("CamelFileNameConsumed").endsWith(".zip"))
                            .to("file:" + path + "\\Arranged Files\\Compressed files")

                            .when(header("CamelFileNameConsumed").endsWith(".rar"))
                            .to("file:" + path + "\\Arranged Files\\Compressed files")

                            .when(header("CamelFileNameConsumed").endsWith(".PNG"))
                            .to("file:" + path + "\\Arranged Files\\Images")

                            .when(header("CamelFileNameConsumed").endsWith(".jpg"))
                            .to("file:" + path + "\\Arranged Files\\Images")

                            .when(header("CamelFileNameConsumed").endsWith(".jpeg"))
                            .to("file:" + path + "\\Arranged Files\\Images")

                            .when(header("CamelFileNameConsumed").endsWith(".gif"))
                            .to("file:" + path + "\\Arranged Files\\Images")

                            .when(header("CamelFileNameConsumed").endsWith(".mkv"))
                            .to("file:" + path + "\\Arranged Files\\Videos")

                            .when(header("CamelFileNameConsumed").endsWith(".mp4"))
                            .to("file:" + path + "\\Arranged Files\\Videos")

                            .when(header("CamelFileNameConsumed").endsWith(".mp3"))
                            .to("file:" + path + "\\Arranged Files\\Music")

                            .otherwise()
                            .to("file:" + path + "\\Arranged Files\\Other files")
                            .end();
                }
            });

            context.start();
            Thread.sleep(300000);    // time depends on the size of folder
            context.stop();

        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }

    }
}
