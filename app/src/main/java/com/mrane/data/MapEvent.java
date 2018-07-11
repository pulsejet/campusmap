package com.mrane.data;

public class MapEvent {
	private int id;
	private String title;
	private String venue;
	private String date;
	private String time;
	private String header;
	private String description;

	public MapEvent(int id, String title, String venue, String date,
			String time, String header, String description) {
		this.id = id;
		this.title = title;
		this.venue = venue;
		this.date = date;
		this.time = time;
		this.header = header;
		this.description = description;
	}

    public String getTitle() {
		return title;
	}

    public String getVenue() {
		return venue;
	}

    public String getDate() {
		return date;
	}

    public String getTime() {
		return time;
	}

    public String getHeader() {
		return header;
	}

    public String getDescription() {
		return description;
	}

}
