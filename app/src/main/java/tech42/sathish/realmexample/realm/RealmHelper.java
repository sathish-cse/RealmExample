package tech42.sathish.realmexample.realm;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by lenovo on 7/2/17.
 */

public class RealmHelper {

    private Realm realm;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }


    // Write Data
    public void save(final Book book)
    {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.copyToRealm(book);

            }
        });
    }

    // Read Data
    public ArrayList<ArrayList> retrieve()
    {
        ArrayList<ArrayList> book = new ArrayList<>();
        ArrayList<String> bookTitle = new ArrayList<>();
        ArrayList<String> bookAuthor = new ArrayList<>();
        RealmResults<Book> books = realm.where(Book.class).findAll();

        for( Book b : books)
        {
            bookTitle.add(b.getTitle());
            bookAuthor.add(b.getAuthor());
        }

        book.add(bookTitle);
        book.add(bookAuthor);

        return book;

    }


}
