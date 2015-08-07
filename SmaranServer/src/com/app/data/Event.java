package com.app.data;

import java.util.Date;

import com.google.gson.Gson;

public class Event {

	private EventType event;
	private String person;
	private Date eventDate;
	private String remindDate;
	private String remindTime;
	private String remindMode;
	
	public Event(EventType event, String person, Date eventDate, String remindDate, String remindTime, String remindMode) {
		this.event = event;
		this.person = person;
		this.eventDate = eventDate;
		this.remindDate = remindDate;
		this.remindTime = remindTime;
		this.remindMode = remindMode;
	}
	
	public EventType getEvent() {
		return event;
	}
	public void setEvent( String event ){
		this.event = EventType.valueOf(event);
	}
	public void setEvent(EventType event) {
		this.event = event;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getRemindDate() {
		return remindDate;
	}
	public void setRemindDate(String remindDate) {
		//this.remindDate = DateTimeFormat.forPattern("MM/dd/yyyy").parseDateTime(eventDate+"/"+DateTime.now().year()).toDate();
		this.remindDate = remindDate;
	}
	public String getRemindTime() {
		return remindTime;
	}
	public void setRemindTime(String remindTime) {
		this.remindTime = remindTime;
	}
	public String getRemindMode() {
		return remindMode;
	}
	public void setRemindMode(String remindMode) {
		this.remindMode = remindMode;
	}
	public void fromJson( String json ){
		Gson gson = new Gson();
		Event parsedEvent = gson.fromJson(json, this.getClass());
		this.event = parsedEvent.getEvent();
		this.person = parsedEvent.getPerson();
		this.eventDate = parsedEvent.getEventDate();
		this.remindDate = parsedEvent.getRemindDate();
		this.remindTime = parsedEvent.getRemindTime();
		this.remindMode = parsedEvent.getRemindMode();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result
				+ ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (event != other.event)
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Event [event=" + event + ", person=" + person + ", eventDate="
				+ eventDate + ", remindDate=" + remindDate + ", remindTime="
				+ remindTime + ", remindMode=" + remindMode + "]";
	}
}