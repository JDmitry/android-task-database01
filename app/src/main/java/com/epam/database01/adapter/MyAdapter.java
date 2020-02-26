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

    public class MyViewHolder extends RecyclerView.ViewHolder{
        final TextView surname, firstName, patrymonic, age;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            surname = itemView.findViewById(R.id.sur);
            firstName = itemView.findViewById(R.id.fir);
            patrymonic = itemView.findViewById(R.id.pat);
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

        holder.surname.setText(customer.getSurname());
        holder.firstName.setText(customer.getFirstName());
        holder.patrymonic.setText(customer.getPatrymonic());
        holder.age.setText(Integer.toString(customer.getAge()));
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }
}
