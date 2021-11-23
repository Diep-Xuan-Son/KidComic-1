package com.example.kidcomic;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.kidcomic.Adapter.MyViewPagerAdapter;
import com.example.kidcomic.Common.Common;
import com.example.kidcomic.Model.Chapter;

public class ViewComicActivity extends AppCompatActivity {

    ViewPager viewPager;
//    RecyclerView recyclerView;
    TextView txt_chapter_name;
    View back,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_comic);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
//        recyclerView = (RecyclerView) findViewById(R.id.view_pager);
        txt_chapter_name = (TextView) findViewById(R.id.txt_chapter_name);
        back = (View) findViewById(R.id.chapter_back);
        next = (View) findViewById(R.id.chapter_next);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Common.chapterIndex == 0)
                    Toast.makeText(ViewComicActivity.this, "You are reading first chapter", Toast.LENGTH_SHORT).show();
                else
                {
                    Common.chapterIndex--;
                    fetchLinks(Common.chapterList.get(Common.chapterIndex));
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Common.chapterIndex == Common.chapterList.size()-1)
                    Toast.makeText(ViewComicActivity.this, "You are reading last chapter", Toast.LENGTH_SHORT).show();
                else
                {
                    Common.chapterIndex++;
                    fetchLinks(Common.chapterList.get(Common.chapterIndex));
                }
            }
        });
        Log.e("size links1 ", String.valueOf(Common.chapterSelected.Links.size()));
        fetchLinks(Common.chapterSelected);
    }

    private void fetchLinks(Chapter chapter) {
        if(chapter.Links != null)
        {
            Log.e("size links2 ", String.valueOf(chapter.Links.size()));
            if(chapter.Links.size() >0 )
            {
                Log.e("size links3 ", String.valueOf(chapter.Links));
                MyViewPagerAdapter adapter = new MyViewPagerAdapter(getBaseContext(), chapter.Links);
                viewPager.setAdapter(adapter);
//                recyclerView.setAdapter(adapter);
                Log.e("size links4 ", String.valueOf(this));

//                txt_chapter_name.setText(Common.formatString(Common.chapterSelected.Name));
//                Log.e("size links5 ", Common.formatString(Common.chapterSelected.Name));
                txt_chapter_name.setText(Common.formatString(chapter.Name));
                Log.e("size links5 ", Common.formatString(chapter.Name));

                //Animation
//                BookFlipPageTransformer bookFlipPageTransformer = new BookFlipPageTransformer();
//                bookFlipPageTransformer.setScaleAmountPercent(10f);
//                viewPager.setPageTransformer(true, bookFlipPageTransformer);
//                Log.e("size links6 ", String.valueOf(chapter.Links.size()));
            }
            else
                Toast.makeText(this, "No image here", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "This chapter is translating...", Toast.LENGTH_SHORT).show();
        }
    }
}