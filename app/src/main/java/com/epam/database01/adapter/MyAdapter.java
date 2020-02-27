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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomerViewHolder> {
    private LayoutInflater inflater;
    private List<Customer> customers;

    public MyAdapter(Context context, List<Customer> customers) {
        this.inflater = LayoutInflater.from(context);
        this.customers = customers;
    }

    @NonNull
    @Override
    public MyAdapter.CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.items, parent, false);
        return new CustomerViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.CustomerViewHolder holder, int position) {
        Customer customer = customers.get(position);
        holder.surname.append(customer.getSurname() + "  ");
        holder.patronymic.append(customer.getPatrymonic().substring(0, 1) + ". ");
        holder.firstName.append(customer.getFirstName().substring(0, 1) + ".\n");
        holder.age.append("Age: " + customer.getAge() + "\n__________________________________________\n");
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    static class CustomerViewHolder extends RecyclerView.ViewHolder{
        final TextView surname, firstName, patronymic, age;

        CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            surname = itemView.findViewById(R.id.surname_item);
            firstName = itemView.findViewById(R.id.first_name_item);
            patronymic = itemView.findViewById(R.id.patronymic_item);
            age = itemView.findViewById(R.id.age_item);
        }
    }
}
