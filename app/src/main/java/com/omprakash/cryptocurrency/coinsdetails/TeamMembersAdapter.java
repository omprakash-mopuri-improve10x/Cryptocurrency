package com.omprakash.cryptocurrency.coinsdetails;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omprakash.cryptocurrency.databinding.TeamMemberItemBinding;
import com.omprakash.cryptocurrency.model.Team;

import java.util.ArrayList;

public class TeamMembersAdapter extends RecyclerView.Adapter<TeamMemberViewHolder> {

    private ArrayList<Team> teams;

    void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TeamMemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TeamMemberItemBinding binding = TeamMemberItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        TeamMemberViewHolder teamMemberViewHolder = new TeamMemberViewHolder(binding);
        return teamMemberViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamMemberViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.binding.setTeam(team);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }
}
