package br.ufpe.nti.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class CalendarToResponseEntityFormatter
{
    
    public static ResponseEntity<String> formatCalendar(Calendar cal)
    {        
        DateFormat dateAndTime = new SimpleDateFormat("YYYY/MM/DD HH:mm:ss");
        DateFormat time = new SimpleDateFormat("HH:mm");
        
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        double angle = CalculateAngle.calculate(cal);
        
        JSONObject response = new JSONObject();
        try {
            response.put("id", "null");
            response.put("time", time.format(cal.getTime()));
            response.put("createdAt", dateAndTime.format(cal.getTime()));
            response.put("angle", angle);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity<String>(response.toString(), httpHeaders , HttpStatus.OK);
    }
}
