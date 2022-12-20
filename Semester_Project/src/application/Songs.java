package application;

import javax.swing.JOptionPane;

public class Songs {
	
	private String title;
	private String artist;
	private int lengthm;
	private int lengths;
	private int rating;

	public Songs() {
		this.title = "";
		this.artist = "";
		this.lengthm = 0;
		this.lengths = 0;
		this.rating = 0;
		
		

	}
	
	public Songs(String title, String artist, int lengthm, int lengths, int rating) {
		
		this.title = title;
		this.artist = artist;
		this.lengthm = lengthm;
		this.lengths = lengths;
		this.rating = rating;
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
    public String getArtist() {
    	return artist;
	}
    
    public void setArtist(String artist) {
    	this.artist = artist;
    }

    public double getLengthm() {
    	return lengthm;
    }
    
    public void setLengthm(int lengthm) {
    	
if(lengthm >= 0) {
	this.lengthm = lengthm;
			
    	}
		else {
			JOptionPane.showMessageDialog(null, "Minutes must be at least 0","Problem!", JOptionPane.INFORMATION_MESSAGE);
			
		}
    }

    public double getLengths() {
    	return lengths;
    }
    
    public void setLengths(int lengths) {
    	
if(lengths >= 0 && lengths <= 59) {
	this.lengths = lengths;
			
    	}
		else {
			JOptionPane.showMessageDialog(null, "Seconds must be between 0 and 59","Problem!", JOptionPane.INFORMATION_MESSAGE);
			
		}
    }
    public int getRating() {
    		return rating;			
    }
    
    public void setRating(int rating) {
			if(rating >= 0 && rating <= 5) {
				
				this.rating = rating;
	    	}
			else {
				JOptionPane.showMessageDialog(null, "Rating must be between 0 and 5","Problem!", JOptionPane.INFORMATION_MESSAGE);
				
			}
    }
	
}
