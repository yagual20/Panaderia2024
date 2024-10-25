// Generated by view binder compiler. Do not edit!
package com.example.mykotlinlist.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.mykotlinlist.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMapBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button btnMapa;

  @NonNull
  public final SeekBar rangeSeekBar;

  @NonNull
  public final TextView rangeTextView;

  private ActivityMapBinding(@NonNull RelativeLayout rootView, @NonNull Button btnMapa,
      @NonNull SeekBar rangeSeekBar, @NonNull TextView rangeTextView) {
    this.rootView = rootView;
    this.btnMapa = btnMapa;
    this.rangeSeekBar = rangeSeekBar;
    this.rangeTextView = rangeTextView;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMapBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMapBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_map, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMapBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnMapa;
      Button btnMapa = ViewBindings.findChildViewById(rootView, id);
      if (btnMapa == null) {
        break missingId;
      }

      id = R.id.rangeSeekBar;
      SeekBar rangeSeekBar = ViewBindings.findChildViewById(rootView, id);
      if (rangeSeekBar == null) {
        break missingId;
      }

      id = R.id.rangeTextView;
      TextView rangeTextView = ViewBindings.findChildViewById(rootView, id);
      if (rangeTextView == null) {
        break missingId;
      }

      return new ActivityMapBinding((RelativeLayout) rootView, btnMapa, rangeSeekBar,
          rangeTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}