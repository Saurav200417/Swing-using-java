package PBL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class options implements ActionListener {

    static JButton Displaybooks = new JButton("Displaybooks");
    public static JButton IssueaBook = new JButton("IssueaBook");
    public static JButton returnaBook = new JButton("returnaBook");
    public static JButton logout = new JButton("Log out");
    public static JFrame frame2 = new JFrame("Options"); // Giving name to window
    public static JPanel panel2 = new JPanel();

    public void show(String username) {
        String user = username;

        frame2.setVisible(true);
        frame2.setSize(400, 300);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.add(panel2);
        panel2.setLayout(null);

        Displaybooks.setBounds(10, 20, 120, 25);
        panel2.add(Displaybooks);

        IssueaBook.setBounds(10,50,120,25);
        panel2.add(IssueaBook);

        returnaBook.setBounds(10,80,120,25);
        panel2.add(returnaBook);

        logout.setBounds(10,110,120,25);
        panel2.add(logout);

        frame2.setVisible(true);


    }

    public options() {
        Displaybooks.addActionListener(this);
        IssueaBook.addActionListener(this);
        returnaBook.addActionListener(this);
        logout.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        MyLibrary l = new MyLibrary(library.bk);
        l.addBook(new Book("algo4", "myAuthor"));
        l.addBook(new Book("Crime and punishment", "Dostoyevsky"));
        l.addBook(new Book("The great gatsby", "F. Scott Fitzgerald"));
        l.addBook(new Book("Before the coffee gets cold", "Toshikazu"));
        l.addBook(new Book("Algorithms4", "CLRS4"));
        if (e.getSource() == Displaybooks){

            System.out.println(library.bk);
        } else if (e.getSource() == IssueaBook) {

            String username = JOptionPane.showInputDialog("Enter your name");
            String book = JOptionPane.showInputDialog("Enter Book name");
            Book b1 = new Book(book ,username);
            for (Book book1: library.bk) {
                if (book1.name.equalsIgnoreCase(book)) {

                    l.issueBook(b1, username);
                    break;
                }
                else{
                    System.out.println("Book not found");
                }
            }
        } else if (e.getSource()==returnaBook) {
            String issuedto = JOptionPane.showInputDialog("Enter your name");
            String book = JOptionPane.showInputDialog("Enter Book name");
            Book b1 = new Book(book ,issuedto);

            for (Book book1:library.bk) {
                if (!book1.name.equalsIgnoreCase(book)){

                    l.returnBook(b1 ,issuedto);
                    break;
                }
                else {
                    System.out.println("Book not found");
                }
            }
        } else if (e.getSource()==logout) {
           frame2.setVisible(false);

        }

    }
}


