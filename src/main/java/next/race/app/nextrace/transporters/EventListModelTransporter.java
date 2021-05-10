package next.race.app.nextrace.transporters;

import next.race.app.nextrace.models.EventList;

public class EventListModelTransporter {

    private static EventList eventList;

    public static void setEventList(EventList eventList){
        EventListModelTransporter.eventList = eventList;
    }

    public  static EventList getEventList(){
        return eventList;
    }
}
