package org.example;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        String location="applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(location);

        BookService service =
                context.getBean("bookService", BookService.class);

        service.displayService();
    }
}