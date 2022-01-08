package com.crepaid.constants;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIs {
    private static final String TAG = "TAG";
    public static OkHttpClient okHttpClient = new OkHttpClient();
    public static boolean sendOtp(String mNumber , int Otp){
        try {
            // Construct data
            String authorization = "key";
            String variables_values = "otp";
            String route="otp";

            String apiKey = "apikey=" + STATIC.TextLocalKey;
            String message = "&message=" + "hello msg ";
            String sender = "&sender=" + "TXTLCL";
            String numbers = "&numbers=" + mNumber;

            // Send data


            okhttp3.RequestBody fr = new FormBody.Builder()
                    .add("message" , "hello msf")
                    .add("rout" , "q")
                    .add("language" , "english")
                    .add("numbers" , "9399846909")
                    .build();
            Request request = new Request.Builder()
                    .url("https://www.fast2sms.com/dev/bulkV2")
                    .addHeader("authorization", "VDjqPl0yek6LQIYTcRJi2wda5mHAtFN8OWGpfsvMr7n1xU3SX9PlN18XaUO7bIQDhBE294VTspRAxjkm")
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .post(fr)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            Log.d(TAG, "sendOtpS: "+response.toString());











//            HttpURLConnection conn = (HttpURLConnection) new URL("https://www.fast2sms.com/dev/bulkV2?").openConnection();
////            String data = apiKey + numbers + message + sender;
//            String data = authorization + variables_values + route;
//            Log.d(TAG, "sendOtp: " +data +" ");
//            conn.setDoOutput(true);
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
//            conn.getOutputStream().write(data.getBytes("UTF-8"));
//            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            final StringBuffer stringBuffer = new StringBuffer();
//            String line;
//            while ((line = rd.readLine()) != null) {
//                stringBuffer.append(line);
//            }
//            rd.close();
//
//            Log.d("TAG", "sendOtp: "+ stringBuffer.toString() );
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            Log.d("TAG", "sendOtpS: "+ e );
        }
        return true;
    }
}
