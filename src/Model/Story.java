package Model;

public class Story {
    private Event[] allEvents = new Event[0];


    public void insertNewEvent() {
        Event[] tmpEventArr = new Event[allEvents.length + 1];
        for (int i = 0; i < allEvents.length; i++) {
            tmpEventArr[i] = allEvents[i];
        }
        tmpEventArr[tmpEventArr.length - 1] = new Event();
        allEvents = tmpEventArr;
    }

    public void deleteEventByIndex(int index) {
        if (index < allEvents.length && index >= 0) {
            Event[] tmpEventArr = new Event[allEvents.length - 1];
            int x = 0;
            for (int i = 0; i < tmpEventArr.length; i++) {
                if (i == index) x = 1;
                tmpEventArr[i] = allEvents[i + x];
            }
            allEvents = tmpEventArr;
        }
    }

    public Event[] getAllEvents() {
        return allEvents;
    }
}
