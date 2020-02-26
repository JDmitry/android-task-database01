package com.epam.database01.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.epam.database01.R;
import com.epam.database01.model.Customer;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private List<Customer> customers;

    public MyAdapter(Context context, List<Customer> customers) {
        this.inflater = LayoutInflater.from(context);
        this.customers = customers;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        final TextView surname, firstName, patronymic, age;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            surname = itemView.findViewById(R.id.sur);
            firstName = itemView.findViewById(R.id.fir);
            patronymic = itemView.findViewById(R.id.pat);
            age = itemView.findViewById(R.id.age);
        }
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.items, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Customer customer = customers.get(position);
        holder.surname.append(customer.getSurname() + "  ");
        holder.patronymic.append(customer.getPatrymonic().substring(0, 1) + ". ");
        holder.firstName.append(customer.getFirstName().substring(0, 1) + ". ");
        holder.age.append("\nAge: " + customer.getAge() + "\n*******************\n");
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }
}
