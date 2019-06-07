
package com.reactlibrary;


import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.IllegalViewOperationException;

import java.util.Map;
import java.util.HashMap;

public class RNKeyboardLibraryModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNKeyboardLibraryModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNKeyboardLibrary";
  }

  @Override
  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();
    return constants;
  }

  @ReactMethod
  public void open(){
    Activity activity = getCurrentActivity();
    if (activity != null) {
      InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
      imm.toggleSoftInput(0, InputMethodManager.HIDE_IMPLICIT_ONLY); // show
    }
  }

  @ReactMethod
  public void getStatus(final Promise promise) {
    Activity activity = getCurrentActivity();
    if (activity != null) {
      InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
      if (imm.isActive()) {
        promise.resolve("OPEN");
        return;
      }
    }
    promise.resolve("CLOSED");
  }
  @ReactMethod
  public void isOpen(final Promise promise) {
    try {
      Activity activity = getCurrentActivity();
      if (activity != null) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
          promise.resolve(true);
          return;
        }
      }
      promise.resolve(false);
    } catch (IllegalViewOperationException e) {
      promise.resolve(false);
    }
  }

  @ReactMethod
  public void closed(){
    Activity activity = getCurrentActivity();
    if (activity != null) {
      InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
      imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0); // hide
    }
  }

  @ReactMethod
  public void toggle(){
    Activity activity = getCurrentActivity();
    if (activity != null) {
      InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
      if (imm.isActive()) {
        closed();
      } else {
        open();
      }
    }
  }

}