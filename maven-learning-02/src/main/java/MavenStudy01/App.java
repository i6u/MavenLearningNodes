package MavenStudy01;

import com.syn.hello.HelloMaven;

/**
 * Hello world!
 */
public class App {
    public void firest(String args) {
        System.out.println("Hello World!");
        HelloMaven helloMaven = new HelloMaven();
        helloMaven.showMe(args);
    }
}
