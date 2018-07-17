package com.bignerdranch.android.criminalintent;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;


public class PictureFragment extends DialogFragment {

    public final static String ARG_PHOTO_PATH = "photo";

    private ImageView mImageView;

    public static PictureFragment newInstance(String photoPath){
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO_PATH, photoPath);

        PictureFragment fragment = new PictureFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        String photoPath = getArguments().getString(ARG_PHOTO_PATH);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_picture, null);

        Bitmap bitmap = PictureUtils.getScaledBitmap(photoPath, getActivity());

        mImageView = (ImageView) v.findViewById(R.id.dialog_picture);
        mImageView.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity()).setView(v).create();

    }
}
