package kotireddy.onteddu.libraries;


public class DataModel {

    private String teacher_in_the_library;

    public String getTeacherInTheLibrary() { return this.teacher_in_the_library; }

    public void setTeacherInTheLibrary(String teacher_in_the_library) { this.teacher_in_the_library = teacher_in_the_library; }

    private String zip;

    public String getZip() { return this.zip; }

    public void setZip(String zip) { this.zip = zip; }

    private String hours_of_operation;

    public String getHoursOfOperation() { return this.hours_of_operation; }

    public void setHoursOfOperation(String hours_of_operation) { this.hours_of_operation = hours_of_operation; }

    private Website website;

    public Website getWebsite() { return this.website; }

    public void setWebsite(Website website) { this.website = website; }

    private String address;

    public String getAddress() { return this.address; }

    public void setAddress(String address) { this.address = address; }

    private String city;

    public String getCity() { return this.city; }

    public void setCity(String city) { this.city = city; }

    private String phone;

    public String getPhone() { return this.phone; }

    public void setPhone(String phone) { this.phone = phone; }

    private Location location;

    public Location getLocation() { return this.location; }

    public void setLocation(Location location) { this.location = location; }

    private String state;

    public String getState() { return this.state; }

    public void setState(String state) { this.state = state; }

    private String cybernavigator;

    public String getCybernavigator() { return this.cybernavigator; }

    public void setCybernavigator(String cybernavigator) { this.cybernavigator = cybernavigator; }

    private String name_;

    public String getName() { return this.name_; }

    public void setName(String name_) { this.name_ = name_; }




    public class Website
    {
        private String url;

        public String getUrl() { return this.url; }

        public void setUrl(String url) { this.url = url; }
    }

    public class Location
    {
        private String latitude;

        public String getLatitude() { return this.latitude; }

        public void setLatitude(String latitude) { this.latitude = latitude; }

        private boolean needs_recoding;

        public boolean getNeedsRecoding() { return this.needs_recoding; }

        public void setNeedsRecoding(boolean needs_recoding) { this.needs_recoding = needs_recoding; }

        private String longitude;

        public String getLongitude() { return this.longitude; }

        public void setLongitude(String longitude) { this.longitude = longitude; }
    }
}
