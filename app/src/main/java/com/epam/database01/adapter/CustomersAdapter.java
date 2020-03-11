package com.epam.database01.adapter;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.epam.database01.R;
import com.epam.database01.model.Customer;

import static android.provider.Settings.System.getString;

public class CustomersAdapter extends RecyclerView.Adapter<CustomersAdapter.CustomerViewHolder> {
    private List<Customer> customers = new ArrayList<>();

    public void addAll(List<Customer> customers) {
        this.customers = customers;
    }

    public void add(Customer customer) {
        customers.add(customer);
    }

    @NonNull
    @Override
    public CustomersAdapter.CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomersAdapter.CustomerViewHolder holder, int position) {
        Customer customer = customers.get(position);
        holder.surname.setText(customer.getSurname());
        holder.firstName.setText(String.format("%s%s", customer.getFirstName().substring(0, 1), holder.firstName.getText()));
        holder.patronymic.setText(String.format("%s%s", customer.getPatrymonic().substring(0, 1), holder.patronymic.getText()));
        holder.age.append(String.valueOf(customer.getAge()));
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
