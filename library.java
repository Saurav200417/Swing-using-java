package PBL;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static PBL.library.bk;

class Book{
        public String name, author;

        public Book(String name, String author) {
            this.name = name;
            this.author = author;
        }

        @Override
        public String toString() {
            return
                    "name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    ']';
        }
    }

     class MyLibrary {
        public ArrayList<Book> books;
        public Map<String, String> userscredentials;

        public MyLibrary(ArrayList<Book> books) {
            this.books = books;
            this.userscredentials =new HashMap<>();
        }

        public boolean adduser(String username, String password) {
            userscredentials.put(username ,password);
            return true;
        }



        public void addBook(Book book) {

            this.books.add(book);
        }

        public void issueBook(Book book, String issued_to) {
            System.out.println("The book "+book+" has been issued from the library to :" + issued_to);
            this.books.remove(book);
        }

        public void returnBook(Book book , String issued_to) {
            System.out.println("The book "+book+" has been returned by :" + issued_to);
            this.books.add(book);
        }


        public Boolean login(String username, String password) {
            if (userscredentials.containsKey(username) && userscredentials.get(username).equals(password)) {
                return true;
            } else {
                return false;
            }
        }
    }
    public class library {
       public static ArrayList<Book> bk = new ArrayList<>();

        public static void main(String[] args) {


            MyLibrary l = new MyLibrary(bk);
            l.addBook(new Book("algo4", "myAuthor"));
            l.addBook(new Book("Crime and punishment", "Dostoyevsky"));
            l.addBook(new Book("The great gatsby", "F. Scott Fitzgerald"));
            l.addBook(new Book("Before the coffee gets cold", "Toshikazu"));
            l.addBook(new Book("Algorithms4", "CLRS4"));
            System.out.println(l.books);

            new Login();

            options opt = new options();
            opt.show("username");

        }
    }

 class Login implements ActionListener {

    public static JLabel label;
    public static   JFrame frame;
    public static  JPanel panel;
    public static JTextField usertext;
    public static JLabel label1;
    public static JPasswordField passwordtext;
    public static JButton loginb;
    public static JLabel display;


    public static void main(String[] args) {

        panel = new JPanel();
        frame = new JFrame("Library Management"); // Giving name to window
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);         // Adding panel to frame

        panel.setLayout(null);

        label = new JLabel("Username");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        usertext = new JTextField(20);
        usertext.setBounds(100, 20, 165, 25);
        panel.add(usertext);

        label1 = new JLabel("Password");
        label1.setBounds(10, 60, 80, 25);
        panel.add(label1);

        passwordtext = new JPasswordField(20);
        passwordtext.setBounds(100, 60, 165, 25);
        panel.add(passwordtext);

        loginb = new JButton("Login");
        loginb.setBounds(10, 90, 80, 25);
        loginb.addActionListener(new Login());
        panel.add(loginb);

        display= new JLabel("");
        display.setBounds(100,120,200,25);
        panel.add(display);


        frame.setVisible(true);
    }





    @Override
    public void actionPerformed(ActionEvent e) {
        MyLibrary lib = new MyLibrary(bk);
        lib.adduser("2","123");
        lib.adduser("1","123");
        try {
         String username = usertext.getText();
         String password = new String(passwordtext.getPassword());
         if (lib.login(username , password)){
             display.setText("Welcome"+ username);
             options opt = new options();
             opt.show("username");}
         else {
             display.setText("Invalid username or password");
         }
     }catch (Exception exception){
         System.out.println("Invalid ");
     }
//        MyLibrary lib = new MyLibrary(bk);
//        lib.adduser("2","123");
//        lib.adduser("1","123");
//        if (lib.login(username , password)){
//            display.setText("Welcome"+ username);
//            options opt = new options();
//            opt.show("username");
//        }else {
//            display.setText("Invalid username or password");
//        }


    }
}


  
