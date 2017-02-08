package tech42.sathish.realmexample.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import tech42.sathish.realmexample.R;
import tech42.sathish.realmexample.realm.Book;

/**
 * Created by lenovo on 7/2/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private Context context;
    private ArrayList<ArrayList> books;
    private ArrayList<Book> bookArrayList = new ArrayList<>();


    public RecyclerViewAdapter(Context context, ArrayList<ArrayList> books) {
        this.context = context;
        this.books = books;
    }

    public RecyclerViewAdapter(ArrayList<Book> arrayList)
    {
        bookArrayList = arrayList;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.cardview_content_main,parent,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        Book book = bookArrayList.get(position);

        holder.titleTextView.setText(book.getTitle());
        holder.authorTextView.setText(book.getAuthor());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
