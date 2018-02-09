package com.example.pmohale.mycloset.view.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by PMohale on 2018/02/09.
 */

public class ItemTypePickerFragment extends DialogFragment {

    private static final String[] colors = {"Red", "Blue", "Orange", "Indigo"};

    public interface ListDialogListener {
        public void onClick(int position);
    }

    ListDialogListener listDialogListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick the item type")
                .setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listDialogListener.onClick(which);

                    }
                });
        return builder.create();
    }

}
