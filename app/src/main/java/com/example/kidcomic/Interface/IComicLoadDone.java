package com.example.kidcomic.Interface;

import com.example.kidcomic.Model.Comic;

import java.util.List;

public interface IComicLoadDone {
    void onComicLoadDoneListener(List<Comic> comicList);
}
