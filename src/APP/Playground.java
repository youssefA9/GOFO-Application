package APP;

import java.util.ArrayList;

/**
 * Describes the playground and holds it's information
 */
public class Playground {
    protected
    String Name, Location;
    double Size, Price_perHour;
    int Available_Hours = 15, Cancellation_period;
    public boolean Active = true;

    protected String[] Hours = new String[]{"12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00", "16:00-17:00", "17:00-18:00", "18:00-19:00", "19:00-20:00", "20:00-21:00", "21:00-22:00", "22:00-23:00", "23:00-00:00", "00:00-1:00", "1:00-2:00", "2:00-3:00"};
    protected Boolean[] Booked = new Boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

    /**
     * Empty constructor
     */
    public void Playground() {
    }

    /**
     * The constructor is used to assign the information of the playground
     *
     * @param Name
     * @param Location
     * @param Size
     * @param Price_perHour
     * @param Available_Hours
     * @param Cancellation_period
     */
    public void Playground(String Name, String Location, double Size, double Price_perHour, int Available_Hours, int Cancellation_period) {
        this.Name = Name;
        this.Location = Location;
        this.Size = Size;
        this.Price_perHour = Price_perHour;
        this.Available_Hours = Available_Hours;
        this.Cancellation_period = Cancellation_period;


    }

    public boolean isActive() {
        return Active;
    }


    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public double getSize() {
        return Size;
    }

    public void setSize(double Size) {
        this.Size = Size;
    }

    public double getPrice_perHour() {
        return Price_perHour;
    }

    public void setPrice_perHour(double Price_perHour) {
        this.Price_perHour = Price_perHour;
    }

    public int getAvailable_Hours() {
        return Available_Hours;
    }

    public void setAvailable_Hours(int Available_Hours) {
        this.Available_Hours = Available_Hours;
    }

    public int getCancellation_period() {
        return Cancellation_period;
    }

    public void setCancellation_period(int Cancellation_period) {
        this.Cancellation_period = Cancellation_period;
    }

    /**
     * Put the playground information all in one form
     *
     * @return The information of the playground
     */
    public String toString() {
        return ("Playground Name : " + Name + "\n" + "Playground Location : " + Location + "\n" + "Playground Size : " + Size + "\n" + "Playground Price per Hour : " + Price_perHour + "\n" + "Playground Availability : " + Available_Hours + "\n" + "Cancellation Period : " + Cancellation_period);
    }
}