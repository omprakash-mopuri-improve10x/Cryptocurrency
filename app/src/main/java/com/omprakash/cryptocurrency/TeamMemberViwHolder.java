package com.omprakash.cryptocurrency;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omprakash.cryptocurrency.databinding.TeamMemberItemBinding;

public class TeamMemberViwHolder extends RecyclerView.ViewHolder {

    TeamMemberItemBinding binding;

    public TeamMemberViwHolder(TeamMemberItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
