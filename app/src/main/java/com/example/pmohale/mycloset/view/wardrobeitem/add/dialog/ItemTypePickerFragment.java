package com.example.pmohale.mycloset.view.wardrobeitem.add.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by PMohale on 2018/02/09.
 */

public class ItemTypePickerFragment extends DialogFragment {


    private String[] list;

    private String tittle;

    private Bundle arguements;

    public interface ListDialogListener {
        public void onSelectedDialogItem(String value);
    }

    ListDialogListener listDialogListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        arguements = getArguments();
        list = arguements.getStringArray("list");
        tittle = arguements.getString("tittle");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(tittle)
                .setItems(list, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listDialogListener.onSelectedDialogItem(list[which]);
                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listDialogListener = (ListDialogListener) activity;
    }

}
