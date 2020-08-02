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
                            .to("file:" + path + "\\Organised Files\\HTML files")

                            .when(header("CamelFileNameConsumed").endsWith(".txt"))
                            .to("file:" + path + "\\Organised Files\\Text Files")

                            .when(header("CamelFileNameConsumed").endsWith(".cpp"))
                            .to("file:" + path + "\\Organised Files\\Codes")

                            .when(header("CamelFileNameConsumed").endsWith(".py"))
                            .to("file:" + path + "\\Organised Files\\Codes")

                            .when(header("CamelFileNameConsumed").endsWith(".java"))
                            .to("file:" + path + "\\Organised Files\\Codes")

                            .when(header("CamelFileNameConsumed").endsWith(".ppt"))
                            .to("file:" + path + "\\Organised Files\\PowerPoint")

                            .when(header("CamelFileNameConsumed").endsWith(".xlsx"))
                            .to("file:" + path + "\\Organised Files\\Excel Files")

                            .when(header("CamelFileNameConsumed").endsWith(".pdf"))
                            .to("file:" + path + "\\Organised Files\\PDF files")

                            .when(header("CamelFileNameConsumed").endsWith(".docx"))
                            .to("file:" + path + "\\Organised Files\\Word Doc files")

                            .when(header("CamelFileNameConsumed").endsWith(".zip"))
                            .to("file:" + path + "\\Organised Files\\Compressed files")

                            .when(header("CamelFileNameConsumed").endsWith(".rar"))
                            .to("file:" + path + "\\Organised Files\\Compressed files")

                            .when(header("CamelFileNameConsumed").endsWith(".PNG"))
                            .to("file:" + path + "\\Organised Files\\Images")

                            .when(header("CamelFileNameConsumed").endsWith(".jpg"))
                            .to("file:" + path + "\\Organised Files\\Images")

                            .when(header("CamelFileNameConsumed").endsWith(".jpeg"))
                            .to("file:" + path + "\\Organised Files\\Images")

                            .when(header("CamelFileNameConsumed").endsWith(".gif"))
                            .to("file:" + path + "\\Organised Files\\Images")

                            .when(header("CamelFileNameConsumed").endsWith(".mkv"))
                            .to("file:" + path + "\\Organised Files\\Videos")

                            .when(header("CamelFileNameConsumed").endsWith(".mp4"))
                            .to("file:" + path + "\\Organised Files\\Videos")

                            .when(header("CamelFileNameConsumed").endsWith(".mp3"))
                            .to("file:" + path + "\\Organised Files\\Music")

                            .otherwise()
                            .to("file:" + path + "\\Organised Files\\Other files")
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
