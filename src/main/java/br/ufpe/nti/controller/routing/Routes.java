package br.ufpe.nti.controller.routing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Routes
{
    @RequestMapping(value = "/clock", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> getClock()
    {
        DateFormat dateAndTime = new SimpleDateFormat("YYYY/MM/DD HH:mm:ss");
        DateFormat time = new SimpleDateFormat("HH:mm");
        Calendar cal = Calendar.getInstance();
        
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        double angleHour = 0.5 * (60 * (cal.get(Calendar.HOUR) + 1) + cal.get(Calendar.MINUTE));
        double angleMinute = 6 * cal.get(Calendar.MINUTE);
        double angle = Math.abs(angleHour - angleMinute);
        
        JSONObject response = new JSONObject();
        try {
            response.put("id", null);
            response.put("time", time.format(cal.getTime()));
            response.put("createdAt", dateAndTime.format(cal.getTime()));
            response.put("angle", angle);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity<JSONObject>(response, httpHeaders , HttpStatus.OK);
    }
}
