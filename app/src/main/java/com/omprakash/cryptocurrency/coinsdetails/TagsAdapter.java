package com.omprakash.cryptocurrency.coinsdetails;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omprakash.cryptocurrency.databinding.TagItemBinding;
import com.omprakash.cryptocurrency.model.Tag;

import java.util.ArrayList;

public class TagsAdapter extends RecyclerView.Adapter<TagViewHolder> {

    private ArrayList<Tag> tags;

    void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TagItemBinding binding = TagItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        TagViewHolder tagViewHolder = new TagViewHolder(binding);
        return tagViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TagViewHolder holder, int position) {
        Tag tag = tags.get(position);
        holder.binding.setTag(tag);
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }
}
