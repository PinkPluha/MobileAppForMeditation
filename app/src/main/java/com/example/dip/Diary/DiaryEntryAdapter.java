package com.example.dip.Diary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dip.R;

import java.util.List;

public class DiaryEntryAdapter extends ArrayAdapter<DiaryEntry> {
    private Context context;
    private List<DiaryEntry> diaryEntries;

    public DiaryEntryAdapter(Context context, List<DiaryEntry> diaryEntries) {
        super(context, 0, diaryEntries);
        this.context = context;
        this.diaryEntries = diaryEntries;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_diary_entry, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView dateTextView = convertView.findViewById(R.id.dateTextView);

        DiaryEntry diaryEntry = diaryEntries.get(position);
        titleTextView.setText(diaryEntry.getTitle());
        dateTextView.setText(diaryEntry.getDate());

        return convertView;
    }
}

