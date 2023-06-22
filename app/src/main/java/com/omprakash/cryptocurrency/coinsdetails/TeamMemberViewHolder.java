package com.omprakash.cryptocurrency.coinsdetails;

import androidx.recyclerview.widget.RecyclerView;

import com.omprakash.cryptocurrency.databinding.TeamMemberItemBinding;

public class TeamMemberViewHolder extends RecyclerView.ViewHolder {

    TeamMemberItemBinding binding;

    public TeamMemberViewHolder(TeamMemberItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
