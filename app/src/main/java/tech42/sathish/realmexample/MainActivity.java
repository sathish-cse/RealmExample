package tech42.sathish.realmexample;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmMigrationNeededException;
import tech42.sathish.realmexample.realm.Book;
import tech42.sathish.realmexample.realm.RealmHelper;
import tech42.sathish.realmexample.recyclerview.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    private Realm realm;
    private ArrayList<ArrayList> books;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;
    private EditText titleEditText, authorEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view_users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize Realm
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
        try {
            realm = Realm.getInstance(realmConfiguration);
        }
        catch (RealmMigrationNeededException e){
            try {
                Realm.deleteRealm(realmConfiguration);
                //Realm file has been deleted.
                realm =  Realm.getInstance(realmConfiguration);
            }
            catch (Exception ex){
                throw ex;
                //No Realm file to remove.
            }
        }

        // Retrieve Data
        RealmHelper realmHelper = new RealmHelper(realm);
        books = realmHelper.retrieve();

        // Bind Data to RecyclerView
        recyclerViewAdapter = new RecyclerViewAdapter(this,books);
        recyclerView.setAdapter(recyclerViewAdapter);

        // Initialize FloatingAction buttom
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInputDialog();
            }
        });

    }

    // Show Dialog
    private void displayInputDialog()
    {
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("Add Book");
        dialog.setContentView(R.layout.layout_input_dialog);

        titleEditText = (EditText) dialog.findViewById(R.id.nameTxt);
        authorEditText = (EditText) dialog.findViewById(R.id.authorTxt);

        Button addButton = (Button) dialog.findViewById(R.id.add);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get Data
                Book book = new Book();
                book.setTitle(titleEditText.getText().toString());
                book.setAuthor(authorEditText.getText().toString());

                // Save
                RealmHelper realmHelper = new RealmHelper(realm);
                realmHelper.save(book);
                dialog.dismiss();

                // Refresh
                books = realmHelper.retrieve();
                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,books);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });

        dialog.show();
    }

}
