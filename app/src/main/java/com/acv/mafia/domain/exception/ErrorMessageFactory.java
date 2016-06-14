package com.acv.mafia.domain.exception;

import android.content.Context;

import com.acv.mafia.R;

public class ErrorMessageFactory {

  private ErrorMessageFactory() {}


  public static String create(Context context, Exception exception) {
    String message = context.getString(R.string.exception_message_generic);

    return message;
  }
}
