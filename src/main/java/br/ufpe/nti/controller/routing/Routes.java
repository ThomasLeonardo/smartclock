package br.ufpe.nti.controller.routing;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.ufpe.nti.util.*;

@RestController
public class Routes
{
    
    @RequestMapping(value = "/clock", method = RequestMethod.GET)
    public ResponseEntity<String> getClock()
    {
        Calendar cal = Calendar.getInstance();
        return CalendarToResponseEntityFormatter.formatCalendar(cal);
    }
    
    @RequestMapping(value = "/clock", method = RequestMethod.POST)
    public ResponseEntity<String> postClock(@RequestParam String time)
    {
        LocalTime inputTime = LocalTime.parse(time);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, inputTime.getHour());
        cal.set(Calendar.MINUTE, inputTime.getMinute());
        return CalendarToResponseEntityFormatter.formatCalendar(cal);
    }
    
}
